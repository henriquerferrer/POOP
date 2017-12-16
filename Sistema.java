package poop;

import java.util.ArrayList;
import java.util.Collections;

public class Sistema {
	private ArrayList<Inscricao> inscricoes;
	private ArrayList<Local> locais;
	private ArrayList<Pessoa> pessoas;
	private GestorBaseDados gestorBD;
	private final int percentagemGuestList = 10;
	private final double discontoEstExposicao = 0.1;
	 
	@SuppressWarnings("unchecked")
	public Sistema() {
		this.gestorBD = new GestorBaseDados();
		this.inscricoes = gestorBD.loadInscricoes();
		this.locais = gestorBD.loadLocais();
		this.pessoas = gestorBD.loadPessoas();
		
		Collections.sort(inscricoes);
	}
	
	//TODO
	//CONFIRM THAT YOU ARE NOT CREATING THE SAME PEOPLE OR LOCAL TWICE
	
	public void criarProfessor(TipoProfessor tipoProfessor, String nome, String numCc, String password, Perfil perfil) {
		Professor p = new Professor(tipoProfessor, nome, numCc, password, perfil);
		pessoas.add(p);
		gestorBD.savePessoa(p);
	}
	
	public void criarFuncionario(TipoFuncionario tipoFuncionario, String nome, String numCc, String password, Perfil perfil) {
		Funcionario f = new Funcionario( tipoFuncionario, nome, numCc, password, perfil);
		pessoas.add(f);
		gestorBD.savePessoa(f);
	}
	
	public void criarEstudante(CursoDei curso , String nome, String numCc, String password, Perfil perfil) {
		Estudante e = new Estudante( curso , nome, numCc, password, perfil);
		pessoas.add(e);
		gestorBD.savePessoa(e);
	}
	
	public void criarBar(String coordenadas, int lotacao, double consumoMinimo) {
		Bar b = new Bar( coordenadas, lotacao, consumoMinimo);
		locais.add(b);
		gestorBD.saveLocal(b);
	}
	
	public void criarExposicao(String coordenadas, String formaArtistica, double custoBilhete) {
		Exposicao e = new Exposicao(coordenadas, formaArtistica, custoBilhete);
		locais.add(e);
		gestorBD.saveLocal(e);
	}
	
	public void criarJardim(String coordenadas, double area) {
		Jardim j = new Jardim(coordenadas, area);
		locais.add(j);
		gestorBD.saveLocal(j);
	}
	
	public void criarAreaDesportiva(String coordenadas, ArrayList<String> desportos) {
		AreaDesportiva a = new AreaDesportiva(coordenadas, desportos);
		locais.add(a);
        gestorBD.saveLocal(a);
	}
	
	public ArrayList<Local> getLocais() {
		return locais;
	}
	
	public int getLotacaoDeBar(Bar bar) {
		return bar.getLotacao();
	}
	
	public ArrayList<Pessoa> getIncritosEmLocal(Local local){
		ArrayList<Pessoa> helper = new ArrayList<Pessoa>(); 
		for(int i = 0; i < inscricoes.size(); i++) {
			if (inscricoes.get(i).getLocal().equals(local)) {
				helper.add(inscricoes.get(i).getPessoa());
			}
		}
		return helper;
	}
	
	public boolean increverPessoa(Pessoa pessoa, Local local) {
		int numInscricoes = 0;
		for(int i = 0; i < inscricoes.size(); i++) {
			if(inscricoes.get(i).getPessoa().equals(pessoa)) {			
				if(numInscricoes + 1 > 5) {
					return false; //Quer dizer que ja te inscreveste em 5 locais e nao podes inscrever e mais nenhum
				}
				numInscricoes++;
			}

			if(inscricoes.get(i).getPessoa().equals(pessoa) && inscricoes.get(i).getLocal().equals(local)) {
				return false;
			}
			
			if(inscricoes.get(i).getLocal().isBar() && ((Bar)local).getLotacao() < getNInscritosLocal(local)) {
				return false;	
			}
		}
		Inscricao i = new Inscricao(pessoa, local, inscricoes.size());
		inscricoes.add(i);
		gestorBD.saveInscricao(i);
		return true;
	}
	
	public ArrayList<Local> getLocaisOrdenados() {
		int counter = 0, max = -1;
		ArrayList<Local> helperLocais = new ArrayList<Local>();
		ArrayList<Local> finalLocais = new ArrayList<Local>();
		ArrayList<Integer> helperInscritos = new ArrayList<Integer>();
		
		for(int i = 0; i < locais.size(); i++) {
			for(int p = 0; p < inscricoes.size(); p++) {
				if(locais.get(i).equals(inscricoes.get(p).getLocal())) {
					counter++;
				}
			}
			helperLocais.add(locais.get(i));
			helperInscritos.add(counter);
			counter = 0;
		}
		
		//Ha alternativa
		for(Integer o: helperInscritos) {	
			if(o > max) {
				max = o;
			}
		}
		
		while(finalLocais.size() < locais.size()) {
			for(int g = 0; g < helperInscritos.size(); g++) {
				if(helperInscritos.get(g) == max) {
					finalLocais.add(helperLocais.get(g));
				}
			}
			int maxHelper = -1;
			for(int o = 0; 0 < helperInscritos.size(); o++) {
				if(helperInscritos.get(o) > maxHelper && helperInscritos.get(o) < max) {
					maxHelper = helperInscritos.get(o);
				}
			}
			max = maxHelper;
		}
		return finalLocais;
		//Alternativa 'listToSort.sort(Comparator.comparing(listWithOrder::indexOf));'
	}
	
	//TODO: Add polimorfism to this. Remeber to remove the discounts with students and expositions
	public double getMinReceitas() {
		double finalReceitas = 0;
		for(int p = 0; p < inscricoes.size(); p++) {
			if(inscricoes.get(p).getLocal().isBar()) {
				finalReceitas += inscricoes.get(p).getLocal().getCustoMinimo();
			}
			if(inscricoes.get(p).getLocal().isExposicao() && inscricoes.get(p).getPessoa().isEstudante()) {
				finalReceitas += inscricoes.get(p).getLocal().getCustoMinimo() * (1-discontoEstExposicao);
			}
		}
		return finalReceitas;
	}
	
	public int getGuestListSize(Bar bar) {
		int limiteTamanho = (int)bar.getLotacao()*(percentagemGuestList/100);
		return limiteTamanho;
	}
	
	public ArrayList<Pessoa> getGuestList(Bar bar){
		ArrayList<Pessoa> finalGuestList = new ArrayList<Pessoa>();
		int limiteTamanho = getGuestListSize(bar), tamanhoAtual=0;
		
		for(int p = 0; p < inscricoes.size(); p++) {
			if(limiteTamanho > tamanhoAtual) {	
				if(inscricoes.get(p).getLocal().equals(bar) && 
				inscricoes.get(p).getPessoa().getPerfil() == Perfil.BOEMIO) {
					finalGuestList.add(inscricoes.get(p).getPessoa());
					tamanhoAtual++;
				}
			}
			else {
				break;
			}
		}
		
		for(int p = 0; p < inscricoes.size(); p++) {
			if(limiteTamanho > tamanhoAtual) {
				if(inscricoes.get(p).getLocal().equals(bar) && 
				!(inscricoes.get(p).getPessoa().getPerfil() == Perfil.BOEMIO)){
					finalGuestList.add(inscricoes.get(p).getPessoa());
					tamanhoAtual++;
				}
			}
			else {
				break;
			}
		}
		return finalGuestList;
	}

	public boolean isPlaceFull(Local place){
		int counter = 0;
		if(place.isBar()) {
			for(int p = 0; p < inscricoes.size(); p++) {
				if(inscricoes.get(p).getLocal().equals(place)) {
					if(counter < ((Bar)place).getLotacao()) {
						counter++;
					}
					else {
						return true;
					}
				}
			}
		}
		else{
			return false;
		}
		return false;
	}
	
	private int getNInscritosLocal(Local l) {
		int counter = 0;
		for(int i = 0; i < inscricoes.size(); i++) {
			if(inscricoes.get(i).getLocal().equals(l)) {
				counter++;
			}
		}
		return counter;
	}
	
	private int getNInscritosBar(Bar bar) {
		return getNInscritosLocal(bar);
	}
	
	public int contarInscricoes(Pessoa pessoa) {
		int counter = 0;
		for(int p = 0; p < inscricoes.size(); p++) {
			if(inscricoes.get(p).getPessoa().equals(pessoa)) {
				counter++;
			}
		}
		return counter;
	}
	
	public ArrayList<Local> getLocaisInscritos(Pessoa pessoa) {
		ArrayList<Local> helper = new ArrayList<Local>();
		for(int i = 0; i < inscricoes.size(); i++) {
			if (inscricoes.get(i).getPessoa().equals(pessoa)) {
				helper.add(inscricoes.get(i).getLocal());
			}
		}
		return helper;
	}
}

package poop;

import java.util.ArrayList;

public class Sistema {
	private ArrayList<Inscricao> inscricoes;
	private ArrayList<Local> locais;
	private ArrayList<Pessoa> pessoas;
	private GestorBaseDados gestorBD;
	
	public Sistema() {
		this.inscricoes = new ArrayList<Inscricao>();
		this.locais = new ArrayList<Local>();
		this.pessoas = new ArrayList<Pessoa>();
		this.gestorBD = new GestorBaseDados();
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
			if (inscricoes.get(i).getLocal().getCoordenadas()== local.getCoordenadas()) {
				helper.add(inscricoes.get(i).getPessoa());
			}
		}
		return helper;
	}
	
	private int getNIncritosBar(Bar bar) {
		int counter = 0;
		for(int i = 0; i < inscricoes.size(); i++) {
			if(inscricoes.get(i).getLocal() == bar) {
				counter = counter + 1;
			}
		}
		return counter;
	}
	
	public boolean increverPessoa(Pessoa pessoa, Local local) {
		int numInscricoes = 0;
		for(int i = 0; i < inscricoes.size(); i++) {
			if(inscricoes.get(i).getPessoa().equals(pessoa)) {
				numInscricoes += 1;				
				if(numInscricoes >= 5) {
					return false; //Quer dizer que ja te inscreveste em 5 locais e nao podes inscrever e mais nenhum
				}
			}
			
			if(inscricoes.get(i).getPessoa() == pessoa && inscricoes.get(i).getLocal().equals(local)) {
				return false;
			}
			
			if(inscricoes.get(i).getLocal().isBar() && ((Bar)local).getLotacao() < getNIncritosBar((Bar)local)) {
			 return false;	
			}
			
		}
		Inscricao i = new Inscricao(pessoa, local);
		inscricoes.add(i);
		gestorBD.saveInscricao(i);
		return true;
	}
	
	public ArrayList<Local> getLocaisOrdenados() {
		int counter = 0, max = 0, diff = 0, index = -1;
		Local someLocal = null;
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
		
		for(int z = 0; z < helperLocais.size(); z++) {
			for(int g = 0; g < helperInscritos.size(); g++) {
				if(helperInscritos.get(g) == max) {
					if(helperLocais.get(g).equals(someLocal)) {
						continue;
					}
					else {
						finalLocais.add(helperLocais.get(g));
						someLocal = helperLocais.get(g);
						max = helperInscritos.get(g);
					}
				}
			}
			int maxHelper =0;
			for(int o = 0; 0 < helperInscritos.size(); o++) {
				diff = max - helperInscritos.get(o);
				if(helperInscritos.get(o) > maxHelper && diff > 0) {
					maxHelper = helperInscritos.get(o);
				}
				if(helperInscritos.get(o) > maxHelper && diff == 0) {
					if(o > index) {
						maxHelper = helperInscritos.get(o);
						index = o; 
					}
				}
			}
			max = maxHelper;
		}
		return finalLocais;
		//Alternativa 'listToSort.sort(Comparator.comparing(listWithOrder::indexOf));'
	}
	
	public double getMinReceitas() {
		double finalReceitas = 0;
		for(int p = 0; p < inscricoes.size(); p++) {
				if(inscricoes.get(p).getLocal().isBar()) {
					finalReceitas += inscricoes.get(p).getLocal().getCustoMinimo();
				}
				if(inscricoes.get(p).getLocal().isExposicao() && inscricoes.get(p).getPessoa().isEstudante()) {
					finalReceitas += inscricoes.get(p).getLocal().getCustoMinimo()*0.9;
				}
		}
		return finalReceitas;
	}
	
	public int getGuestListSize(Bar bar) {
		int percentagem = 10;
		int limiteTamanho = (int)bar.getLotacao()*(percentagem/100);
		return limiteTamanho;
	}
	
	public ArrayList<Pessoa> getGuestList(Bar bar){
		ArrayList<Pessoa> finalGuestList = new ArrayList<Pessoa>();
		//Preciso de saber a percetagem da lotacao para fazer o tamanho maximo da guest list 
		int limiteTamanho = getGuestListSize(bar), tamanhoAtual=0;
		
		for(int p = 0; p < inscricoes.size(); p++) {
			if(limiteTamanho > tamanhoAtual) {	
				if(inscricoes.get(p).getLocal().equals(bar)){
					if(inscricoes.get(p).getPessoa().getPerfil() == Perfil.BOEMIO) {
						finalGuestList.add(inscricoes.get(p).getPessoa());
						tamanhoAtual++;
					}
				}
			}
			else {
				break;
			}
		}
		
		for(int p = 0; p < inscricoes.size(); p++) {
			if(limiteTamanho > tamanhoAtual) {
				if(inscricoes.get(p).getLocal().equals(bar)){
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
}

package poop;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe de Sistema que gere a lógica da plataforma
 * @author JoaquimFerrer Henrique Ferrer
 */
public class Sistema {
	private ArrayList<Inscricao> inscricoes;
	private ArrayList<Local> locais;
	private ArrayList<Pessoa> pessoas;
	private GestorBaseDados gestorBD;
	private final int percentagemGuestList = 10;
	private final double discontoEstExposicao = 0.1;
	private final int numeroMaximoInsxcricoes = 5;
	 
	/**
	 *
	 */
	@SuppressWarnings("unchecked")
	public Sistema() {
		this.gestorBD = new GestorBaseDados();
		this.inscricoes = gestorBD.loadInscricoes();
		this.locais = gestorBD.loadLocais();
		this.pessoas = gestorBD.loadPessoas();
		
		//Faz sort por ID (Data de criaçao)
		Collections.sort(inscricoes);
	}
	
	//TODO
	//CONFIRM THAT YOU ARE NOT CREATING THE SAME PEOPLE OR LOCAL TWICE

	/**
	 *Cria um professor
	 * @param tipoProfessor Tipo de professor.
	 * @param nome Nome.
	 * @param numCc Número de cartão de cidadão.
	 * @param password Password para a plataforma.
	 * @param perfil Perfil.
	 */
	
	public void criarProfessor(TipoProfessor tipoProfessor, String nome, String numCc, String password, Perfil perfil) {
		Professor p = new Professor(tipoProfessor, nome, numCc, password, perfil);
		pessoas.add(p);
		gestorBD.savePessoa(p);
	}
	
	/**
	 * Cria um Funcionário
	 * @param tipoFuncionario Tipo de funcionário.
	 * @param nome Nome.
	 * @param numCc Número de cartão de cidadão.
	 * @param password Password usada para a plataforma
	 * @param perfil Perdil.
	 */
	public void criarFuncionario(TipoFuncionario tipoFuncionario, String nome, String numCc, String password, Perfil perfil) {
		Funcionario f = new Funcionario( tipoFuncionario, nome, numCc, password, perfil);
		pessoas.add(f);
		gestorBD.savePessoa(f);
	}
	
	/**
	 * Cria um Estudante
	 * @param curso Curso do estudante.
	 * @param nome Nome.
	 * @param numCc Número de cartão de cidadão.
	 * @param password Password usada para a plataforma.
	 * @param perfil Perfil.
	 */
	public void criarEstudante(CursoDei curso , String nome, String numCc, String password, Perfil perfil) {
		Estudante e = new Estudante( curso , nome, numCc, password, perfil);
		pessoas.add(e);
		gestorBD.savePessoa(e);
	}
	
	/**
	 * Cria um Bar
	 * @param coordenadas Coordenadas do Local.
	 * @param lotacao Lotaçao máxima do bar.
	 * @param consumoMinimo Consumo mínimo para entrar no bar.
	 */
	public void criarBar(String coordenadas, int lotacao, double consumoMinimo) {
		Bar b = new Bar( coordenadas, lotacao, consumoMinimo);
		locais.add(b);
		gestorBD.saveLocal(b);
	}
	
	/**
	 * Cria uma exposição.
	 * @param coordenadas Coordenadas do local.
	 * @param formaArtistica Forma artística da exposição.
	 * @param custoBilhete Custo de cada builhete para a exposição.
	 */
	public void criarExposicao(String coordenadas, String formaArtistica, double custoBilhete) {
		Exposicao e = new Exposicao(coordenadas, formaArtistica, custoBilhete);
		locais.add(e);
		gestorBD.saveLocal(e);
	}
	
	/**
	 * Cria um Jardim.
	 * @param coordenadas Coordenadas do Local.
	 * @param area Área do jardim.
	 */
	public void criarJardim(String coordenadas, double area) {
		Jardim j = new Jardim(coordenadas, area);
		locais.add(j);
		gestorBD.saveLocal(j);
	}
	
	/**
	 * Cria uma área desportiva
	 * @param coordenadas Coordenadas do Local.
	 * @param desportos Desportos que se praticam na área desportiva.
	 */
	public void criarAreaDesportiva(String coordenadas, ArrayList<String> desportos) {
		AreaDesportiva a = new AreaDesportiva(coordenadas, desportos);
		locais.add(a);
        gestorBD.saveLocal(a);
	}
	
	/**
	 * Retorna os locais possiveis
	 * @return Locais
	 */
	public ArrayList<Local> getLocais() {
		return locais;
	}
	
	/**
	 * Retorna a locatação máxima dum bar.
	 * @param bar Bar.
	 * @return
	 */
	public int getLotacaoDeBar(Bar bar) {
		return bar.getLotacao();
	}
	
	/**
	 * Retorna pessoas inscritas no local. A ordem é não é especificada.
	 * @param local Local.
	 * @return Pessoas inscritas no local.
	 */
	public ArrayList<Pessoa> getIncritosEmLocal(Local local){
		ArrayList<Pessoa> helper = new ArrayList<Pessoa>(); 
		for(int i = 0; i < inscricoes.size(); i++) {
			if (inscricoes.get(i).getLocal().equals(local)) {
				helper.add(inscricoes.get(i).getPessoa());
			}
		}
		return helper;
	}
	
	/**
	 * Cria uma inscrição duma pessoa num local. Verifica se a pessoa já tem 5 inscrições, se já tem uma inscrição nesse Local, ou se o sítio onde se vai inscrever está cheio.
	 * @param pessoa Pessoa que se está a inscrever.
	 * @param local Local onde se vai inscrever.
	 * @return Se a inscrição foi bem sucedida.
	 */
	public boolean increverPessoa(Pessoa pessoa, Local local) {
		int numInscricoes = 0;
		for(int i = 0; i < inscricoes.size(); i++) {
			if(inscricoes.get(i).getPessoa().equals(pessoa)) {			
				if(numInscricoes + 1 > numeroMaximoInsxcricoes) {
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
	
	/**
	 * Retorna os locais ordenados por número de isncrições que têm. Utiliza um selection sort.
	 * @return Locais ordenados.
	 */
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
			for(int o = 0; o < helperInscritos.size(); o++) {
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

	/**
	  Obtém as receitas das inscrições feitas até à data.
	 * @return Valor das receitas.
	 */
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
	
	/**
	 * Obtém o tamanho da guest list dum bar.
	 * @param bar
	 * @return Tamanho da guest list.
	 */
	public int getGuestListSize(Bar bar) {
		int limiteTamanho = (int)bar.getLotacao()*(percentagemGuestList/100);
		return limiteTamanho;
	}
	
	/**
	 * Gera a guest list dum bar. Dá prioridade a pessoas com perfil boémio e depois a pessoas que se inscreveram antes.
	 * @param bar Bar
	 * @return Pessoas na Guest list.
	 */
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

	/**
	 * Verifica se um sítio não pode conter mais inscrições
	 * @param place Local
	 * @return Se não pode conter mais inscrições.
	 */
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
	
	/**
	 * Retorna o número de inscritos num local.
	 * @param l Local
	 * @return Número de inscritos.
	 */
	public int getNInscritosLocal(Local l) {
		int counter = 0;
		for(int i = 0; i < inscricoes.size(); i++) {
			if(inscricoes.get(i).getLocal().equals(l)) {
				counter++;
			}
		}
		return counter;
	}
	
	/**
	 * Conta isncrições duma Pessoa
	 * @param pessoa Pessoa
	 * @return Número de inscrições.
	 */
	public int contarInscricoes(Pessoa pessoa) {
		int counter = 0;
		for(int p = 0; p < inscricoes.size(); p++) {
			if(inscricoes.get(p).getPessoa().equals(pessoa)) {
				counter++;
			}
		}
		return counter;
	}
	
	/**
	 *	Retorna os Locais em que uma pessoa se inscreveu.
	 * @param pessoa Pessoa.
	 * @return Lista de locais inscritos.
	 */
	public ArrayList<Local> getLocaisInscritos(Pessoa pessoa) {
		ArrayList<Local> helper = new ArrayList<Local>();
		for(int i = 0; i < inscricoes.size(); i++) {
			if (inscricoes.get(i).getPessoa().equals(pessoa)) {
				helper.add(inscricoes.get(i).getLocal());
			}
		}
		return helper;
	}
	
	/**
	 * Descobre uma pessoa a quem pertença um numero de cartao de cidadão. Caso não exista retorna null. 
	 * @param numCC Número de cartão de cidadão.
	 * @return Pessoa ou null se numCC não existir.
	 */
	public Pessoa getPessoaByCC(String numCC) {
		for(Pessoa p : pessoas) {
			if(p.getNumCc().equals(numCC)){
				return p;
			}
		}
		return null;
	}
	
	/**
	 * Verifica se a Pessoa associada a um número de cartão de cidadão tem a sua password igual à password passada.
	 * @param numCC Número de cartão de cidadão.
	 * @param password Password
	 * @return Pessoa ou null se o número de cartão de cidadão não corresponder à password.
	 */
	public Pessoa autenticar(String numCC, String password) {
		Pessoa p = getPessoaByCC(numCC);
		if(p == null) {
			return null;
		}
		if(p.getPassword().equals(password)) {
			return p;
		}
		return null;
	}
}

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
	/*
	public ArrayList<Pessoa> getIncritosEmLocal(Local local){
		ArrayList<Pessoa> helper = new ArrayList<Pessoa>(); 
		for(int i = 0; i < inscricoes.size(); i++) {
			if (inscricoes.get(i).getLocal().getCoordenadas()== local.getCoordenadas()) {
				helper.add(inscricoes.get(i).getPessoa());
			}
		}
		return helper;
	}
	
	private inscritosBar()
	
	public boolean increverPessoa(Pessoa pessoa, Local local) {
		int barCounter = 0, numInscricoes = 0;
		for(int i = 0; inscricoes.size(); i++) {
			if(inscricoes.get(i).getPessoa() == pessoa) {
				numInscricoes += 1;				
				if(numInscricoes >= 5) {
					return false; //Quer dizer que ja te inscreveste em 5 locais e nao podes inscrever e mais nenhum
				}
			}
			
			if(inscricoes.get(i).getPessoa() == pessoa && inscricoes.get(i).getLocal() == local) {
				return false;
			}
			
			if(inscricoes.get(i).getLocal().isBar() && local.getLotacao() > )
			
		}
		
		return true;
	}
	*/
}

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
		new Professor(tipoProfessor, nome, numCc, password, perfil);
	}
	
	public void criarFuncionario(TipoFuncionario tipoFuncionario, String nome, String numCc, String password, Perfil perfil) {
		new Funcionario( tipoFuncionario, nome, numCc, password, perfil);
	}
	
	public void criarEstudante(CursoDei curso , String nome, String numCc, String password, Perfil perfil) {
		new Estudante( curso , nome, numCc, password, perfil);
	}
	
	public void criarBar(String coordenadas, int lotacao, double consumoMinimo) {
		new Bar( coordenadas, lotacao, consumoMinimo);
	}
	
	public void criarExposicao(String coordenadas, String formaArtistica, double custoBilhete) {
		new Exposicao(coordenadas, formaArtistica, custoBilhete);
	}
	
	public void criarJardim(String coordenadas, double area) {
		new Jardim(coordenadas, area);
	}
	
	public void criarAreaDesportiva(String coordenadas, ArrayList<String> desportos) {
		new AreaDesportiva(coordenadas, desportos);
	}
}

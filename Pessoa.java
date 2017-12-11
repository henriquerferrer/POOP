
public abstract class Pessoa {
	private String nome;
	private String numCc;
	private String password;
	private Perfil perfil;
	private String StringPerfil;
	private double discontoEmExibicoes;

	public Pessoa(String nome, String numCc, String password, Perfil perfil) {
		this.setNome(nome);
		this.numCc = numCc;
		this.password = password;
		this.perfil = perfil;
	}
	
	public boolean isEstudante() {
		return false;
	}
	

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNumCc() {
		return this.numCc;
	}

	public void setNumCc(String numCc) {
		this.numCc = numCc;
	}
	
	private String getPassword() {
		return this.password;
	}

	private void setPassword(String password) {
		this.password = password;
	}
	
	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public String perfilToStr() {
		return this.perfil.toString();
	}
	
	public String getGuestListFormat() {
		return this.nome + " " + this.perfil;
	}
	
	public static void main(String [] args) {
		Funcionario f = new Funcionario(TipoFuncionario.PARTTIME, "Joao", "1234567890", "miste123", Perfil.BOEMIO);
		Estudante e = new Estudante(CursoDei.LEI, "Pedro", "0987654321", "miste1234", Perfil.BOEMIO);
		Professor p = new Professor(TipoProfessor.ASSOCIADO, "Mario", "0934626326", "miste12345", Perfil.BOEMIO);
		System.out.println("hello its meeeeeeee, helooooooo from the otter side");
		System.out.println(f.getGuestListFormat());
		System.out.println(e.getGuestListFormat());
		System.out.println(p.getGuestListFormat());
	}
}
	

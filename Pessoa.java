import java.io.Serializable;

public abstract class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private String numCc;
	private String password;
	private Perfil perfil;
	private double discontoEmExibicoes;

	public Pessoa(String nome, String numCc, String password, Perfil perfil) {
		this.setNome(nome);
		this.numCc = numCc;
		this.password = password;
		this.perfil = perfil;
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
}
	

import java.io.Serializable;

public class Inscricao implements Serializable{

	private static final long serialVersionUID = 1L;
	private Pessoa pessoa;
	private Local local;
	
	public Inscricao(Pessoa pessoa, Local local) {
		this.pessoa = pessoa;
		this.local = local;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public Local getLocal() {
		return local;
	}
}

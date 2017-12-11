
public class Inscricao {
	private Pessoa pessoa;
	private Local local;
	
	public Inscricao(Pessoa pessoa, Local local) {
		this.pessoa = pessoa;
		this.local = local;
	}
	
	private Pessoa getPessoa() {
		return pessoa;
	}
	
	private Local getLocal() {
		return local;
	}
}

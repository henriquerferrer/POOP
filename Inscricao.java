
public class Inscricao {
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

package poop;

import java.io.Serializable;

public class Inscricao implements Serializable, Comparable {

	private static final long serialVersionUID = 1L;
	private Pessoa pessoa;
	private Local local;
	private int id;
	
	public Inscricao(Pessoa pessoa, Local local, int id) {
		this.pessoa = pessoa;
		this.local = local;
		this.id = id;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public Local getLocal() {
		return local;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Object arg0) {
		Inscricao i = (Inscricao) arg0;
		return Integer.compare(this.id, i.id);
	}
}

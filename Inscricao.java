package poop;

import java.io.Serializable;

/**
 * Classe que representa uma inscrição.
 * @author JoaquimFerrer
 */
public class Inscricao implements Serializable, Comparable {

	private static final long serialVersionUID = 1L;
	private Pessoa pessoa;
	private Local local;
	private int id;
	
	/**
	 * Unico construtor.
	 * @param pessoa Pessoa que se vai inscrever inscrita.
	 * @param local Local em que se vai inscrever.
	 * @param id Id único a cada inscrição.
	 */
	public Inscricao(Pessoa pessoa, Local local, int id) {
		this.pessoa = pessoa;
		this.local = local;
		this.id = id;
	}
	
	/**
	 * Obtem a pessoa associada à inscrição.
	 * @return A Pessoa.
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	/**
	 * Obtém o Local associado à inscrição
	 * @return O Local
	 */
	public Local getLocal() {
		return local;
	}
	
	/**
	 * Obtém o id associado à inscrição
	 * @return O id
	 */
	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Object arg0) {
		Inscricao i = (Inscricao) arg0;
		return Integer.compare(this.id, i.id);
	}
}

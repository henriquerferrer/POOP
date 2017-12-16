package poop;

/**
 * Classe que representa um Professor
 * @author JoaquimFerrer Henrique Ferrer
 */
public class Professor extends Pessoa {

	private static final long serialVersionUID = 1L;
	private TipoProfessor tipoProfessor;
	
	/**
	 * Ùnico construtor.
	 * @param tipoProfessor Tipo do professor.
	 * @param nome Nome.
	 * @param numCc Número do cartão de cidadão.
	 * @param password Password para a plataforma.
	 * @param perfil Perfil.
	 */
	public Professor(TipoProfessor tipoProfessor, String nome, String numCc, String password, Perfil perfil) {
		super(nome, numCc, password, perfil);
		this.tipoProfessor = tipoProfessor;
	}
	
	
	/**
	 * Obtém o tipo de professor.
	 * @return Tipo de professor
	 */
	public TipoProfessor getTipoProfessor() {
        return this.tipoProfessor;
    }
}

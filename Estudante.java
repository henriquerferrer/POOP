package poop;

/**
 * Uma classe para representar um Estudante do DEI
 * @author JoaquimFerrer Henrique Ferrer
 */
public class Estudante extends Pessoa {

	private static final long serialVersionUID = 1L;
	private CursoDei curso;
	
	/**
	 *Unico construtor
	 * @param curso curso de que faz parte
	 * @param nome nome
	 * @param numCc numero do cartao de 
	 * @param password password usada na plataforma
	 * @param perfil perfil
	 */
	public Estudante(CursoDei curso , String nome, String numCc, String password, Perfil perfil) {
		super(nome, numCc, password, perfil);
		this.curso = curso;
	}
	
	@Override
	public boolean isEstudante() {
		return true;
	}
	
	/**
	 * Obtem o curso do aluno
	 * @return o curso do aluno
	 */
	public CursoDei getCurso() {
		return this.curso;
	}

	/**
	 * Muda o curso do aluno
	 * @param curso curso do DEI
	 */
	public void setCurso(CursoDei curso) {
		this.curso = curso;
	}
	
	@Override
	public String getGuestListFormat() {
		return super.getGuestListFormat() + " e " + this.curso;
	}
	
}

public class Estudante extends Pessoa {

	private static final long serialVersionUID = 1L;
	private CursoDei curso;
	
	public Estudante(CursoDei curso , String nome, String numCc, String password, Perfil perfil) {
		super(nome, numCc, password, perfil);
		this.curso = curso;
	}
	
	public CursoDei getCurso() {
		return this.curso;
	}

	public void setCurso(CursoDei curso) {
		this.curso = curso;
	}
	
	//public String getGuestListFormat() {
	//	return 
	//}
}

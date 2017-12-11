public class Professor extends Pessoa {
	private TipoProfessor tipoProfessor;
	
	public Professor(TipoProfessor tipoProfessor, String nome, String numCc, String password, Perfil perfil) {
		super(nome, numCc, password, perfil);
		this.tipoProfessor = tipoProfessor;
	}
	
	public boolean isProfessor() {
		return true;
	}
	
	public TipoProfessor getTipoProfessor() {
        return this.tipoProfessor;
    }

    public void setName(TipoProfessor tipoProfessor) {
        this.tipoProfessor = tipoProfessor;
    }
}

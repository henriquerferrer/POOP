package poop;

public class Funcionario extends Pessoa {
	
	private static final long serialVersionUID = 1L;
	private TipoFuncionario tipoFuncionario;
	
	public Funcionario(TipoFuncionario tipoFuncionario, String nome, String numCc, String password, Perfil perfil) {
		super(nome, numCc, password, perfil);
		this.tipoFuncionario = tipoFuncionario;
	}
	
	public boolean isFuncionario() {
		return true;
	}
	
	public TipoFuncionario getTipoFuncionario() {
		return this.tipoFuncionario;
	}
	
	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}
}

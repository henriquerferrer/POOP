public class Funcionario extends Pessoa {
	private TipoFuncionario tipoFuncionario;
	
	public Funcionario(TipoFuncionario tipoFuncionario, String nome, String numCc, String password, Perfil perfil) {
		super(nome, numCc, password, perfil);
		this.tipoFuncionario = tipoFuncionario;
	}
	
	public TipoFuncionario getTipoFuncionario() {
		return this.tipoFuncionario;
	}
	
	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}
}

package poop;

/**
 * Classe que representa um Funcionario do DEI
 * @author JoaquimFerrer Henrique Ferrer
 */
public class Funcionario extends Pessoa {
	
	private static final long serialVersionUID = 1L;
	private TipoFuncionario tipoFuncionario;
	
	/**
	 * Unico Construtor
	 * @param tipoFuncionario tipo de horario
	 * @param nome nome
	 * @param numCc numero do cartao de cidadao
	 * @param password password usada na plataforma
	 * @param perfil perfiç
	 */
	public Funcionario(TipoFuncionario tipoFuncionario, String nome, String numCc, String password, Perfil perfil) {
		super(nome, numCc, password, perfil);
		this.tipoFuncionario = tipoFuncionario;
	}
	
	/**
	 * Obtem o tipo de horario do funcionario
	 * @return tipo do funcionario
	 */
	public TipoFuncionario getTipoFuncionario() {
		return this.tipoFuncionario;
	}
	
	/**
	 * Altera o tipo do funcionario
	 * @param tipoFuncionario novo tipo do functionario
	 */
	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}
}

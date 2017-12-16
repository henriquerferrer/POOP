package poop;

import java.io.Serializable;

/**
 * Classe que representa uma Pessoa.
 * @author JoaquimFerrer Henrique Ferrer
 */
public abstract class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private String numCc;
	private String password;
	private Perfil perfil;
	private double discontoEmExibicoes;

	/**
	 * Único construtor.
	 * @param nome Nome da Pessoa
	 * @param numCc Número do cartão de cidadão.
	 * @param password Password para a plataforma.
	 * @param perfil Perfil
	 */
	public Pessoa(String nome, String numCc, String password, Perfil perfil) {
		this.nome = nome;
		this.numCc = numCc;
		this.password = password;
		this.perfil = perfil;
	}
	
	/**
	 * Retorna se é estudante.
	 * @return
	 */
	public boolean isEstudante() {
		return false;
	}
	
	/**
	 * Obtém nome da pessoa.
	 * @return Nome
	 */
	public String getNome() {
		return this.nome;
	}

	
	/**
	 * Obtém o número de cartão de cidadão da Pessoa.
	 * @return Número do cartão de cidadão.
	 */
	public String getNumCc() {
		return this.numCc;
	}
	
	/**
	 * Obtém a password da pessoa.
	 * @return Password
	 */
	protected String getPassword() {
		return this.password;
	}
	
	/**
	 * Obtém perfil da pessoa.
	 * @return Perfil
	 */
	public Perfil getPerfil() {
		return this.perfil;
	}
	
	//TODO: METODO GET DISCONTO ESTUDANTE ONDE O UNICO QUE TEM E O ESTUDANTE QUE FAZ OVERRIDE O RESTO O DESCOTNO E 0 
	
	/**
	 * Retorna os detalhes da pessoa apropriado para a guest list.
	 * @return o Detalhes para a guest List.
	 */
	public String getGuestListFormat() {
		return this.nome + " " + this.perfil;
	}
	
	@Override
	public boolean equals(Object other){
		if (other == null) return false;
		if (other == this) return true;
		if (!(other instanceof Local))return false;
		Pessoa pessoa = (Pessoa)other;
		if(pessoa.getNumCc().equals(this.numCc)) {
			return true;
		}
		return false;
	}
	
}
	

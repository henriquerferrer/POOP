package poop;

/**
 * Classe que representa um Parque
 * @author JoaquimFerrer Henrique Ferrer
 */
public abstract class Parque extends Local {

	private static final long serialVersionUID = 1L;

	/**
	 * Unico construtor.
	 * @param coordenadas Coordenadas do Parque
	 */
	public Parque(String coordenadas) {
        super(coordenadas);
    }
    
}

package poop;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author JoaquimFerrer Henrique Ferrer
 */
public abstract class Local implements Serializable{

	private static final long serialVersionUID = 1L;
	private String coordenadas;

	/**
	 * Unico Construtor
	 * @param coordenadas Coordenadas do Local
	 */
	public Local(String coordenadas) {
        this.coordenadas = coordenadas;
    }

	/**
	 * Obtém as coordenadas do Local.
	 * @return Coordenadas
	 */
	public String getCoordenadas() {
        return coordenadas;
    }

	/**
	 * Obtém o custo duma inscrição neste local.
	 * @return valor que custa uma inscrição neste local.
	 */
	public double getCustoMinimo() {
        return 0;
    }

	/**
	 * Retorna se é um bar.
	 * @return 
	 */
	public boolean isBar() {
        return false;
    }

	/**
	 * Retorna se é uma exposição.
	 * @return
	 */
	public boolean isExposicao() {
        return false;
    }
	
	/**
	 * Retorna os detalhes dum local
	 * @return Os detalhes.
	 */
	public abstract String getDetails();
    
    @Override
    public boolean equals(Object other){
    	if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Local))return false;
        Local local = (Local)other;
        if(local.getCoordenadas().equals(this.coordenadas)) {
        	return true;
        }
        return false;
    }
	
	@Override
	public String toString() {
		return "Coordenadas: " + this.coordenadas;
	}
}

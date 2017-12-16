package poop;

import java.util.ArrayList;

/**
 * Representa uma área desportiva
 * @author JoaquimFerrer Henrique Ferrer
 */
public class AreaDesportiva extends Parque {

	private static final long serialVersionUID = 1L;
	private ArrayList<String> desportos;

	/**
	 * Unico construtor.
	 * @param coordenadas as coordenadas do local
	 * @param desportos os desportos que se praticam
	 */
	public AreaDesportiva(String coordenadas, ArrayList<String> desportos) {
        super(coordenadas);
        this.desportos = desportos;
    }

    private ArrayList<String> getDesportos() {
        return desportos;
    }
	
	@Override
	public String toString() {
		return "Area desportiva. " + super.toString(); 
	}

	/**
	 *
	 * @return detalhes da area desportiva
	 */
	@Override
	public String getDetails() {
		String res = "Desportos:\n";
		for(String s : desportos) {
			res += s + " ";
		}
		return res;
	}
}

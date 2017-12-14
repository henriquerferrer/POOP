package poop;

import java.util.ArrayList;

public class AreaDesportiva extends Parque {

	private static final long serialVersionUID = 1L;
	private ArrayList<String> desportos;

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
}

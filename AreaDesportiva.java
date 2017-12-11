import java.util.ArrayList;

public class AreaDesportiva extends Parque {

    private ArrayList<String> desportos;

    public AreaDesportiva(String coordenadas, ArrayList<String> desportos) {
        super(coordenadas);
        this.desportos = desportos;
    }

    private ArrayList<String> getDesportos() {
        return desportos;
    }
}

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Local implements Serializable{

	private static final long serialVersionUID = 1L;
	private String coordenadas;

    public static void main(String args[]) {
        ArrayList<Local> locais = new ArrayList<Local>();
        locais.add(new Bar("junto do cafe", 20, 5.0));
        locais.add(new Exposicao("junto do cafe", "escultura", 10.0));
        locais.add(new Exposicao("junto do cafe", "pintura", 20.0));
        locais.add(new Jardim("junto do cafe", 50));
        double counter = 0;
        for(Local l : locais) {
            counter += l.getCustoMinimo();
        }
        System.out.println(counter);
    }

    public Local(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public double getCustoMinimo() {
        return 0;
    }

    public boolean isBar() {
        return true;
    }

    public boolean isExposicao() {
        return false;
    }
}

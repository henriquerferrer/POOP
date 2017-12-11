public class Jardim extends Parque {

	private static final long serialVersionUID = 1L;
	private double area;

    public Jardim(String coordenadas, double area) {
        super(coordenadas);
        this.area = area;
    }

    public double getArea() {
        return area;
    }
}

package poop;

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
	
	@Override
	public String toString() {
		return "Parque. " + super.toString();
	}

	@Override
	public String getDetails() {
		return "Area do Jardim: " + area;
	}
}

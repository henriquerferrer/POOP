public class Jardim extends Parque {
    private double area;

    public Jardim(String coordenadas, double area) {
        super(coordenadas);
        this.area = area;
    }

    public double getArea() {
        return area;
    }
}

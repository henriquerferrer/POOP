package poop;

/**
 * Representa um Jardim
 * @author JoaquimFerrer Henrique Ferrer
 */
public class Jardim extends Parque {

	private static final long serialVersionUID = 1L;
	private double area;

	/**
	 * Unico Construtor
	 * @param coordenadas Coordenadas do local.
	 * @param area Area do Local
	 */
	public Jardim(String coordenadas, double area) {
        super(coordenadas);
        this.area = area;
    }

	/**
	 * Obtém a área do Local.
	 * @return Area
	 */
	public double getArea() {
        return area;
    }
	
	@Override
	public String toString() {
		return "Parque. " + super.toString();
	}

	/**
	 * Obtém os detalhes do jardim incluindo a sua área.
	 * @return Detalhes
	 */
	@Override
	public String getDetails() {
		return "Area do Jardim: " + area;
	}
}

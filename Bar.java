package poop;

/**
 * Representa um Bar
 * @author JoaquimFerrer Henrique Ferrer
 */
public class Bar extends Local{

	private static final long serialVersionUID = 1L;
	private int lotacao;
    private double consumoMinimo;

	/**
	 *Unico construtor
	 * @param coordenadas coordenadas do Bar
	 * @param lotacao lotacao do Bar
	 * @param consumoMinimo consumo minimo do bar
	 */
	public Bar(String coordenadas, int lotacao, double consumoMinimo) {
        super(coordenadas);
        this.lotacao = lotacao;
        this.consumoMinimo = consumoMinimo;
    }

	/**
	 *
	 * @return consumo minimo do bar
	 */
	@Override
    public double getCustoMinimo() {
        return consumoMinimo;
    }

	/**
	 *
	 * @return lotacao maxima do bar
	 */
	public int getLotacao() {
        return lotacao;
    }
    
	/**
	 *
	 * @return se é um bar
	 */
	@Override
    public boolean isBar() {
    	return false;
    }
	
	@Override
	public String toString() {
		return "Bar. " + super.toString();
	}

	/**
	 *
	 * @return detalhes do bar. Inclui as coordenadas, a lotacao e o consumo minimo.
	 */
	@Override
	public String getDetails() {
		return "Lotacao: " + lotacao + "\nConsumo Minimo: " + consumoMinimo;
	}
}

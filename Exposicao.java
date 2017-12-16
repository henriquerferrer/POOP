package poop;

/**
 * Classe que representa uma Exposição
 * @author JoaquimFerrer Henrique Ferrer
 */
public class Exposicao extends Local{

	private static final long serialVersionUID = 1L;
	private String formaArtistica;
    private double custoBilhete;

	/**
	 * Unico construtor
	 * @param coordenadas coordenadas do local
	 * @param formaArtistica forma artistica apresentada
	 * @param custoBilhete custo de um bilhete 
	 */
	public Exposicao(String coordenadas, String formaArtistica, double custoBilhete) {
        super(coordenadas);
        this.formaArtistica = formaArtistica;
        this.custoBilhete = custoBilhete;
    }

	@Override
    public double getCustoMinimo() {
        return custoBilhete;
    }
	
	/**
	 * Obtem a forma artistica da exposicao
	 * @return forma artistica da exposicao
	 */
    public String getFormaArtistica() {
        return formaArtistica;
    }
	
	
	@Override
    public boolean isExposicao() {
    	return true;
    }
	
	@Override
	public String toString() {
		return "Exposicao. " + super.toString();
	}

	@Override
	public String getDetails() {
		return "Forma artistica: " + formaArtistica + "\nCusto do Bilhete: " + custoBilhete;
	}
}

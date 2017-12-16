package poop;

public class Exposicao extends Local{

	private static final long serialVersionUID = 1L;
	private String formaArtistica;
    private double custoBilhete;

    public Exposicao(String coordenadas, String formaArtistica, double custoBilhete) {
        super(coordenadas);
        this.formaArtistica = formaArtistica;
        this.custoBilhete = custoBilhete;
    }

    @Override
    public double getCustoMinimo() {
        return custoBilhete;
    }

    private String getFormaArtistica() {
        return formaArtistica;
    }
    
    @Override
    public boolean isExposicao() {
    	return true;
    }
	
	@Override
	public String toString() {
		return "Exposicao de " + this.formaArtistica + ". " + super.toString();
	}
}

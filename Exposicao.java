public class Exposicao extends Local{
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
}

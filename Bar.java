public class Bar extends Local{

	private static final long serialVersionUID = 1L;
	private int lotacao;
    private double consumoMinimo;

    public Bar(String coordenadas, int lotacao, double consumoMinimo) {
        super(coordenadas);
        this.lotacao = lotacao;
        this.consumoMinimo = consumoMinimo;
    }

    @Override
    public double getCustoMinimo() {
        return consumoMinimo;
    }

    public int getLotacao() {
        return lotacao;
    }
}

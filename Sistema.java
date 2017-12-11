import java.util.ArrayList;

public class Sistema {
	private ArrayList<Inscricao> inscricoes;
	private ArrayList<Local> locais;
	private ArrayList<Pessoa> pessoas;
	private GestorBaseDados gestorBD;
	
	public Sistema() {
		this.inscricoes = new ArrayList<Inscricao>();
		this.locais = new ArrayList<Local>();
		this.pessoas = new ArrayList<Pessoa>();
		this.gestorBD = new GestorBaseDados();
	}
	
	
}

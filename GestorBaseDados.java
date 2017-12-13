package poop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestorBaseDados {
	private final String pessoasPath = "./bd/pessoas/";
	private final String locaisPath = "./bd/locais/";
	private final String inscricoesPath = "./bd/inscricoes/";
	
	public static void main(String[] args) {
		GestorBaseDados gbd= new GestorBaseDados();
		Estudante e1 = new Estudante(CursoDei.LEI, "Joaquim Ferrer", "123", "benfica", Perfil.BOEMIO);
		Estudante e2 = new Estudante(CursoDei.LEI, "Joaquim Joao", "1234", "benfica", Perfil.BOEMIO);
		Funcionario f1 = new Funcionario(TipoFuncionario.FULLTIME , "Adelbio Silva", "1", "password", Perfil.BOEMIO);
		Professor p1 = new Professor(TipoProfessor.ASSOCIADO, "Joao Simoes", "12", "passwrod", Perfil.BOEMIO);
		
		Jardim pq = new Jardim("2-3", 12);
		
		Inscricao i1 = new Inscricao(e1, pq);
		Inscricao i2 = new Inscricao(e2, pq);
		
		gbd.savePessoa(e1);gbd.savePessoa(e2);gbd.savePessoa(f1);gbd.savePessoa(p1);
		gbd.saveLocal(pq);
		gbd.saveInscricao(i1); gbd.saveInscricao(i2);
		
		ArrayList<Pessoa> pessoas = gbd.loadPessoas();
		ArrayList<Local> locais = gbd.loadLocais();
		ArrayList<Inscricao> inscricoes = gbd.loadInscricoes();
		
		for(Pessoa p : pessoas) {
			System.out.println(p.getNome());
		}
		
		for(Local l : locais) {
			System.out.println(l.getCoordenadas());
		}
		
		for(Inscricao i : inscricoes) {
			System.out.println(i.getPessoa().getNome());
		}
		
	}
	
	public GestorBaseDados() {}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Pessoa> loadPessoas() {
		return (ArrayList<Pessoa>) readAllFromPath(pessoasPath);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Local> loadLocais() {
		return (ArrayList<Local>) readAllFromPath(locaisPath);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Inscricao> loadInscricoes() {
		return (ArrayList<Inscricao>) readAllFromPath(inscricoesPath);
	}
	
	public boolean savePessoa(Pessoa p) {
    	return saveObject(p, pessoasPath + p.getNumCc());
    }
	
	public boolean saveInscricao(Inscricao i) {
    	return saveObject(i, inscricoesPath + i.getPessoa().getNumCc() + i.getLocal().getCoordenadas());
    }
	
	public boolean saveLocal(Local l) {
    	return saveObject(l, locaisPath + l.getCoordenadas());
    }
	
	private boolean saveObject(Object o, String path) {
		try {
	        FileOutputStream fileStream = new FileOutputStream(new File(path));
	        ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
	        objectStream.writeObject(o);
	        objectStream.close();
	        fileStream.close();
	    }
	    catch(Exception exc) {
	        exc.printStackTrace();
	        return false;
	    }
		return true;
	}
	
	private ArrayList<?> readAllFromPath(String path) {
		ArrayList<Object> res = new ArrayList<Object>();
    	File dir = new File(path);
		File[] directoryListing = dir.listFiles();
		for (File child : directoryListing) {
			Object o = readObjectFromFile(child);
			res.add(o);
		}
		return res;
	}
	
	private Object readObjectFromFile(File f) {	
    	try {
			FileInputStream fs = new FileInputStream(f);
			ObjectInputStream objectIn = new ObjectInputStream(fs);
			Object obj = objectIn.readObject();
			objectIn.close();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}

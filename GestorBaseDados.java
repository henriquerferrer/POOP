package poop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class GestorBaseDados {
	private final String pessoasPath = "./bd/pessoas/";
	private final String locaisPath = "./bd/locais/";
	private final String inscricoesPath = "./bd/inscricoes/";
	private final String informacaoInicialPath = "./bd/InformacaoInicial.txt";
	
	/*
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
		
	}*/
	
	public GestorBaseDados() {}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Pessoa> loadPessoas() {
		ArrayList<Pessoa> res = new ArrayList<Pessoa>();
		File dir = new File(inscricoesPath);
		File[] directoryListing = dir.listFiles();
		if(directoryListing.length == 0) {
			res.addAll(parsePessoas());
		}
		res.addAll((ArrayList<Pessoa>) readAllFromPath(pessoasPath));
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Local> loadLocais() {
		ArrayList<Local> res = new ArrayList<Local>();
		File dir = new File(inscricoesPath);
		File[] directoryListing = dir.listFiles();
		if(directoryListing.length == 0) {
			res.addAll(parseLocais());
		}
		res.addAll((ArrayList<Local>) readAllFromPath(locaisPath));
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Inscricao> loadInscricoes() {
		return (ArrayList<Inscricao>) readAllFromPath(inscricoesPath);
	}
	
	public boolean savePessoa(Pessoa p) {
    	return saveObject(p, pessoasPath + p.getNumCc());
    }
	
	
	//SO FUNCIONA SEM BUGS SE FOR IMPOSSIVEL REMOVER INSCRICOES
	public boolean saveInscricao(Inscricao i) {
		File dir = new File(inscricoesPath);
		File[] directoryListing = dir.listFiles();
		if(directoryListing.length == 0) {
			ArrayList<Local> locaisIniciais = parseLocais();
			ArrayList<Pessoa> pessoasIniciais = parsePessoas();
			for(Local l : locaisIniciais) {
				saveLocal(l);
			}
			for(Pessoa p : pessoasIniciais) {
				savePessoa(p);
			}
		}
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
	
	private ArrayList<Local> parseLocais() {
		ArrayList<Local> res = new ArrayList<Local>();
		try {
			BufferedReader fR = new BufferedReader(new FileReader(informacaoInicialPath));
			String line;
			boolean start = false;
			while((line = fR.readLine()) != null) {
				if(!start && !line.equals("LOCAIS:")) {
					continue;
				}
				else if(!start && line.equals("LOCAIS:")) {
					start = true;
					continue;
				}
				else if(start && line.equals("PESSOAS")) {
					return res;
				}
				String[] information = line.split("\t");
				if(information[0].equals("Bar")) {
					res.add(new Bar(information[1], Integer.parseInt(information[2]), Double.parseDouble(information[3])));
				}
				else if(information[0].equals("Exposicao")) {
					res.add(new Exposicao(information[1], information[2], Double.parseDouble(information[3])));
				}
				else if(information[0].equals("AreaDesportiva")) {
					ArrayList<String> desportos = new ArrayList<String>();
					desportos.addAll(Arrays.asList(information[2].split(",")));
					res.add(new AreaDesportiva(information[1], desportos));
				}
				else if(information[0].equals("Jardim")) {
					res.add(new Jardim(information[1], Double.parseDouble(information[2])));
				}
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("O ficheiro de informacao inicial nao existe");
			return res;
		}
		catch(IOException e) {
			System.out.println("Erro a ler o ficheiro com as informaçoes iniciais");
			return res;
		}
		return res;
	}
	
	private ArrayList<Pessoa> parsePessoas() {
		ArrayList<Pessoa> res = new ArrayList<Pessoa>();
		try {
			BufferedReader fR = new BufferedReader(new FileReader(informacaoInicialPath));
			String line;
			boolean start = false;
			while((line = fR.readLine()) != null) {
				if(!start && !line.equals("PESSOAS:")) {
					continue;
				}
				else if(!start && line.equals("PESSOAS:")) {
					start = true;
					continue;
				}
				String[] information = line.split("\t");
				if(information[0].equals("Estudante")) {
					res.add(new Estudante(getCursoDei(information[1]), information[2], information[3], information[4], getPerfil(information[5])));
				}
				else if(information[0].equals("Funcionario")) {
					res.add(new Funcionario(getTipoFuncionario(information[1]), information[2], information[3], information[4], getPerfil(information[5])));
				}
				else if(information[0].equals("Professor")) {
					res.add(new Professor(getTipoProfessor(information[1]), information[2], information[3], information[4], getPerfil(information[5])));
				}
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("O ficheiro de informacao inicial nao existe");
			return res;
		}
		catch(IOException e) {
			System.out.println("Erro a ler o ficheiro com as informaçoes iniciais");
			return res;
		}
		return res;
	}
	
	private TipoProfessor getTipoProfessor(String str) {
        if(str.equals("Auxiliar")) {
            return TipoProfessor.AUXILIAR;
        }
        else if(str.equals("Catedratico")) {
            return TipoProfessor.CATEDRATICO;
        }
        else {
            return TipoProfessor.ASSOCIADO;
        }
   }
    
    private Perfil getPerfil(String str) {
        if(str.equals("BOEMIO")) {
            return Perfil.BOEMIO;
        }
        else if(str.equals("CULTURAL")) {
            return Perfil.CULTURAL;
        }
        else if(str.equals("POUPADINHO")) {
            return Perfil.POUPADINHO;
        }
        else {
            return Perfil.DESPORTIVO;
        }
   }
    
    private TipoFuncionario getTipoFuncionario(String str) {
        if(str.equals("PARTTIME")) {
            return TipoFuncionario.FULLTIME;
        }
        else {
            return TipoFuncionario.PARTTIME;
        }
   }
    
    private CursoDei getCursoDei(String str) {
        if(str.equals("LEI")) {
            return CursoDei.LEI;
        }
        else if(str.equals("MEI")) {
            return CursoDei.MEI;
        }
        else if(str.equals("LDM")) {
            return CursoDei.LDM;
        }
        else {
            return CursoDei.MDM;
        }
    }
	
}

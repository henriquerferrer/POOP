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

/**
 * Classe que cria uma abstracao para criar e ler ficheiros de objeto (usados na plataforma).
 * Lê tambem um ficheiro de configuração com Locais e Pessoas que podem ser alterados. Estes dados são gravados na base de dados assim que há a primeira inscricao.
 * @author JoaquimFerrer Henrique Ferrer
 */
public class GestorBaseDados {
	private final String pessoasPath = "./bd/pessoas/";
	private final String locaisPath = "./bd/locais/";
	private final String inscricoesPath = "./bd/inscricoes/";
	private final String informacaoInicialPath = "./bd/InformacaoInicial.txt";

	
	public GestorBaseDados() {}
	
	/**
	 * Lê as pessoas escritas na base de dados e devolve-os-
	 * @return Pessoas na base de dados
	 */
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
	
	/**
	 * Lê os locais escritos na base de dados e devolve-os
	 * @return Locais na base de dados
	 */
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
	
	/**
	 * Lê as inscricoes na base de dados e devolve-os
	 * @return Inscricoes na base de dados.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Inscricao> loadInscricoes() {
		return (ArrayList<Inscricao>) readAllFromPath(inscricoesPath);
	}
	
	/**
	 * Guarda uma pessoa na base de dados.
	 * @param p Pessoa a guardar
	 * @return Se conseguiu guardar a pessoa com sucesso
	 */
	public boolean savePessoa(Pessoa p) {
    	return saveObject(p, pessoasPath + p.getNumCc());
    }
	
	
	//SO FUNCIONA SEM BUGS SE FOR IMPOSSIVEL REMOVER INSCRICOES
	/**
	 * Guarda uma inscricao na base de dados. Se não ainda houver inscricoes então guarda todos os objectos descritos no ficheiro de configuracao na base de dados.
	 * @param i Inscricao a guardar
	 * @return Se conseguiu guardar a inscricao com sucesso
	 */
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
	
	/**
	 *
	 * @param l Local a guardar
	 * @return Se conseguiu guardar o Local com sucesso.
	 */
	public boolean saveLocal(Local l) {
    	return saveObject(l, locaisPath + l.getCoordenadas());
    }
	
	//Guarda um objeto no path especificado
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
	
	//Le todos os objetos dum ficheiro
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
	
	//Le objeto dum ficheiro e devolve-o
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
	
	
	//Le os locais do ficheiro de configuraçoes e devolve-os.
	//Os locais devem ser precedidos por uma linha "LOCAIS:"
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
	//Transforma uma string no tipo de professor correspondente
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
    //Transforma uma string no perfil correspondente
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
    
	//Transforma uma string no tipo de funcionario correspondente
    private TipoFuncionario getTipoFuncionario(String str) {
        if(str.equals("PARTTIME")) {
            return TipoFuncionario.FULLTIME;
        }
        else {
            return TipoFuncionario.PARTTIME;
        }
   }
    
	//Transforma uma string no curso do dei correspondente
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

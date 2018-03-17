package evaluator.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


import evaluator.model.Intrebare;
import evaluator.exception.DuplicateIntrebareException;

public class IntrebariRepository {
	
	private List<Intrebare> intrebari = new ArrayList<>();
	
	public IntrebariRepository() {
		setIntrebari(new LinkedList<Intrebare>());
	}
	
	public void addIntrebare(Intrebare i) throws DuplicateIntrebareException{
		if(exists(i))
			throw new DuplicateIntrebareException("Intrebarea deja exista!");
		intrebari.add(i);
	}
	
	public boolean exists(Intrebare i){
		for(Intrebare intrebare : intrebari)
			if(intrebare.equals(i))
				return true;
		return false;
	}
	
	public int getNumberOfDistinctDomains(){
		return getDistinctDomains().size();
		
	}
	
	public Set<String> getDistinctDomains(){
		Set<String> domains = new TreeSet<String>();
		for(Intrebare intrebre : intrebari)
			domains.add(intrebre.getDomeniu());
        System.out.println("Domenii distincte " + domains.size());
		return domains;
	}
	
	public List<Intrebare> getIntrebariByDomain(String domain){
		List<Intrebare> intrebariByDomain = new LinkedList<Intrebare>();
		for(Intrebare intrebare : intrebari){
			if(intrebare.getDomeniu().equals(domain)){
				intrebariByDomain.add(intrebare);
			}
		}
		
		return intrebariByDomain;
	}
	
	public int getNumberOfIntrebariByDomain(String domain){
		return getIntrebariByDomain(domain).size();
	}
	
	public List<Intrebare> loadIntrebariFromFile(String f){
		
		List<Intrebare> intrebari = new LinkedList<Intrebare>();
		BufferedReader br = null; 
		String line = null;
		List<String> intrebareAux;
		Intrebare intrebare;
		
		try{
			br = new BufferedReader(new FileReader(f));
			line = br.readLine();
			while(line != null){
				intrebareAux = new LinkedList<String>();
				while(!line.equals("##")){
					intrebareAux.add(line);
					line = br.readLine();
				}
				intrebare = new Intrebare();
				intrebare.setEnunt(intrebareAux.get(0));
				intrebare.addVarianta(intrebareAux.get(1));
				intrebare.addVarianta(intrebareAux.get(2));
				intrebare.setVariantaCorecta(intrebareAux.get(3));
				intrebare.setDomeniu(intrebareAux.get(4));
				if(!exists(intrebare))
				    intrebari.add(intrebare);
				line = br.readLine();
			}
		
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		finally{
			try {
				br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return intrebari;
	}
	
	public List<Intrebare> getIntrebari() {
		return intrebari;
	}

	public void setIntrebari(List<Intrebare> intrebari) {

		this.intrebari.addAll(intrebari);
	}
	
}

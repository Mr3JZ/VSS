package evaluator.model;

import evaluator.util.InputValidation;
import evaluator.exception.InputValidationFailedException;

import java.util.ArrayList;

public class Intrebare {
	
	private String enunt;
	private ArrayList<String> variante = new ArrayList<>();
	private String variantaCorecta;
	private String domeniu;
	
	public Intrebare() {
	}
	
	public Intrebare(String enunt, String varianta1, String varianta2,
			String variantaCorecta, String domeniu) throws InputValidationFailedException {
		
		InputValidation.validateEnunt(enunt);
		InputValidation.validateVarianta(varianta1,1);
		InputValidation.validateVarianta(varianta2,2);
		InputValidation.validateVariantaCorecta(variantaCorecta);
		InputValidation.validateDomeniu(domeniu);
		
		this.enunt = enunt;
		variante.add(varianta1);
		variante.add(varianta2);
		this.variantaCorecta = variantaCorecta;
		this.domeniu = domeniu;
	}


	public String getEnunt() {
		return enunt;
	}
	public void setEnunt(String enunt) {
		this.enunt = enunt;
	}

    public ArrayList<String> getVariante() {
        return variante;
    }

    public void addVarianta(String varianta) {
        this.variante.add(varianta);
    }
    public String getVariantaCorecta() {
		return variantaCorecta;
	}
	public void setVariantaCorecta(String variantaCorecta) {
		this.variantaCorecta = variantaCorecta;
	}
	public String getDomeniu() {
		return domeniu;
	}
	public void setDomeniu(String domeniu) {
		this.domeniu = domeniu;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Intrebare){
			Intrebare i = (Intrebare) obj;
			int index = 0;
			while(index<variante.size()) {
			    if(!this.variante.get(index).equals(i.getVariante().get(index))) {
			        return false;
                }
                index++;
            }
			if(this.enunt.equals(i.getEnunt()) &&
			   this.variantaCorecta.equals(i.getVariantaCorecta()) &&
			   this.domeniu.equals(i.getDomeniu()))
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
	    String varianteString = "";
	    for(String str : this.variante) {
            varianteString = varianteString.concat(str + " ");
        }
		return this.enunt + " " + varianteString + this.variantaCorecta + " " + this.domeniu;
	}
}

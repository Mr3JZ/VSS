package evaluator.util;


import evaluator.exception.InputValidationFailedException;

public class InputValidation {

	public static void validateEnunt(String enunt) throws InputValidationFailedException{
	
		enunt = enunt.trim();
		
		if(enunt.equals(""))
			throw new InputValidationFailedException("Enuntul este vid!");
		if(!Character.isUpperCase(enunt.charAt(0)))
			throw new InputValidationFailedException("Prima litera din enunt nu e majuscula!");
		if(!String.valueOf(enunt.charAt(enunt.length()-1)).equals("?"))
			throw new InputValidationFailedException("Ultimul caracter din enunt nu e '?'!");
		if(enunt.length() > 100)
			throw new InputValidationFailedException("Lungimea enuntului depaseste 100 de caractere!");
		
	}
	
	public static void validateVarianta(String varianta, int nr) throws InputValidationFailedException{
		
		varianta = varianta.trim();
		
		if(varianta.equals(""))
			throw new InputValidationFailedException("Varianta " + nr + " este vida!");
		if(!String.valueOf(varianta.charAt(0)).equals(String.valueOf(nr)) || !String.valueOf(varianta.charAt(1)).equals(")"))
			throw new InputValidationFailedException("Varianta " + nr + " nu incepe cu '" + nr + ")'!");
		if(varianta.length() > 50)
			throw new InputValidationFailedException("Lungimea variantei1 depaseste 50 de caractere!" );
	}
	
	public static void validateVariantaCorecta(String variantaCorecta) throws InputValidationFailedException{
		
		variantaCorecta = variantaCorecta.trim();
		
		if(!variantaCorecta.equals("1") && !variantaCorecta.equals("2") && !variantaCorecta.equals("3"))
			throw new InputValidationFailedException("Varianta corecta nu este unul dintre caracterele {'1', '2', '3'}");
	}
	
	public static void validateDomeniu(String domeniu) throws InputValidationFailedException{
		
		domeniu = domeniu.trim();
		
		if(domeniu.equals(""))
			throw new InputValidationFailedException("Domeniul este vid!");
		if(!Character.isUpperCase(domeniu.charAt(0)))
			throw new InputValidationFailedException("Prima litera din domeniu nu e majuscula!");
		if(domeniu.length() > 30)
			throw new InputValidationFailedException("Lungimea domeniului depaseste 30 de caractere!");
		
	}
}

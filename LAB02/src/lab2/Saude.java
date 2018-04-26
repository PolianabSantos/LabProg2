package lab2;

/**
* Essa Classe serve para avaliar a saúde mental e saúde física do aluno
* @author Walisson Farias
*/

public class Saude {
	
	 /**
	 * Identifica como está a saúde mental do aluno.
	 */
	
	private String saudeMental;
	
	 /**
	* Identifica como está a saúde física do aluno.
	*/
	
	private String saudeFisica;
	
	/**
	* Identifica como está a saúde geral do aluno.
	*/

	public String statusGeral;
	
	/**
	* O construtor 'Saude' não há parâmetros
	* Define a saúde mental e saúde física do aluno inicialmente como 'boa'.
	*/
	
	public Saude() {
		this.saudeMental = "boa";
		this.saudeFisica = "boa";
	}
	
	/**
	* O método 'defineSaudeMental' recebe o parâmetro 'valor' que armazena a condição atual da saúde mental do aluno.
	*/
	
    public void defineSaudeMental(String valor) {
    	this.saudeMental = valor;
    }
    
	/**
	* O método 'defineSaudeFisica' recebe o parâmetro 'valor' que armazena a condição atual da saúde física do aluno.
	*/
    
    public void defineSaudeFisica(String valor) {
    	this.saudeFisica = valor;
    }
    
	/**
	* O método 'getStatusGeral' retorna a condição geral de saúde do Aluno
	* Se a saúde mental e física estiverem boas, é retornada a string 'boa'
	* Se a saúde mental e física estiverem fracas, é retornada a string 'fraca'
	* Se ambas (saúde mental e saúde física) forem diferentes, é retornada a string 'ok'.
	*/
    
    public String getStatusGeral() {
    	if (saudeMental == "boa" && saudeFisica == "boa") {
    		return "boa";
    	} else if (saudeMental == "fraca" && saudeFisica == "fraca") {
    		return "fraca";
    	} else {
    		return "ok";
    	}
	}
}
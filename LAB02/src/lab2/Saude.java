package lab2;

/**
* Essa Classe serve para avaliar a saúde mental e saúde física do aluno.
* @author Walisson Farias - 1172107016
*/

public class Saude {
	
	private String saudeMental;
	private String saudeFisica;
	private String emoji;
	
	/**
	 * O construtor 'Saude' não recebe parâmetros
	 * É definido inicialmente a saúde mental e saúde física do aluno como 'boa'
	 * O emoji é dado por uma string vazia.
	 */
	
	public Saude() {
		this.saudeMental = "boa";
		this.saudeFisica = "boa";
		this.emoji = "";
	}
	
	/**
	 * 	O método 'defineSaudeMental' recebe o parâmetro 'valor' que armazena a condição atual da saúde mental do aluno.
	 */
	
    public void defineSaudeMental(String valor) {
    	this.saudeMental = valor;
    }
    
	/**
	 *	O método 'defineSaudeFisica' recebe o parâmetro 'valor' que armazena a condição atual da saúde física do aluno.
	 */
    
    public void defineSaudeFisica(String valor) {
    	this.saudeFisica = valor;
    }
    
	/**
	 * 	O método 'definirEmoji' recebe um parâmetro 'valor' e atribui esse 'valor' à variável 'emoji'
	 */
    
    public void definirEmoji(String valor) {
    	this.emoji = valor;
    }
    
    /**	O método 'avaliaSaude' verifica a saúde geral do aluno.
     * 	Se a saúde mental e a saúde física estiverem ambas boas, é retornada a string 'boa'
     *  Se a saúde mental e a saúde física estiverem ambas fracas, é retornada a string 'fraca'
     *  Se forem diferentes (Por ex: saúde física 'boa' e saúde mental 'fraca'), é retornada a string 'ok'
     * 	@returns a avaliação da saúde do aluno
     */
    
    private String avaliaSaude() {
    	if (saudeMental == "boa" && saudeFisica == "boa") {
    		return "boa";
    	} else if (saudeMental == "fraca" && saudeFisica == "fraca") {
    		return "fraca";
    	} else {
    		return "ok";
    	}
    }
    
    /**	
     * 	@returns uma string com a avaliação geral da saúde do aluno e um emoji (caso tenha sido definido).
     */
    
    public String getStatusGeral() {
    	return this.avaliaSaude() + " " + this.emoji;	
	}
}
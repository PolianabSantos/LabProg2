package lab2;

public class Saude {
	
	private String saudeMental;
	private String saudeFisica;
	public String statusGeral;
	
	public Saude() {
		this.saudeMental = "boa";
		this.saudeFisica = "boa";
	}
	
    public void defineSaudeMental(String valor) {
    	this.saudeMental = valor;
    }
    
    public void defineSaudeFisica(String valor) {
    	this.saudeFisica = valor;
    }
    
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
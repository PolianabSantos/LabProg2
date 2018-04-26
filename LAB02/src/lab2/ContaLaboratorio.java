package lab2;

public class ContaLaboratorio {
	
	private String nomeLaboratorio;
	private int espacoOcupado;
	private int cota;
	
	public ContaLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.espacoOcupado = 0;
		this.cota = 2000;
	}
	
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.espacoOcupado = 0;
		this.cota = cota;
	}
	
	public void consomeEspaco(int mbytes) {
		this.espacoOcupado += mbytes;	
	}

	public void liberaEspaco(int mbytes) {
		this.espacoOcupado -= mbytes;
	}
	
	public boolean atingiuCota() {
		if (espacoOcupado >= 2000) {
			return true;
		} else {
			return false;
		}
	}
		
	public String toString() {
		return this.nomeLaboratorio + " " + this.espacoOcupado + "/" + this.cota;
	}
}
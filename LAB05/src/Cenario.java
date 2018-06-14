public class Cenario {
	
	private int id;
	private String descricao;
	private String estado;
	
	public Cenario(String descricao) {
		this.id = id;
		this.descricao = "";
		this.estado = "Não finalizado";
	}

	@Override
	public String toString() {
		return this.id + " - " + this.descricao + " - " + this.estado;
	}
	
}

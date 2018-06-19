public class Estado {

	private String estado;
	
	public Estado(String estado) {
		this.estado = estado;
	}
	
	public String naoFinalizado() {
		return "Não finalizado.";
	}
	
	public String finalizadoOcorreu() {
		return "Finalizado (Ocorreu)";
	}
	
	public String finalizadoNaoOcorreu() {
		return "Finalizado (Não ocorreu)";
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	@Override
	public String toString() {
		return this.getEstado();
	}

}

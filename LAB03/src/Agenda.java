public class Agenda {
	
	private Contato[] contatos;
	
	public Agenda () {
		this.contatos = new Contato[100];
	}
	
	public boolean verificaPosicao(int posicao) {
		if (posicao < 1 || posicao > 100) {
			return false;
		}
		return true;
	}
	
	public boolean verificaContato(int posicao) {
		if (this.verificaPosicao(posicao)) {
			if (this.contatos[posicao] == null) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	public void cadastrarContato(String nome, String sobrenome, String telefone, int posicao) {
		Contato contato = new Contato(nome, sobrenome, telefone);
		this.contatos[posicao-1] = contato;
	}
	
	public String exibirContato(int posicao) {
		Contato c = this.contatos[posicao-1];
		return c.toString();
	}
	
	public String listarContatos() {
		String listaDeContatos = "";
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				listaDeContatos += (i) + " - " + contatos[i].dadosContato() + System.lineSeparator();
			}
		}
		return listaDeContatos;
	}
}
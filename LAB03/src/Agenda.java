/**
 * 
 * A classe 'Agenda' serve para armazenar todos os contatos, nela é possível cadastrar, 
 * exibir e listar os contatos cadastrados
 * Nela também contém os métodos 'verificaPosicao' e 'verificaContato'
 * @author Walisson Farias - 117210716
 *
 */
public class Agenda {
	
	/**
	 * É criado o array 'contatos' de objetos do tipo 'Contato'
	 */

	private Contato[] contatos;
	
	/**
	 * É criado o objeto Agenda, que armazena o array 'contatos' com 100 posições
	 */
	
	public Agenda () {
		this.contatos = new Contato[100];
	}
	
	/**
	 * O método 'verificaPosicao' verifica se a posição dada como parâmetro está no intervalo de 1 a 100.
	 * Se estiver no intervalo, retorna o valor 'true', se contrário, retorna o valor 'false' 
	 * @param posicao A posição do contato no array
	 * @return true or false
	 */
	
	public boolean verificaPosicao(int posicao) {
		if (posicao < 1 || posicao > 100) {
			return false;
		}
		return true;
	}
	
	/**
	 * O método 'verificaContato' verifica se um contato já existe no array 'contatos'
	 * Primeiro, verifica-se através do método anterior 'verificaPosicao', se a posicao
	 * dada no parâmetro é válida ou não. Se a posição for inválida, o método já retorna false
	 * Se a posição for válida, é verificado se a posição do contato tem valor 'null'
	 * Se tiver valor 'null', é retornado o valor booleano 'false', 
	 * mas se a posição não tiver valor 'null', é retornado o valor booleano 'true'.
	 * @param posicao A posição do contato no array
	 * @return true or false 
	 */
	
	public boolean verificaContato(int posicao) {
		if (this.verificaPosicao(posicao)) {
			if (this.contatos[posicao-1] == null) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * O método 'cadastrarContato' cria um contato do tipo Contato, com os parâmetros nome, sobrenome e telefone
	 * Depois, armazena esse contato no array 'contatos', na posição dada pelo parâmetro 'posição'
	 * @param nome O nome do contato
	 * @param sobrenome O sobrenome do contato
	 * @param telefone O telefone do contato
	 * @param posicao A posição que o contato ocupará no array
	 */
	
	public boolean cadastrarContato(String nome, String sobrenome, String telefone, int posicao) {
		Contato contato = new Contato(nome, sobrenome, telefone);
		if (verificaPosicao(posicao)) {
			this.contatos[posicao-1] = contato;
		}
		return verificaContato(posicao);
	}
	
	/**
	 * O método 'exibirContato' serve para exibir o contato cadastrado através da posição dada.
	 * Nele é criado um objeto 'c' do tipo Contato, e esse objeto armazena os dados referente
	 * ao contato dado pela posição no array 'contatos', depois retorna um String com dados desse contato 
	 * @param posicao Posição do contato no array 'contatos'
	 * @return String contendo os dados do contato (nome, sobrenome e telefone)
	 */
	
	public String exibirContato(int posicao) {
		Contato c = this.contatos[posicao-1];
		return c.toString();
	}
	
	/**
	 * O método 'listarContatos' serve para listar todos os contatos cadastrados na agenda.
	 * Não recebe parâmetros e inicialmente é criada uma variável com string vazia com nome 'listaDeContatos'
	 * O array contatos é percorrido, e todos os valores com índices nulos (nulos = posições com valores 'null'
	 * são posições que não tem dados cadastrados), se a posição do array não tiver valor 'null', armazena-se no 
	 * string 'listaDeContatos' os dados do contato que inclui (Posição, nome e sobrenome)
	 * OBS: 'dadosContato' é um método que retorna o nome completo do contato.
	 * @return listaDeContatos String contendo todos os contatos cadastrados na agenda
	 */
	
	public String listarContatos() {
		String listaDeContatos = "";
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				listaDeContatos += (i+1) + " - " + contatos[i].dadosContato() + System.lineSeparator();
			}
		}
		return listaDeContatos;
	}
}
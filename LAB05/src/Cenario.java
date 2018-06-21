import java.util.ArrayList;
import java.util.List;
import enums.Estado;

/**
 * Representação de um Cenario onde serão criadas as apostas
 * Cada cenário possui uma numeração única que o identifica, uma descrição, um estado
 * que indica sua finalização e/ou ocorrência e uma lista de apostas feitas sobre ele.
 * @author Walisson Farias - 117210716
 */

public class Cenario {

	private int numeracao;
	private String descricao;
	private List<Aposta> apostas;
	private Estado estado;
	
	/**
	 * Constrói um cenario com os parâmetros 'descricao' e 'numeracao'
	 * O estado do cenário é iniciado como 'NAO_FINALIZADO'
	 * @param descricao A descrição de um cenario
	 * @param numeracao O número inteiro que representa o cenário
	 */

	public Cenario(String descricao, int numeracao) {	
		this.numeracao = numeracao;
		if (descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		this.descricao = descricao;
		this.estado = Estado.NAO_FINALIZADO;
		this.apostas = new ArrayList<>();
	}

	public int getNumeracao() {
		return this.numeracao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	/**
	 * O método 'cadastraAposta' cria uma aposta e armazena no ArrayList 'apostas'.
	 * @param nomeApostador String representando o nome do apostador
	 * @param valorAposta int representando o valor da aposta
	 * @param previsao String representando a previsão dada pelo apostador
	 */

	public void cadastraAposta(String nomeApostador, int valorAposta, String previsao) {
		Aposta aposta = new Aposta(nomeApostador, valorAposta, previsao);
		this.apostas.add(aposta);
	}
	
	/**
	 * O método 'valorTotalDeApostas' soma na variável 'valorTotal'
	 * todos os valores das apostas e depois retorna a variável.
	 * @return Inteiro contendo a soma do valor total de apostas
	 */

	public int valorTotalDeApostas() {
		int valorTotal = 0;
		for (Aposta aposta : this.apostas) {
			valorTotal += aposta.getValor();
		}
		return valorTotal;
	}
	
	/**
	 * O método 'totalDeApostas' verifica a quantidade de apostas e depois retorna essa quantidade.
	 * @param cenario Inteiro que representa um cenário
	 * @return a quantidade de apostas do cenário dado como parâmetro
	 */

	public int totalDeApostas(int cenario) {
		return this.apostas.size();
	}
	
	/**
	 * O método 'exibeApostas' exibe as apostas feitas no cenário dado como parâmetro.
	 * @param cenario Inteiro que representa um cenário
	 * @return String contendo todas as apostas realizadas no cenário dado como parâmetro
	 */

	public String exibeApostas(int cenario) {
		String listagem = "";
		for (Aposta aposta : apostas) {
			listagem += aposta.toString();
		}
		return listagem;
	}
	
	/**
	 * O método 'fechaAposta' modifica o estado de um cenário
	 * Se o valor boleano for 'true' significa que o estado foi finalizado e ocorreu
	 * Se não, significa que o estado foi finalizado mas não ocorreu.
	 * @param cenario Inteiro que representa o cenário a ser fechado
	 * @param ocorreu boolean que modifica o estado de um cenário.
	 */

	public void fechaAposta(boolean ocorreu) {
		if (this.estado != Estado.NAO_FINALIZADO) {	
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		if (ocorreu) {
			this.estado = Estado.FINALIZADO_OCORREU;
		} else {
			this.estado = Estado.FINALIZADO_N_OCORREU;
		}
	}

	public int somaApostasPerdedoras() {
		int soma = 0;
		if (this.estado == Estado.FINALIZADO_N_OCORREU) {
			for (Aposta aposta : apostas) {
				if (aposta.getPrevisao() == true) {
					soma += aposta.getValor();
				}
			}
		} else if (this.estado.equals(Estado.FINALIZADO_OCORREU)) {
			for (Aposta aposta : apostas) {
				if (aposta.getPrevisao() == false) {
					soma += aposta.getValor();
				}
			}
		}
		return soma;
	}

	/**
	 * O método 'getCaixaCenario' recupera o valor do caixa de um cenário.
	 * @param taxa double A representação da taxa do cenário
	 * @param cenario int A representação de um cenário
	 * @return int A representação do valor do caixa de um cenário.
	 */
	
	public int getCaixaCenario(double taxa) {
		return (int) Math.floor(this.somaApostasPerdedoras() * taxa);
	}
	
	/**
	 * O método 'valorRateio' calcula o valor que será distribuido entre as apostas vencedoras.
	 * @param taxa A representação da taxa do cenário
	 * @param cenario A representação de um cenário
	 * @return int A representação do valor de rateio de um cenário
	 */

	public int valorRateio(double taxa) {
		return this.somaApostasPerdedoras() - this.getCaixaCenario(taxa);
	}
	
	/**
	 * Gera o HashCode de um Cenario a partir do atributo numeracao.
	 * @returns O Hashcode do Cenario.
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeracao;
		return result;
	}
	
	/**
	 * Avalia se o Cenario é ou não igual a outro Object
	 * Dois cenários são iguais se possuem a mesma numeração
	 * @param obj O objeto a ser comparado com o Cenario executando o equals.
	 * @return O boolean equivalente ao resultado do teste de igualdade.
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cenario other = (Cenario) obj;
		if (numeracao != other.numeracao)
			return false;
		return true;
	}
	
	/**
	 * Retorna a String que representa o Cenario.
	 * O formato da representação varia conforme o estado, mas segue o padrão:
	 * "NUMERAÇÃO - DESCRIÇÃO DO CENARIO - ESTADO ATUAL DO CENARIO"
	 * @return A representação em String do cenário
	 */
	
	@Override
	public String toString() {
		String stringCenario = "";
		if (estado == Estado.FINALIZADO_OCORREU) {
			stringCenario += getNumeracao() + " - " + this.descricao + " - " + "Finalizado (ocorreu)";
		} else if (estado == Estado.FINALIZADO_N_OCORREU) {
			stringCenario += getNumeracao() + " - " + this.descricao + " - " + "Finalizado (n ocorreu)";
		} else if (estado == Estado.NAO_FINALIZADO) {
			stringCenario += getNumeracao() + " - " + this.descricao + " - " + "Nao finalizado";
		}
		return stringCenario;
	}

}

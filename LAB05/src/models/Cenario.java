package models;

import java.util.ArrayList;
import java.util.List;

import enums.Estado;

/**
 * Representação de um Cenario onde serão criadas as apostas Cada cenário possui
 * uma numeração única que o identifica, uma descrição, um estado que indica sua
 * finalização e/ou ocorrência e uma lista de apostas feitas sobre ele.
 * 
 * @author Walisson Farias - 117210716
 */

public class Cenario {

	private String descricao;
	private List<Aposta> apostas;
	public Estado estado;
	public int numeracao;

	/**
	 * Constrói um cenario com os parâmetros 'descricao' e 'numeracao' O estado do
	 * cenário é iniciado como 'NAO_FINALIZADO'
	 * 
	 * @param descricao
	 *            A descrição de um cenario
	 * @param numeracao
	 *            O número inteiro que representa o cenário
	 */

	public Cenario(String descricao) {
		if (descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		this.descricao = descricao;
		this.estado = Estado.NAO_FINALIZADO;
		this.apostas = new ArrayList<>();
		this.numeracao = 0;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public int getNumeracao() {
		return this.numeracao;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	/**
	 * O método 'cadastraAposta' cria uma aposta e a armazena no ArrayList
	 * 'apostas'.
	 * 
	 * @param apostador
	 *            String representando o nome do apostador
	 * @param valor
	 *            int representando o valor da aposta
	 * @param previsao
	 *            String representando a previsão dada pelo apostador
	 */

	public void cadastraAposta(String apostador, int valor, String previsao) {
		this.numeracao++;
		Aposta aposta = new Aposta(apostador, valor, previsao);
		this.apostas.add(aposta);
	}

	/**
	 * O método 'cadastraAposta' cria uma aposta e a armazena no ArrayList
	 * 'apostas'. A diferença desse método para o anterior é que nesse também é
	 * cadastrado um valor que representa o seguro da aposta.
	 * 
	 * @param apostador
	 *            String que representa o nome do apostador
	 * @param valor
	 *            Inteiro representando o valor da aposta
	 * @param previsao
	 *            String representando a previsão dada pelo apostador
	 * @param valorSeguro
	 *            Inteiro representando o valor assegurado da aposta
	 * @return int Representação do tamanho do ArrayList 'apostas'
	 */

	public int cadastraAposta(String apostador, int valor, String previsao, int valorSeguro) {
		this.numeracao++;
		Aposta aposta = new ApostaAssegurada(apostador, valor, previsao, valorSeguro);
		this.apostas.add(aposta);
		return this.apostas.size();
	}

	/**
	 * O método 'cadastraAposta' cria uma aposta e a armazena no ArrayList
	 * 'apostas'. A diferença desse método para o anterior é que não se cadastra o
	 * valor assegurado e sim a taxa assegurada.
	 * 
	 * @param apostador
	 *            String que representa o nome do apostador
	 * @param valor
	 *            Inteiro representando o valor da aposta
	 * @param previsao
	 *            String representando a previsão dada pelo apostador
	 * @param taxa
	 *            Double representando a taxa assegurada da aposta
	 * @return int Representação do tamanho do ArrayList 'apostas'
	 */

	public int cadastraAposta(String apostador, int valor, String previsao, double taxa) {
		this.numeracao++;
		Aposta aposta = new ApostaAssegurada(apostador, valor, previsao, taxa);
		this.apostas.add(aposta);
		return this.apostas.size();
	}

	/**
	 * O método 'valorTotalDeApostas' soma na variável 'valorTotal' todos os valores
	 * das apostas e depois retorna a variável.
	 * 
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
	 * O método 'totalDeApostas' verifica a quantidade de apostas e depois retorna
	 * essa quantidade.
	 * 
	 * @param cenario
	 *            Inteiro que representa um cenário
	 * @return a quantidade de apostas do cenário dado como parâmetro
	 */

	public int totalDeApostas() {
		return this.apostas.size();
	}

	/**
	 * O método 'exibeApostas' exibe as apostas feitas no cenário dado como
	 * parâmetro.
	 * 
	 * @param cenario
	 *            Inteiro que representa um cenário
	 * @return String contendo todas as apostas realizadas no cenário dado como
	 *         parâmetro
	 */

	public String exibeApostas(int cenario) {
		String listagem = "";
		for (Aposta aposta : apostas) {
			listagem += aposta.toString();
		}
		return listagem;
	}

	/**
	 * O método 'fechaAposta' modifica o estado de um cenário Se o valor boleano for
	 * 'true' significa que o estado foi finalizado e ocorreu Se não, significa que
	 * o estado foi finalizado mas não ocorreu.
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário a ser fechado
	 * @param ocorreu
	 *            boolean que modifica o estado de um cenário.
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
	 * 
	 * @param taxa
	 *            double A representação da taxa do cenário
	 * @param cenario
	 *            int A representação de um cenário
	 * @return int A representação do valor do caixa de um cenário.
	 */

	public int getCaixaCenario(double taxa) {
		if (this.estado == Estado.NAO_FINALIZADO) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}
		return (int) Math.floor(this.somaApostasPerdedoras() * taxa);
	}

	/**
	 * O método 'valorRateio' calcula o valor que será distribuido entre as apostas
	 * vencedoras.
	 * 
	 * @param taxa
	 *            A representação da taxa do cenário
	 * @param cenario
	 *            A representação de um cenário
	 * @return int A representação do valor de rateio de um cenário
	 */

	public int valorRateio(double taxa) {
		return this.somaApostasPerdedoras() - this.getCaixaCenario(taxa);
	}

	/**
	 * Retorna a String que representa o Cenario. O formato da representação varia
	 * conforme o estado, mas segue o padrão: "NUMERAÇÃO - DESCRIÇÃO DO CENARIO -
	 * ESTADO ATUAL DO CENARIO"
	 * 
	 * @return A representação em String do cenário
	 */

	@Override
	public String toString() {
		String stringCenario = "";
		if (estado == Estado.FINALIZADO_OCORREU) {
			stringCenario += this.descricao + " - " + "Finalizado (ocorreu)";
		} else if (estado == Estado.FINALIZADO_N_OCORREU) {
			stringCenario += this.descricao + " - " + "Finalizado (n ocorreu)";
		} else if (estado == Estado.NAO_FINALIZADO) {
			stringCenario += this.descricao + " - " + "Nao finalizado";
		}
		return stringCenario;
	}

	/**
	 * O método 'alterarSeguroValor' verifica se o inteiro que representa a aposta
	 * assegurada é uma 'ApostaAssegurada', caso seja, modifica-se o valor do seguro
	 * atual pelo valor dado como parâmetro. Caso o parâmetro 'apostaAssegurada' não
	 * seja uma 'ApostaAssegurada', é criada uma exceção.
	 * 
	 * @param apostaAssegurada
	 *            Inteiro que representa a numeração da aposta
	 * @param valor
	 *            Inteiro que representa o seguro
	 * @return int Inteiro que representa a numeração da aposta
	 */

	public int alterarSeguroValor(int apostaAssegurada, int valor) {
		if (this.apostas.get(apostaAssegurada - 1) instanceof ApostaAssegurada) {
			((ApostaAssegurada) this.apostas.get(apostaAssegurada - 1)).setSeguro(valor);
			return apostaAssegurada;
		}
		throw new IllegalArgumentException("ESSA APOSTA NÃO POSSUI SEGURO!");
	}

	/**
	 * O método 'alterarSeguroTaxa' verifica se o inteiro que representa a aposta
	 * assegurada é uma 'ApostaAssegurada', caso seja, modifica-se a taxa do seguro
	 * atual pela taxa dada como parâmetro. Caso o parâmetro 'apostaAssegurada' não
	 * seja uma 'ApostaAssegurada', é criada uma exceção.
	 * 
	 * @param apostaAssegurada
	 *            Inteiro que representa a numeração da aposta
	 * @param taxa
	 *            Double que representa a taxa
	 * @return int Inteiro que representa a numeração da aposta
	 */

	public int alterarSeguroTaxa(int apostaAssegurada, double taxa) {
		if (this.apostas.get(apostaAssegurada - 1) instanceof ApostaAssegurada) {
			((ApostaAssegurada) this.apostas.get(apostaAssegurada - 1)).setSeguro(taxa);
			return apostaAssegurada;
		}
		throw new IllegalArgumentException("ESSA APOSTA NÃO POSSUI SEGURO!");
	}

	public int totalApostasPerdedoras() {
		if (this.estado.equals(Estado.NAO_FINALIZADO)) {
			throw new IllegalArgumentException("Cenario ainda esta aberto");
		}
		int total = 0;
		boolean ocorrencia = (this.estado.equals(Estado.FINALIZADO_OCORREU)) ? true : false;
		for (Aposta aposta : this.apostas) {
			if (aposta.getPrevisao() != ocorrencia) {
				total += aposta.getValor();
			}
		}
		return total;
	}

	public int pagamentoSeguros() {
		if (this.estado.equals(Estado.NAO_FINALIZADO)) {
			throw new IllegalArgumentException("Cenario ainda esta aberto");
		}
		int perdasGeradas = 0;
		boolean ocorrencia = (this.estado.equals(Estado.FINALIZADO_OCORREU)) ? true : false;
		for (Aposta aposta : this.apostas) {
			if (aposta.getPrevisao() != ocorrencia) {
				perdasGeradas += aposta.valorPerdido();
			}
		}
		return this.totalApostasPerdedoras() - perdasGeradas;
	}

}

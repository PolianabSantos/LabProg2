package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import enums.Estado;
import models.Cenario;
import models.CenarioBonus;
import models.CenarioPorApostas;
import models.CenarioPorCadastro;
import models.CenarioPorNome;

/**
 * Representação de um sistema de apostas
 * 
 * @author Walisson Farias - 117210716 em que são cadastrados diversos cenários
 *         e nesses cenários serão feitas apostas. São atributos do controle:
 *         Sua numeração, seu caixa, a taxa e uma lista onde serão armazenados
 *         os cenários.
 * 
 */

public class Controle {

	private int caixa;
	private double taxa;
	private List<Cenario> cenarios;
	private Comparator<Cenario> ordemAtrib;

	/**
	 * Constrói um Controle com um valor de caixa e um valor de taxa. O
	 * ArrayList é iniciado e a numeração é iniciada com valor 0.
	 * 
	 * @param caixa
	 *            Valor inteiro que representa o caixa
	 * @param taxa
	 *            Valor double que representa a taxa
	 */

	public Controle(int caixa, double taxa) {
		if (caixa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
		if (taxa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
		this.caixa = caixa;
		this.taxa = taxa;
		this.cenarios = new ArrayList<>();
		this.ordemAtrib = new CenarioPorCadastro();
	}

	public int getCaixa() {
		return this.caixa;
	}

	public double getTaxa() {
		return this.taxa;
	}

	public int getQuantidadeCenarios() {
		return this.cenarios.size();
	}

	/**
	 * O método 'cadastraCenario' cadastra um cenário no ArrayList 'cenarios'
	 * Cria-se um cenário com os parâmetros dados (descrição e numeração).
	 * 
	 * @param descricao
	 *            A descrição do cenário.
	 * @return O valor inteiro que representa a posição do cenário no Arraylist
	 *         'cenarios'
	 */

	public int cadastraCenario(String descricao) {
		Cenario cenario = new Cenario(descricao, this.cenarios.size() + 1);
		this.cenarios.add(cenario);
		return this.cenarios.size();
	}

	/**
	 * Esse outro método 'cadastraCenario' cadastra um cenário no ArrayList
	 * 'cenarios' Cria-se um cenário com os parâmetros dados (descrição,
	 * numeração e bônus).
	 * 
	 * @param descricao
	 *            A descrição do cenário.
	 * @param bonus
	 *            O bônus que será retirado imediatamente do caixa e colocado no
	 *            cenário
	 * @return O valor inteiro que representa a posição do cenário no Arraylist
	 *         'cenarios'
	 */

	public int cadastraCenario(String descricao, int bonus) {
		if (bonus <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		}
		this.caixa -= bonus;
		Cenario cenario = new CenarioBonus(descricao, bonus, this.cenarios.size() + 1);
		this.cenarios.add(cenario);
		return this.cenarios.size();
	}

	/**
	 * O método 'exibeCenario' analisa o ArrayList 'cenarios' e retorna o método
	 * 'toString' desse cenário informado no parâmetro.
	 * 
	 * @param cenario
	 *            inteiro que representa um cenário
	 * @return String contendo a representação de um cenário
	 */

	public String exibeCenario(int cenario) {
		if (cenario < 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		}
		if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		return this.cenarios.get(cenario - 1).toString();
	}

	/**
	 * O método 'listarCenariosCadastrados' salva na variável 'listagem' todos
	 * os cenários cadastrados até o momento.
	 * 
	 * @return String contendo a representação de todos os cenários cadastrados.
	 */

	public String listarCenariosCadastrados() {
		String listagem = "";
		for (Cenario cenario : cenarios) {
			listagem += cenario.toString() + System.lineSeparator();
		}
		return listagem;
	}

	/**
	 * O método 'cadastrarAposta' cadastra uma aposta com os parâmetros
	 * (nomeApostador, valorAposta, previsao) no cenário dado como parâmetro,
	 * que está dentro do ArrayList 'cenarios'.
	 * 
	 * @param cenario
	 *            Inteiro que representa o número do cenário
	 * @param apostador
	 *            String que representa o nome do apostador
	 * @param valor
	 *            Inteiro que representa o valor apostado
	 * @param previsao
	 *            String que representa a previsão feita pelo apostador
	 */

	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		}
		if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		if (apostador == null || (apostador.trim().equals(""))) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
		if (previsao == null || (previsao.trim().equals(""))) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}
		if (!(previsao.equals("VAI ACONTECER") || (previsao.equals("N VAI ACONTECER")))) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}
		this.cenarios.get(cenario - 1).cadastraAposta(apostador, valor, previsao);
	}

	/**
	 * O método 'cadastrarAposta' cadastra uma aposta com os parâmetros
	 * fornecidos (apostador, valor, previsao e valorSeguro) Antes de cadastrar
	 * a aposta, é repassado ao caixa o valor do custo (fornecido como
	 * parâmetro)
	 * 
	 * @param cenario
	 *            Inteiro que identifica o número do cenário (onde a aposta será
	 *            cada cadastrada)
	 * @param apostador
	 *            String que representa o nome do apostador
	 * @param valor
	 *            Inteiro que representa o valor da aposta
	 * @param valorSeguro
	 *            Inteiro que representa o valor do seguro
	 * @param previsao
	 *            String que representa a previsão feita pelo apostador
	 * @param custo
	 *            Valor que será adicionado ao caixa do sistema
	 * @return int Inteiro que identifica a aposta cadastrada.
	 */

	public int cadastrarAposta(int cenario, String apostador, int valor, String previsao, int valorSeguro, int custo) {
		if (apostador == null || (apostador.trim().equals(""))) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
		}
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
		}
		if (previsao == null || (previsao.trim().equals(""))) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por valor: Previsao nao pode ser vazia ou nula");
		}
		if (!(previsao.equals("VAI ACONTECER") || (previsao.equals("N VAI ACONTECER")))) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao invalida");
		}
		this.caixa += custo;
		return this.cenarios.get(cenario - 1).cadastraAposta(apostador, valor, previsao, valorSeguro);
	}

	/**
	 * O método 'cadastrarAposta' cadastra uma aposta com os parâmetros
	 * fornecidos (apostador, valor, previsao e taxa) Antes de cadastrar a
	 * aposta, é repassado ao caixa o valor do custo (fornecido como parâmetro)
	 * 
	 * @param cenario
	 *            Inteiro que identifica o número do cenário (onde a aposta será
	 *            cada cadastrada)
	 * @param apostador
	 *            String que representa o nome do apostador
	 * @param valor
	 *            Inteiro que representa o valor da aposta
	 * @param taxa
	 *            Double que representa a taxa do seguro
	 * @param previsao
	 *            String que representa a previsão feita pelo apostador
	 * @param custo
	 *            Valor que será adicionado ao caixa do sistema
	 * @return int Inteiro que identifica a aposta cadastrada.
	 */

	public int cadastrarAposta(int cenario, String apostador, int valor, String previsao, double taxa, int custo) {
		if (apostador == null || (apostador.trim().equals(""))) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
		}
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Valor nao pode ser menor ou igual a zero");
		}
		if (previsao == null || (previsao.trim().equals(""))) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aposta assegurada por taxa: Previsao nao pode ser vazia ou nula");
		}
		if (!(previsao.equals("VAI ACONTECER") || (previsao.equals("N VAI ACONTECER")))) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao invalida");
		}
		this.caixa += custo;
		return this.cenarios.get(cenario - 1).cadastraAposta(apostador, valor, previsao, taxa);
	}

	/**
	 * O método 'valorTotalDeApostas' chama o método 'valorTotalDeApostas' da
	 * classe 'Cenario' e nele é calculado o valor total das apostas feitas em
	 * um cenário.
	 * 
	 * @param cenario
	 *            Inteiro que representa o número de um cenário
	 * @return int Valor do total de apostas de um cenário.
	 */

	public int valorTotalDeApostas(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		}
		if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		return this.cenarios.get(cenario - 1).valorTotalDeApostas();
	}

	/**
	 * O método 'totalDeApostas' chama o método 'totalDeApostas' da classe
	 * 'Cenario'new CenarioPorCadastro(); e nele é calculado a quantidade de
	 * apostas de um cenário.
	 * 
	 * @param cenario
	 *            Inteiro que representa o número de um cenário
	 * @return int Valor da quantidade de apostas de um cenário.
	 */

	public int totalDeApostas(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		}
		if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}
		return this.cenarios.get(cenario - 1).totalDeApostas();
	}

	/**
	 * O método 'exibeApostas' gera a representação textual das apostas de um
	 * cenário (uma aposta por linha)
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário a ser exibido
	 * @return String contendo a representação textual das apostas.
	 */

	public String exibeApostas(int cenario) {
		return this.cenarios.get(cenario - 1).exibeApostas(cenario);
	}

	/**
	 * O método 'fecharAposta' finaliza um cenário e indica se ele ocorreu ou
	 * não.
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário a ser finalizado
	 * @param ocorreu
	 *            Boleano que representa a ocorrência de um cenário (se ocorreu
	 *            ou não).
	 */

	public void fecharAposta(int cenario, boolean ocorreu) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		}
		if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
		if (this.cenarios.get(cenario).getEstado() == Estado.FINALIZADO_OCORREU) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		if (this.cenarios.get(cenario).getEstado() == Estado.FINALIZADO_N_OCORREU) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		this.cenarios.get(cenario - 1).fechaAposta(ocorreu);
		this.caixa += this.valorCaixaCenario(cenario);
		this.caixa -= this.cenarios.get(cenario - 1).pagamentoSeguros();
	}

	/**
	 * O método 'valorCaixaCenario' verifica o valor do caixa de um cenário dado
	 * como parâmetro.
	 * 
	 * @param cenario
	 *            Inteiro que representa o número de um cenário
	 * @return int Representação do valor do caixa de um cenário
	 */

	public int valorCaixaCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		}
		if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
		return this.cenarios.get(cenario - 1).getCaixaCenario(this.taxa);
	}

	/**
	 * O método 'valorRateio calcula o valor de rateio do cenário encerrado que
	 * será destinado a distribuição entre as apostas vencedoras.
	 * 
	 * @param cenario
	 *            Inteiro que representa o número de um cenário
	 * @return inteiro contendo o valor do rateio.
	 */

	public int valorRateio(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		}
		if (cenario > cenarios.size()) {
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
		if (this.cenarios.get(cenario - 1).getEstado() == Estado.NAO_FINALIZADO) {
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
		return this.cenarios.get(cenario - 1).valorRateio(this.taxa);
	}

	/**
	 * O método 'alterarSeguroValor' modifica o valor de determinada aposta
	 * assegurada de um determinado cenário. new CenarioPorCadastro();
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário
	 * @param apostaAssegurada
	 *            Inteiro que representa a aposta assegurada
	 * @param valor
	 *            Inteiro que representa o valor do seguro
	 * @return int Inteiro que é a representação da alteração do valor
	 */

	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		return this.cenarios.get(cenario - 1).alterarSeguroValor(apostaAssegurada, valor);
	}

	/**
	 * O método 'alterarSeguroTaxa' modifica a taxa de determinada aposta
	 * assegurada de um determinado cenário.
	 * 
	 * @param cenario
	 *            Inteiro que representa o cenário
	 * @param apostaAssegurada
	 *            Inteiro que representa a aposta assegurada
	 * @param taxa
	 *            double que representa a taxa do seguro
	 * @return int Inteiro que é a representação da alteração da taxa
	 */

	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		return this.cenarios.get(cenario - 1).alterarSeguroTaxa(apostaAssegurada, taxa);
	}

	/**
	 * O método 'alterarOrdem' recebe o parâmetro ordem e verifica se o mesmo
	 * equivale a "cadastro", "apostas" ou "nome". Se equivale a "cadastro",
	 * ordemAtrib cria um cenario por ordem de cadastro; Se equivale a
	 * "apostas", ordemAtrib cria um cenario por ordem de quantidade de apostas;
	 * Se equivale a "nome", ordemAtrib cria um cenario por ordem lexográfica;
	 *
	 * @param ordem
	 *            String representando a opção de ordenação
	 */

	public void alterarOrdem(String ordem) {
		if (ordem == null || (ordem.trim().equals(""))) {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");
		}
		if (ordem.equals("cadastro")) {
			this.ordemAtrib = new CenarioPorCadastro();
		} else if (ordem.equals("apostas")) {
			this.ordemAtrib = new CenarioPorApostas();
		} else if (ordem.equals("nome")) {
			this.ordemAtrib = new CenarioPorNome();
		} else {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem invalida");
		}
	}

	/**
	 * O método 'exibirCenarioOrdenado' faz uma cópia do ArrayList 'cenarios' e
	 * atribui à variável auxiliar 'aux'. Chama-se o método '.sort' de
	 * Collections, e ordena o Array 'aux' para a opção de ordenação contida em "ordemAtrib" 
	 * @param cenario Inteiro que representa o cenário
	 * @return String contendo a representação textual do cenário (ordenado)
	 */

	public String exibirCenarioOrdenado(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: Cenario invalido");
		}
		if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: Cenario nao cadastrado");
		}
		ArrayList<Cenario> aux = new ArrayList<>(this.cenarios);
		Collections.sort(aux, ordemAtrib);
		return aux.get(cenario-1).toString();
	}

}

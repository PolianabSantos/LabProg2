package lab2;

import java.util.Arrays;

/**
 * Essa classe é responsável por gerenciar os dados de uma disciplina
 * Os dados que importam pra essa classe são: nome da disciplina, horas trabalhadas,
 * a média e notas do aluno. 
 * @author Walisson Farias - 117210716
 */

public class Disciplina {
	
	private String nomeDisciplina;
	private int horasTrabalhadas;
	private double media;
	private double[] listaNotas;
	private int[] pesoNotas;
	private boolean parametrosTres;

    /**
     * Constrói uma disciplina a partir do seu nome
     * Nesse construtor as horas trabalhadas recebem valor 0
     * É criada também uma lista com 4 valores do tipo double que armazenarão as notas do aluno
     * A variável 'parametrosTres' é dada como falsa, pois nesse construtor há apenas um parâmetro.
     * @param nomeDisciplina o nome da disciplina
     */
	
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.horasTrabalhadas = 0;
		this.listaNotas = new double[4];
		this.parametrosTres = false;
	}
	
    /**
     * Constrói uma disciplina a partir do seu nome e sua quantidade de notas
     * @param nomeDisciplina o nome da disciplina
     * @param quantNotas a quantidade de notas
     * @param parametrosTres dado como falso, pois nesse construtor há apenas 2 parâmetros
     */
	
	public Disciplina(String nomeDisciplina, int quantNotas) {
		this.nomeDisciplina = nomeDisciplina;
		this.listaNotas = new double[quantNotas];
		this.parametrosTres = false;
	}
	
    /**
     * Constrói uma disciplina a partir do seu nome, sua quantidade de notas
     * e um array contendo o peso das notas. 
     * @param nomeDisciplina o nome da disciplina
     * @param pesoNotas o peso de cada nota
     * @param parametroTres é dado como 'true', pois nesse construtor há três parâmetros
     * @param listaNotas é criada um array do tipo 'double' de tamanho igual ao valor atribuído à variável 'quantNotas'
     */
	
	public Disciplina(String nomeDisciplina, int quantNotas, int[] pesoNotas) {
		this.nomeDisciplina = nomeDisciplina;
		this.pesoNotas = pesoNotas;
		this.parametrosTres = true;
		this.listaNotas = new double[quantNotas];
	}
	
	 /**
	   * O método 'cadastraHoras' recebe um parâmetro com valor inteiro que serve 
	   * para somar as horas de estudo do aluno.
	   */
	
	public void cadastraHoras(int horas) {
		this.horasTrabalhadas += horas;
	}
	
	 /**
	   * O método 'cadastraNota' recebe dois parâmetros: nota e valorNota.
	   * Serve para adicionar no array listaNotas a nota do aluno (valorNota)
	   * na posição indicada (nota).
	   * Nesse método também é calculada a média através do método 'calculaMedia'.
	   */
	
	
	public void cadastraNota(int nota, double valorNota) {
		listaNotas[nota-1] = valorNota;
		calculaMedia();
	}
	
	 /**
	   * Nesse método, será verificada se há três parâmetros, se sim, a média será calculada através de uma media ponderada;
	   * Se não forem usados três parâmetros, a média será calculada por um cálculo simples, sem uso dos pesos.
	   */
	
	public void calculaMedia() {
		
		if (parametrosTres) {
			media = 0;
			for (int i = 0; i < listaNotas.length; i++) {
				media += pesoNotas[i] * listaNotas[i];
			}
			media /= 10;
		}
		
		else {			
			double soma = 0;
			for (int i = 0; i < listaNotas.length; i++) {
				soma += listaNotas[i];
			}
			media = soma / listaNotas.length;
		}
	}
	
	 /**
	   * O método 'aprovado' retorna um valor verdadeiro ou falso
	   * Se a média do aluno for maior ou igual a 7 o valor boolean 'true' é retornado,
	   * e se for menor é retornado o valor boolean 'false'
	   * @returns true (se a média for maior ou igual a 7)
	   * @returns false (se a média for menor que 7)
	   */
	
	public boolean aprovado() {
		if (media >= 7.0) 
			return true;
		else
			return false;
	}
	
	/**
	  * Retorna a String que representa os dados da disciplina/aluno. Segue no formato:
	  * "Nome da disciplina - Horas trabalhadas - Média - Array das notas do aluno"
	  * @returns a representação dos dados da disciplina em String.
	  */
	
	public String toString() {
		return this.nomeDisciplina + " " + this.horasTrabalhadas + " " + this.media + " " + Arrays.toString(listaNotas);
	}

}

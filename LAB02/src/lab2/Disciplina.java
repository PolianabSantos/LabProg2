package lab2;

import java.util.Arrays;

/**
 * Essa classe é responsável por gerenciar os dados de uma disciplina
 * Os dados que importam pra essa classe são: nome da disciplina, horas trabalhadas,
 * a média e notas do aluno. 
 * @author Walisson Farias
 */

public class Disciplina {
	
    /**
     * Esse atributo representa o nome da disciplina.
     */
	
	private String nomeDisciplina;
	
    /**
     * Esse atributo representa as horas de estudo.
     */
	
	private int horasTrabalhadas;
	
    /**
     * Esse atributo representa a média (que será calculada a partir das 4 notas).
     */
	
	private double media;
	
    /**
     * Esse atributo é um array que será usado para armazenar as notas do aluno.
     */
	
	private double[] listaNotas;

    /**
     * Constrói uma disciplina a partir do seu nome
     * Nesse construtor as horas trabalhadas recebem valor 0
     * É criada também uma lista com 4 valores do tipo double que armazenarão as notas do aluno.
     */
	
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.horasTrabalhadas = 0;
		this.listaNotas = new double[4];
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
	   * O método 'calculaMedia' cria a variável 'soma' (iniciada em 0), que, através de um 
	   * for, realiza a soma de todas as notas do aluno. Depois, é calculada a média do aluno.
	   */
	
	public void calculaMedia() {
		double soma = 0;
		for (int i = 0; i < listaNotas.length; i++) {
			soma += listaNotas[i];
		}
		
		media = soma / listaNotas.length;
	}
	
	 /**
	   * O método 'aprovado' retorna um valor verdadeiro ou falso.
	   * Se a média do aluno for maior ou igual a 7 o valor boolean 'true' é retornado,
	   * e se for menor é retornado o valor boolean 'false'.
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

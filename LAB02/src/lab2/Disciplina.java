package lab2;

import java.util.Arrays;

public class Disciplina {
	
	private String nomeDisciplina;
	private int horasTrabalhadas;
	private double media;
	private double[] listaNotas;

	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.horasTrabalhadas = 0;
		this.listaNotas = new double[4];
	}
	
	public void cadastraHoras(int horas) {
		this.horasTrabalhadas += horas;
	}
	
	public void cadastraNota(int nota, double valorNota) {
		listaNotas[nota-1] = valorNota;
		calculaMedia();
	}
	
	public void calculaMedia() {
		double soma = 0;
		for (int i = 0; i < listaNotas.length; i++) {
			soma += listaNotas[i];
		}
		
		media = soma / listaNotas.length;
	}
	
	public boolean aprovado() {
		if (media >= 7.0) 
			return true;
		else
			return false;
	}
	
	public String toString() {
		return this.nomeDisciplina + " " + this.horasTrabalhadas + " " + this.media + " " + Arrays.toString(listaNotas);
	}

}

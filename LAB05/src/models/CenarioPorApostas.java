package models;
import java.util.Comparator;

public class CenarioPorApostas implements Comparator<Cenario> {
	
	public int compare(Cenario c1, Cenario c2) {
		if (c1.totalDeApostas(c1.getNumeracao()) == c2.totalDeApostas(c2.getNumeracao())) {
			return c1.getNumeracao() - c2.getNumeracao();
		}
		return c2.totalDeApostas(c2.getNumeracao()) - c1.totalDeApostas(c1.getNumeracao());
	}
}
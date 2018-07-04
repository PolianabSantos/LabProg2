package models;
import java.util.Comparator;

public class CenarioPorApostas implements Comparator<Cenario> {
	
	public int compare(Cenario c1, Cenario c2) {
		if (c1.totalDeApostas() == c2.totalDeApostas()) {
			return c1.getId() - c2.getId();
		}
		return c2.totalDeApostas() - c1.totalDeApostas();
	}
}
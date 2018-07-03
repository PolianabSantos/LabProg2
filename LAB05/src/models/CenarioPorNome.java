package models;
import java.util.Comparator;

public class CenarioPorNome implements Comparator<Cenario> {
	
	@Override
	public int compare(Cenario c1, Cenario c2) {
		if (c1.getDescricao().equals(c2.getDescricao())) {
			return c1.getNumeracao() - c2.getNumeracao();
		}
		return c1.getDescricao().compareTo(c2.getDescricao());
	}
}
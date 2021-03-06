package models;
import java.util.Comparator;

public class CenarioPorNome implements Comparator<Cenario> {
	
	@Override
	public int compare(Cenario c1, Cenario c2) {
		return c1.getDescricao().compareTo(c2.getDescricao());
	}
}
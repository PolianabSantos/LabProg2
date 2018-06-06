import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe criada para testar os métodos utilizados na classe 'Grupo'
 * @author Walisson Farias - 117210716
 */

public class GrupoTest {

	private Grupo grupoteste;
	private Grupo grupoteste2;
	private Grupo grupoteste3;
	
	@Before
	public void setUp() {
		grupoteste = new Grupo("Listas");
		grupoteste2 = new Grupo("Listas");
		grupoteste3 = new Grupo("Listas2");
	}
	
	@Test(expected=NullPointerException.class)
	public void testeNomeNulo() {
		new Grupo(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testeNomeVazio() {
		new Grupo("");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testeNomeComEspacos() {
		new Grupo("     ");
	}
	
	@Test
	public void testeNome() {
		assertEquals(grupoteste.getNome(), "Listas");
	}
	
	@Test
	public void testeDoisGruposIguais() {
		assertTrue(grupoteste.equals(grupoteste2));
	}
	
	@Test
	public void testeDoisGruposDiferentes() {
		assertFalse(grupoteste.equals(grupoteste3));
	}

}

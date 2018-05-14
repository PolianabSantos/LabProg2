import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ContatoTest {

	private Contato c;

	@Before
	public void setUp() {
		c = new Contato("Walisson", "Farias", "(83) 9988-9211");
	}
	
	@Test(expected=NullPointerException.class)
	public void testeNomeNulo() {
		new Contato(null,"Farias","(83) 9988-9211");
	}
	
	@Test(expected=NullPointerException.class)
	public void testeSobrenomeNulo() {
		new Contato("Walisson", null, "(83) 9988-9211");
	}
	
	@Test(expected=NullPointerException.class)
	public void testeTelefoneNulo() {
		new Contato("Walisson", "Farias", null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testeNomeVazio() {
		new Contato("", "Farias", "(83) 9988-9211");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testeSobrenomeVazio() {
		new Contato("Walisson", "", "(83) 9988-9211");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testeTelefoneVazio() {
		new Contato("Walisson", "Farias", "");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testeNomeComEspacos() {
		new Contato("     ", "Farias", "(83) 9988-9211");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testeSobrenomeComEspacos() {
		new Contato("Walisson", "     ", "(83) 9988-9211");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testeTelefoneComEspacos() {
		new Contato("Walisson", "Farias", "        ");
	}
	
	@Test
	public void testeNome() {
		assertEquals(c.getNome(), "Walisson");
	}
	
	@Test
	public void testeSobrenome() {
		assertEquals(c.getSobrenome(), "Farias");
	}
	
	@Test
	public void testeTelefone() {
		assertEquals(c.getTelefone(), "(83) 9988-9211");
	}
	
}

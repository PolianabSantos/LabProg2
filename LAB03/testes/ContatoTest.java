import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Classe criada para testar os métodos utilizados na classe 'Contato'
 * @author Walisson Farias - 117210716
 *
 */

public class ContatoTest {

	private Contato contato1;
	private Contato contato2;
	private Contato contato3;

	@Before
	public void setUp() {
		contato1 = new Contato("Walisson", "Farias", "(83) 9988-9211");
		contato2 = new Contato("Walisson", "Ferreira", "(83) 00000-0000");
		contato3 = new Contato("Pedro", "Batista", "(83) 11111-1111");
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
		assertEquals(contato1.getNome(), "Walisson");
	}
	
	@Test
	public void testeSobrenome() {
		assertEquals(contato1.getSobrenome(), "Farias");
	}
	
	@Test
	public void testeTelefone() {
		assertEquals(contato1.getTelefone(), "(83) 9988-9211");
	}
	
	@Test
	public void testeDoisContatosIguais() {
		assertTrue(contato1.equals(contato2));
	}
	
	@Test
	public void testeDoisContatosDiferentes() {
		assertFalse(contato2.equals(contato3));
	}
	
}

package models;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Classe criada para testar os métodos utilizados na classe 'Aposta'
 * @author Walisson Farias - 117210716
 */

import org.junit.Test;

public class ApostaTest {
	
	private Aposta aposta;
	private Aposta aposta2;
	private Aposta aposta3;
	
	@Before
	public void setUp() {
		aposta = new Aposta("Alisson Farias", 800, "VAI ACONTECER");
		aposta2 = new Aposta("Marcos Sales", 100, "N VAI ACONTECER");
		aposta3 = null;
	}
	
	@Test
	public void constructorTest() {
		assertTrue(aposta3 == null);
		aposta3 = new Aposta("Pedro Gomes", 1500, "VAI ACONTECER");
		assertFalse(aposta3 == null);
	}

	@Test(expected=NullPointerException.class)
	public void testeApostadorNulo() {
		new Aposta(null, 800, "VAI ACONTECER");
	}
	
	@Test(expected=NullPointerException.class)
	public void testePrevisaoNula() {
		new Aposta("Alisson Farias", 800, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testeApostadorVazio() {
		new Aposta("", 800, "N VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testePrevisaoVazia() {
		new Aposta("Alisson Farias", 800, "");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testeApostadorComEspacos() {
		new Aposta("     ", 800, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testePrevisaoComEspacos() {
		new Aposta("Alisson Farias", 800, "      ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testeValorMenorQue0() {
		new Aposta("Alisson Farias", -800, "N VAI ACONTECER");
	}

	@Test
	public void testeValorEmReais() {
		assertEquals(aposta.getValor(), 8.0, 0.0005);
	}
	
	@Test
	public void testeValorEmCentavos() {
		assertEquals(aposta.getValor(), 800);
	}
	
	@Test
	public void testePrevisaoQueVaiAcontecer() {
		assertEquals(aposta.getPrevisao(), true);
	}
	
	@Test
	public void testePrevisaoQueNaoVaiAcontecer() {
		assertEquals(aposta2.getPrevisao(), false);
	}
	
}

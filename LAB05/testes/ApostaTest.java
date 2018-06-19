import static org.junit.Assert.*;

import org.junit.Before;

/**
 * Classe criada para testar os métodos utilizados na classe 'Aposta'
 * @author Walisson Farias - 117210716
 */

import org.junit.Test;

public class ApostaTest {
	
	private Aposta aposta;
	
	@Before
	public void setUp() {
		aposta = new Aposta("Alisson Farias", 800.00, "VAI ACONTECER");
	}

	@Test(expected=NullPointerException.class)
	public void testeApostadorNulo() {
		new Aposta(null, 800.00, "VAI ACONTECER");
	}
	
	@Test(expected=NullPointerException.class)
	public void testePrevisaoNula() {
		new Aposta("Alisson Farias", 800.00, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testeApostadorVazio() {
		new Aposta("", 800.00, "N VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testePrevisaoVazia() {
		new Aposta("Alisson Farias", 800.00, "");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testeApostadorComEspacos() {
		new Aposta("     ", 800.00, "VAI ACONTECER");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testePrevisaoComEspacos() {
		new Aposta("Alisson Farias", 800.00, "      ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testeValorMenorQue0() {
		new Aposta("Alisson Farias", -5.3, "N VAI ACONTECER");
	}
	
	@Test
	public void testeNomeApostador() {
		assertEquals(aposta.getApostador(), "Alisson Farias");
	}
	
	@Test
	public void testeValorDaAposta() {
		assertEquals(aposta.getValor(), 800.00, 0.005);
	}
	
	@Test
	public void testePrevisao() {
		assertEquals(aposta.getPrevisao(), "VAI ACONTECER");
	}
	
}

package models;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ApostaAsseguradaTest {

	private ApostaAssegurada aposta1;
	private ApostaAssegurada aposta2;
	
	@Before
	public void criarApostaAssegurada() {
		aposta1 = new ApostaAssegurada("Alisson Farias", 100, "VAI ACONTECER", 10);
		aposta2 = new ApostaAssegurada("Thalyta Barbosa", 150, "N VAI ACONTECER", 0.1);
	}
	
	@Test
	public void getApostadorTest() {
		assertEquals(aposta1.getApostador(), "Alisson Farias");
	}
	
	@Test
	public void getValorTest() {
		assertTrue(aposta1.getValor() == 100);
	}
	
	@Test
	public void getPrevisaoTest() {
		assertTrue(aposta1.getPrevisao() == true);
	}

	@Test
	public void testPerdaGerada() {
		assertTrue(aposta1.valorPerdido() == 90);
		assertTrue(aposta2.valorPerdido() == 135);
	}

	@Test
	public void testToString() {
		assertEquals(aposta1.toString(), "Alisson Farias - R$100 - VAI ACONTECER - ASSEGURADA (VALOR) - R$ 0,10");
		assertEquals(aposta2.toString(), "Thalyta Barbosa - R$150 - N VAI ACONTECER - ASSEGURADA (TAXA) - 10%");
	}
	
}

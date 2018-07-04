package models;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import enums.Estado;

public class CenarioBonusTest {

	private CenarioBonus cenario1;
	
	@Before
	public void criarCenarioBonus() {
		cenario1 = new CenarioBonus("Alisson vai tirar 10 na prova de LP2!", 1000, 1);
		cenario1.cadastraAposta("Alisson Farias", 500, "VAI ACONTECER");
		cenario1.cadastraAposta("Thalyta Barbosa", 1000, "N VAI ACONTECER");
		cenario1.cadastraAposta("Almir Crispiniano", 600, "N VAI ACONTECER");
	}

	@Test
	public void getDescricaoTest() {
		assertEquals(this.cenario1.getDescricao(), "Alisson vai tirar 10 na prova de LP2!");
	}

	@Test
	public void getBonusTest() {
		assertEquals(this.cenario1.getBonus(), 1000);
	}

	@Test
	public void getEstadoTest() {
		assertTrue(this.cenario1.getEstado() == Estado.NAO_FINALIZADO);
		assertFalse(this.cenario1.getEstado() == Estado.FINALIZADO_OCORREU);
	}
	
	@Test
	public void toStringTestCenarioBonusNaoFinalizado() {
		assertEquals(this.cenario1.toString(), "4 - Alisson vai tirar 10 na prova de LP2! - Nao finalizado - R$ 10,00");
	}

	@Test
	public void toStringTestCenarioBonusFinalizadoOcorreu() {
		this.cenario1.setEstado(Estado.FINALIZADO_OCORREU);
		assertEquals(this.cenario1.toString(), "4 - Alisson vai tirar 10 na prova de LP2! - Finalizado (ocorreu) - R$ 10,00");
	}

	@Test
	public void toStringTestCenarioBonusFinalizado() {
		this.cenario1.setEstado(Estado.FINALIZADO_N_OCORREU);
		assertEquals(this.cenario1.toString(), "4 - Alisson vai tirar 10 na prova de LP2! - Finalizado (n ocorreu) - R$ 10,00");
	}
	
	@Test
	public void testRateioCenario() {
		this.cenario1.setEstado(Estado.FINALIZADO_OCORREU);
		assertTrue(cenario1.valorRateio(0.1) == 16000);
	}
}

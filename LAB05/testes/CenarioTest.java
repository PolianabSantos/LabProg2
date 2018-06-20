import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import enums.Estado;

public class CenarioTest {

	private Cenario cenario1;
	private Cenario cenario2;

	@Before
	public void setUp() {
		cenario1 = new Cenario("O Brasil vai ganhar a copa!", 1);
		cenario2 = new Cenario("O Brasil não vai ganhar a copa!", 2);
		cenario1.cadastraAposta("Alisson Farias", 500, "VAI ACONTECER");
		cenario1.cadastraAposta("Thalyta Barbosa", 1000, "VAI ACONTECER");
	}

	@Test
	public void getDescricaoTest() {
		assertEquals(this.cenario1.getDescricao(), "O Brasil vai ganhar a copa!");
	}

	@Test
	public void getEstadoNaoFinalizadoTest() {
		assertEquals(this.cenario1.getEstado(), Estado.NAO_FINALIZADO);
	}

	@Test
	public void getEstadoFinalizadoOcorreuTest() {
		this.cenario1.setEstado(Estado.FINALIZADO_OCORREU);
		assertEquals(this.cenario1.getEstado(), Estado.FINALIZADO_OCORREU);
	}

	@Test
	public void getEstadoFinalizadoNaoOcorreuTest() {
		this.cenario1.setEstado(Estado.FINALIZADO_N_OCORREU);
		assertEquals(this.cenario1.getEstado(), Estado.FINALIZADO_N_OCORREU);
	}

	@Test
	public void setEstadoFinalizadoNaoOcorreuTest() {
		this.cenario1.setEstado(Estado.FINALIZADO_N_OCORREU);
		assertTrue(this.cenario1.getEstado().equals(Estado.FINALIZADO_N_OCORREU));
	}

	@Test
	public void setEstadoFinalizadoOcorreuTest() {
		this.cenario1.setEstado(Estado.FINALIZADO_OCORREU);
		assertTrue(this.cenario1.getEstado().equals(Estado.FINALIZADO_OCORREU));
	}

	@Test
	public void getNumeracaoTest() {
		assertTrue(this.cenario1.getNumeracao() == 1);
	}

	@Test
	public void toStringTestCenarioNaoFinalizado() {
		this.cenario1.setEstado(Estado.NAO_FINALIZADO);
		assertEquals(this.cenario1.toString(),
				"1 - O Brasil vai ganhar a copa! - Nao finalizado");
	}

	@Test
	public void toStringTestCenarioFinalizadoOcorreu() {
		this.cenario1.setEstado(Estado.FINALIZADO_OCORREU);
		assertEquals(this.cenario1.toString(),
				"1 - O Brasil vai ganhar a copa! - Finalizado (ocorreu)");
	}

	@Test
	public void toStringTestCenarioFinalizadoNaoOcorreu() {
		this.cenario1.setEstado(Estado.FINALIZADO_N_OCORREU);
		assertEquals(this.cenario1.toString(),
				"1 - O Brasil vai ganhar a copa! - Finalizado (n ocorreu)");
	}

	@Test
	public void cadastraApostaTest() {
		assertTrue(this.cenario1.totalDeApostas(1) == 2);
		assertFalse(this.cenario1.totalDeApostas(1) == 1);
	}

	@Test
	public void valorTotalApostas() {
		assertTrue(this.cenario1.valorTotalDeApostas() == 1500);
		assertFalse(this.cenario1.valorTotalDeApostas() == 1000);
	}

	@Test
	public void exibeApostasTest() {
		assertEquals(this.cenario1.exibeApostas(1), "Alisson Farias - R$5.0 - VAI ACONTECER" + System.lineSeparator()
				+ "Thalyta Barbosa - R$10.0 - VAI ACONTECER" + System.lineSeparator());
	}
	
	@Test
	public void valorApostasPerdedorasTest1() {
		this.cenario1.setEstado(Estado.FINALIZADO_N_OCORREU);
		assertTrue(this.cenario1.somaApostasPerdedoras(1) == 1500);
	}
	
	@Test
	public void valorApostasPerdedorasTest2() {
		this.cenario1.setEstado(Estado.FINALIZADO_OCORREU);
		assertTrue(this.cenario1.somaApostasPerdedoras(1) == 0);
	}
	
	@Test
	public void valorCaixaCenarioTest() {
		this.cenario1.setEstado(Estado.FINALIZADO_N_OCORREU);
		assertTrue(this.cenario1.valorCaixaCenario(0.01, 1) == 15);
	}
	
	@Test
	public void valorRateioTest() {
		this.cenario1.setEstado(Estado.FINALIZADO_N_OCORREU);
		assertTrue(this.cenario1.valorRateio(0.01, 1) == 1485);
	}

	@Test
	public void hashCodeTest1() {
		assertTrue(cenario1.hashCode() != cenario2.hashCode());
	}
	
	@Test
	public void hashCodeTeste2() {
		cenario2 = new Cenario("O Brasil não vai ganhar a copa!", 1);
		assertTrue(cenario1.hashCode() == cenario2.hashCode());
	}
	
	@Test
	public void equalsTest() {
		assertFalse(this.cenario1.equals(cenario2));
	}
	
}

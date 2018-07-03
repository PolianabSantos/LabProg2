package models;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import enums.Estado;

public class CenarioTest {

	private Cenario cenario1;
	private Cenario cenario2;
	private Cenario cenario3;

	@Before
	public void criarCenario() {
		cenario1 = new Cenario("O Brasil vai ganhar a copa!");
		cenario2 = new Cenario("Alisson irá todos os dias no São João de CG!");
		cenario3 = new Cenario("Thalyta vai tirar 10 na prova de LP2!");
		cenario1.cadastraAposta("Alisson Farias", 500, "VAI ACONTECER");
		cenario1.cadastraAposta("Thalyta Barbosa", 1000, "VAI ACONTECER");
		cenario2.cadastraAposta("Alisson Farias", 100, "VAI ACONTECER", 900);
		cenario3.cadastraAposta("Almir Crispiniano", 600, "N VAI ACONTECER", 0.1);
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
	public void toStringTestCenarioNaoFinalizado() {
		this.cenario1.setEstado(Estado.NAO_FINALIZADO);
		assertEquals(this.cenario1.toString(),
				"O Brasil vai ganhar a copa! - Nao finalizado");
	}

	@Test
	public void toStringTestCenarioFinalizadoOcorreu() {
		this.cenario1.setEstado(Estado.FINALIZADO_OCORREU);
		assertEquals(this.cenario1.toString(),
				"O Brasil vai ganhar a copa! - Finalizado (ocorreu)");
	}

	@Test
	public void toStringTestCenarioFinalizadoNaoOcorreu() {
		this.cenario1.setEstado(Estado.FINALIZADO_N_OCORREU);
		assertEquals(this.cenario1.toString(),
				"O Brasil vai ganhar a copa! - Finalizado (n ocorreu)");
	}

	@Test
	public void cadastraApostaSemSeguroTest() {
		assertTrue(this.cenario1.totalDeApostas(1) == 2);
	}
	
	@Test
	public void cadastraApostaAsseguradaValor() {
		assertTrue(this.cenario2.totalDeApostas(1) == 1);
	}
	
	@Test
	public void cadastraApostaAsseguradaTaxa() {
		assertTrue(this.cenario3.totalDeApostas(1) == 1);
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
		assertTrue(this.cenario1.somaApostasPerdedoras() == 1500);
	}
	
	@Test
	public void valorApostasPerdedorasTest2() {
		this.cenario1.setEstado(Estado.FINALIZADO_OCORREU);
		assertTrue(this.cenario1.somaApostasPerdedoras() == 0);
	}
	
	@Test
	public void valorCaixaCenarioTest() {
		this.cenario1.setEstado(Estado.FINALIZADO_N_OCORREU);
		assertTrue(this.cenario1.getCaixaCenario(0.01) == 15);
	}
	
	@Test
	public void valorRateioTest() {
		this.cenario1.setEstado(Estado.FINALIZADO_N_OCORREU);
		assertTrue(this.cenario1.valorRateio(0.01) == 1485);
	}
	
}

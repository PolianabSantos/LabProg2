package controllers;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ControleTest {

	private Controle controle1;
	
	@Before
	public void criarControle() {
		controle1 = new Controle(1000, 0.1);
		controle1.cadastraCenario("Sistema de Apostas de Alisson");
		controle1.cadastrarAposta(1, "Alisson Farias", 10000, "N VAI ACONTECER");
		controle1.cadastrarAposta(1, "Thalyta Barbosa", 15000, "N VAI ACONTECER");
		controle1.cadastrarAposta(1, "Almir Crispiniano", 12525, "VAI ACONTECER");
		controle1.cadastrarAposta(1, "Luana Barbosa", 15252, "VAI ACONTECER");
		controle1.cadastrarAposta(1, "Carolinny Nascimento", 21521, "VAI ACONTECER");
		
	}
	
	@Test
	public void getCaixaTest() {
		assertTrue(this.controle1.getCaixa() == 1000);
	}
	
	@Test
	public void getTaxaTest() {
		assertTrue(this.controle1.getTaxa() == 0.1);
	}
	
	@Test
	public void testCadastrarCenario() {
		assertTrue(controle1.getQuantidadeCenarios() == 1);
		assertFalse(controle1.getQuantidadeCenarios() == 0);
	}
	
	@Test
	public void testCadastrarCenarioBonus() {
		controle1.cadastraCenario("Sistema de Apostas de Thalyta", 10);
		assertTrue(controle1.getQuantidadeCenarios() == 2);
	}
	
	@Test
	public void testExibirCenario() {
		assertEquals(controle1.exibeCenario(1), "1 - Sistema de Apostas de Alisson - Nao finalizado");
	}
	
	@Test
	public void testExibirCenarioBonus() {
		controle1.cadastraCenario("Sistema de Apostas de Thalyta", 10);
		assertEquals(controle1.exibeCenario(2), "2 - Sistema de Apostas de Thalyta - Nao finalizado - R$ 0,10");
	}
	
	@Test
	public void testListarCenarios() {
		controle1.cadastraCenario("Sistema de Apostas de Thalyta", 10);
		String listagem = "";
		listagem += "Sistema de Apostas de Alisson - Nao finalizado" + System.lineSeparator();
		listagem += "Sistema de Apostas de Thalyta - Nao finalizado - R$ 0,10" + System.lineSeparator();
		assertEquals(controle1.listarCenariosCadastrados(), listagem);
	}
	
	/**
	 * Testando exceções:
	 */
	
	@Test(expected = IllegalArgumentException.class)
	public void testUsandoCenarioZero() {
		controle1.cadastrarAposta(0, "Alisson Farias", 10000, "N VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testUsandoCenarioNegativo() {
		controle1.cadastrarAposta(-1, "Alisson Farias", 10000, "VAI ACONTECER");
	}
	
	
}

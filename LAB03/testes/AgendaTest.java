import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Classe criada para testar os métodos utilizados na classe 'Agenda'
 * @author Walisson Farias - 117210716
 *
 */

public class AgendaTest {
	
	private Agenda agenda;
	private Agenda agendax;
	private Agenda agenday;
	
	@Before
	public void setUp() {
		agenda = new Agenda();
		agendax = new Agenda(); 
		agenday = new Agenda();
	}
	
	@Test
	public void testaVerificaPosicao0() {
		assertFalse(agenda.verificaPosicao(0));
	}
	
	@Test
	public void testaVerificaPosicao1() {
		assertTrue(agenda.verificaPosicao(1));
	}
	
	@Test
	public void testaVerificaPosicao100() {
		assertTrue(agenda.verificaPosicao(100));
	}
	
	@Test
	public void testaVerificaPosicao101() {
		assertFalse(agenda.verificaPosicao(101));
	}
	
	@Test
	public void testaVerificaContatoExistente() {
		agenda.cadastrarContato("Walisson", "Farias", "(83)9988-9211", 1);
		assertTrue(agenda.verificaContato(1));
	}
	
	@Test
	public void testaVerificaContatoNaoExistente() {
		assertFalse(agenda.verificaContato(50));
	}
	
	@Test
	public void testaCadastroContatoValido() {
		assertTrue(agenda.cadastrarContato("Walisson", "Farias", "(83)9988-9211", 1));
		assertTrue(agenda.cadastrarContato("Walisson", "Farias", "(83)9988-9211", 100));
	}
	
	@Test
	public void testaCadastroContatoInvalido() {
		assertFalse(agenda.cadastrarContato("Walisson", "Farias", "(83)9988-9211", 0));
		assertFalse(agenda.cadastrarContato("Walisson", "Farias", "(83)9988-9211", 101));
	}
	
	@Test
	public void testaExibirContato1() {
		agenda.cadastrarContato("Walisson", "Farias", "(83)9988-9211", 1);
		assertEquals(agenda.exibirContato(1), "Walisson Farias - (83)9988-9211");
	}
	
	@Test
	public void testaExibirContato100() {
		agenda.cadastrarContato("Thalyta", "Barbosa", "(83)9821-3398", 100);
		assertEquals(agenda.exibirContato(100), "Thalyta Barbosa - (83)9821-3398");
	}
	
	@Test
	public void testaListarContatosCom0Contatos() {
		assertEquals(agenda.listarContatos(), "");
	}
	
	@Test
	public void testaListarContatosCom1Contato() {
		agenda.cadastrarContato("Walisson", "Farias", "(83)9988-9211", 1);
		assertEquals(agenda.listarContatos(), "1 - Walisson Farias" + System.lineSeparator());
	}
	
	@Test
	public void testaListarContatosCom2Contatos() {
		agenda.cadastrarContato("Walisson", "Farias", "(83)9988-9211", 1);
		agenda.cadastrarContato("Thalyta", "Barbosa", "(83)9821-3398", 2);
		assertEquals(agenda.listarContatos(), "1 - Walisson Farias" + System.lineSeparator() + "2 - Thalyta Barbosa" + System.lineSeparator());
	}
	
	@Test
	public void testaIgualdadeEntreAgendas() {
		agendax.cadastrarContato("Paulo", "Torres", "(83)00000-0000", 1);
		agenday.cadastrarContato("Paulo", "Torres", "(83)00000-0000", 1);
		assertTrue(agendax.equals(agenday));
	}
	
	@Test
	public void testaAgendasDiferentes () {
		agendax.cadastrarContato("Paulo", "Torres", "(83)00000-0000", 1);
		agenday.cadastrarContato("Ricardo", "Pereira", "(83)11111-1111", 2);
		assertFalse(agendax.equals(agenday));
	}
}
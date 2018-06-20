import static org.junit.Assert.*;
import org.junit.Test;
import enums.Estado;

public class CenarioTest {

	private Cenario cenario1;
	private Cenario cenario2;
	private Cenario cenario3;
	
	@Test
	public void ConstructorTest() {
		assertTrue(this.cenario1 == null);
		cenario1 = new Cenario("O Brasil vai ganhar a Copa!", 1);
		cenario1.cadastraAposta("Alisson Farias", 1, "VAI ACONTECER");
		assertFalse(this.cenario1 == null);
	}
	
	@Test
	public void getDescricaoTest() {
		cenario2 = new Cenario("Os alunos de computação venceram a competição", 2);
		assertTrue(this.cenario2.getDescricao().equals("Os alunos de computação venceram a competição"));
		assertFalse(this.cenario2.getDescricao().equals("Os alunos de computação não venceram a competição"));
	}
	
	@Test
	public void getEstadoNaoFinalizadoTest() {
		cenario1 = new Cenario("O Brasil vai ganhar a copa!", 2);;
		assertEquals(this.cenario1.getEstado(), Estado.NAO_FINALIZADO);
	}
	
	@Test
	public void getEstadoFinalizadoOcorreuTest() {
		cenario1 = new Cenario("O Brasil vai ganhar a copa!", 2);
		this.cenario1.setEstado(Estado.FINALIZADO_OCORREU);
		assertEquals(this.cenario1.getEstado(), Estado.FINALIZADO_OCORREU);
	}
	
	@Test
	public void getEstadoFinalizadoNaoOcorreuTest() {
		cenario2 = new Cenario("O Brasil vai ganhar a copa!", 2);
		this.cenario2.setEstado(Estado.FINALIZADO_N_OCORREU);
		assertEquals(this.cenario2.getEstado(), Estado.FINALIZADO_N_OCORREU);
	}
	
	@Test
	public void setEstadoFinalizadoNaoOcorreuTest() {
		cenario1 = new Cenario("Alisson ganhou a competição de Python", 1);
		this.cenario1.setEstado(Estado.FINALIZADO_N_OCORREU);
		assertTrue(this.cenario1.getEstado().equals(Estado.FINALIZADO_N_OCORREU));
	}
	

}

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe criada para testar os métodos utilizados na classe 'Controle'
 * @author Walisson Farias - 117210716
 */

public class ControleTest {

	private Controle controle;
	
	@Before
	public void iniciandoControle() {
		controle = new Controle();
	}
	
	@Test
	public void testConstrutor() {
		assertFalse(controle == null);
	}
	
	@Test
	public void testVerificaMatriculaNegativa() {
		assertFalse(controle.verificaMatriculaValida("-1"));
	}
	
	@Test
	public void testVerificaMatriculaPositiva() {
		assertTrue(controle.verificaMatriculaValida("1"));
	}

	@Test
	public void testVerificaNaoExistenciaAluno() {
		assertFalse(controle.verificaExistenciaAluno("1"));
	}
	
	/**
	 * Método que testa o cadastro de um aluno e depois verifica se o mesmo existe.
	 */
	
	@Test
	public void testVerificaExistenciaAluno() {
		controle.cadastraAluno("1", new Aluno("1", "Alisson Farias", "Computação"));
		assertTrue(controle.verificaExistenciaAluno("1"));
	}
	
	@Test
	public void testVerificaNaoExistenciaGrupo() {
		assertFalse(controle.verificaExistenciaGrupo("Testes"));
	}
	
	/**
	 * Método que testa o cadastro de um grupo e depois verifica se o mesmo existe.
	 */
	
	@Test
	public void testVerificaExistenciaGrupo() {
		controle.cadastraGrupo("testes", new Grupo("Testes"));
		assertTrue(controle.verificaExistenciaGrupo("testes"));
	}
	
	@Test
	public void testConsultaAlunoNaoCadastrado() {
		assertEquals(null, controle.consultarAluno("1"));
	}
	
	@Test
	public void testConsultaAlunoCadastrado() {
		assertEquals(null, controle.consultarAluno("1"));
	}
	
}

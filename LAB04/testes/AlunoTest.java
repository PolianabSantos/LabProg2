import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe criada para testar os métodos utilizados na classe 'Aluno'
 * @author Walisson Farias - 117210716
 */

public class AlunoTest {
	
	private Aluno alunoteste;
	private Aluno alunoteste2;
	private Aluno alunoteste3;
	
	@Before
	public void setUp() {
		alunoteste = new Aluno("1", "Alisson Farias", "Computação");
		alunoteste2 = new Aluno("1", "Thalyta Barbosa", "Computação");
		alunoteste3 = new Aluno("2", "Luana Barbosa", "Computação");
	}

	@Test(expected=NullPointerException.class)
	public void testeMatriculaNula() {
		new Aluno(null,"Alisson Farias","Computação");
	}
	
	@Test(expected=NullPointerException.class)
	public void testeNomeNulo() {
		new Aluno("1", null, "Computação");
	}
	
	@Test(expected=NullPointerException.class)
	public void testeCursoNulo() {
		new Aluno("1", "Alisson Farias", null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testeMatriculaVazia() {
		new Aluno("", "Alisson Farias", "Computação");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testeNomeVazio() {
		new Aluno("1", "", "Computação");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testeCursoVazio() {
		new Aluno("1", "Alisson Farias", "");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testeMatriculaComEspacos() {
		new Aluno("     ", "Alisson Farias", "Computação");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testeNomeComEspacos() {
		new Aluno("1", "     ", "Computação");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testeCursoComEspacos() {
		new Aluno("1", "Alisson Farias", "     ");
	}
	
	@Test
	public void testeMatricula() {
		assertEquals(alunoteste.getMatricula(), "1");
	}
	
	@Test
	public void testeNome() {
		assertEquals(alunoteste.getNome(), "Alisson Farias");
	}
	
	@Test
	public void testeDoisAlunosIguais() {
		assertTrue(alunoteste.equals(alunoteste2));
	}
	
	@Test
	public void testeDoisAlunosDiferentes() {
		assertFalse(alunoteste.equals(alunoteste3));
	}
	

}

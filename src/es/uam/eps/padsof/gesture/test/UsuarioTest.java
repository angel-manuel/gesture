package es.uam.eps.padsof.gesture.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.uam.eps.padsof.gesture.Usuario;

/**
 * Test de la clase Usuario
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class UsuarioTest {
	private Usuario usuario;
	
	@Before
	public void setUp() throws Exception {
		usuario = new Usuario("carlos", "qwerty123");
	}

	@Test
	public void test_getNombre() {
		assertEquals(usuario.getNombre(), "carlos");
	}
	
	@Test
	public void test_isGerente() {
		assertFalse(usuario.isGerente());
		
		assertEquals(Usuario.NOMBRE_GERENTE, "gerente");
		Usuario gerente = new Usuario(Usuario.NOMBRE_GERENTE, "roottoor");
		assertTrue(gerente.isGerente());
	}

	@Test
	public void test_contraseñaCorrecta() {
		assertTrue(usuario.comprobarContraseña("qwerty123"));
	}
	
	@Test
	public void test_contraseñaIncorrecta() {
		assertFalse(usuario.comprobarContraseña("asdfgh666"));
	}
}

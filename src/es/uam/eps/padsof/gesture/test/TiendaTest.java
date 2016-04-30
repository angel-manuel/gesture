package es.uam.eps.padsof.gesture.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.Usuario;
import es.uam.eps.padsof.gesture.exception.AutorizacionIncorrectaException;

/**
 * Test de la clase Tienda
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class TiendaTest {
	Tienda tienda;
	
	@Before
	public void setUp() throws Exception {
		tienda = new Tienda();
	}

	@Test
	public void logeo() {
		Usuario u1 = new Usuario("Juan", "abcd");
		Usuario u2 = new Usuario("Lola", "efgh");
		
		tienda.log("gerente", "roottoor");
		
		try {
			assertTrue(tienda.añadirUsuario(u1));
			assertTrue(tienda.añadirUsuario(u2));
		} catch (AutorizacionIncorrectaException e) {
			fail();
		}
		
		assertTrue(tienda.log("Juan", "abcd"));
		assertEquals(tienda.getUsuarioLogeado(), u1);
		
		assertFalse(tienda.log("Lola", "abcd"));
		assertFalse(tienda.log("Pepe", "abcd"));
	}
	
	@Test
	public void usuarioDuplicados() {
		Usuario u1 = new Usuario("Juan", "abcd");
		Usuario u2 = new Usuario("Juan", "efgh");
		
		tienda.log("gerente", "roottoor");
		
		try {
			assertTrue(tienda.añadirUsuario(u1));
			assertFalse(tienda.añadirUsuario(u2));
		} catch (AutorizacionIncorrectaException e) {
			fail();
		}
	}

}

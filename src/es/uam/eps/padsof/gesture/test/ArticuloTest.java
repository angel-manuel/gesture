package es.uam.eps.padsof.gesture.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.uam.eps.padsof.gesture.Menudencia;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class ArticuloTest {
	Menudencia menudencia;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		menudencia = new Menudencia("menudencia", 200.0, "1990", new Date(), 100.0, 10);
	}
	
	@Test
	public void getDescripcion() {
		assertEquals(menudencia.getDescripcion(), "menudencia");
	}

	@Test
	public void getPrecioBase() {
		assertTrue(menudencia.getPrecioBase() == 200.0);
	}

	@Test
	public void getAño() {
		assertEquals(menudencia.getAño(), "1990");
	}

	@Test
	public void getCosteAdquisicion() {
		assertTrue(menudencia.getCosteAdquisicion() == 100.0);
	}
}

package es.uam.eps.padsof.gesture.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.uam.eps.padsof.gesture.ArticuloVoluminoso;
import es.uam.eps.padsof.gesture.TipoDeArticulo;

public class ArticuloVoluminosoTest {
	ArticuloVoluminoso voluminoso;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		voluminoso = new ArticuloVoluminoso("roca", 200.0, "1990", new Date(), 100.0,
				28.0, 1.0, 1.0, 1.0);
	}

	@Test
	public void getTipo() {
		assertEquals(voluminoso.getTipo(), TipoDeArticulo.Voluminoso);
	}
	
	@Test
	public void calcularGastosEnvio() {
		assertTrue(voluminoso.calcularGastosEnvio() == 26.0);
		
		ArticuloVoluminoso grande = new ArticuloVoluminoso("roca", 200.0, "1990", new Date(), 100.0,
				28.0, 5.0, 1.0, 1.0);
		
		assertTrue(grande.calcularGastosEnvio() == 50.0);
	}

}

package es.uam.eps.padsof.gesture.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.ContratoPreferente;
import es.uam.eps.padsof.gesture.ObraDeArte;
import es.uam.eps.padsof.gesture.PoliticaNotificacion;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.TipoDeObra;
import es.uam.eps.padsof.gesture.exception.NoAñadidoATiendaException;
import es.uam.eps.padsof.gesture.exception.PujaRechazadaException;
import es.uam.eps.padsof.gesture.exception.SubastaNoCancelableException;
import es.uam.eps.padsof.gesture.subasta.Puja;
import es.uam.eps.padsof.gesture.subasta.ResultadoSubasta;
import es.uam.eps.padsof.gesture.subasta.Subasta;

/**
 * Test de la clase Subasta
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class SubastaTest {
	Tienda tienda;
	Date enDosDias;
	ObraDeArte cosa;
	Subasta subasta;
	Cliente cliente;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tienda = new Tienda();
		enDosDias = new Date(new Date().getTime() + 2*24*60*60*1000);
		cosa = new ObraDeArte("Cosa", 1000.0, "7xx", new Date(), 700.0, "Desconocido", TipoDeObra.Especial, false);
		cliente = new Cliente("Lola", "Canto", "loca@gmail.com", "aaa", "333", PoliticaNotificacion.Siempre);
		
		tienda.log("gerente", "roottoor");
		
		tienda.getInventario().añadirArticulo(cosa);
		
		subasta = new Subasta(cosa, enDosDias, 20.0);
		
		tienda.añadirSubasta(subasta);
		
		tienda.añadirCliente(cliente);
		
		cliente.otorgarContrato(new ContratoPreferente());
	}

	@Test
	public void cancelar() {
		try {
			subasta.cancelar();
		} catch (FailedInternetConnectionException
				| SubastaNoCancelableException
				| NoAñadidoATiendaException e) {
			e.printStackTrace();
			fail();
		}
		
		assertTrue(tienda.getSubastas().isEmpty());
	}

	@Test
	public void pujaDeClienteNoParticipando() {
		try {
			subasta.pujar(new Puja(null, 25.0));
		} catch (PujaRechazadaException e) {
			return;
		}
		
		fail();
	}
	
	@Test
	public void precioDeSalida() {
		try {
			subasta.pujar(new Puja(cliente, 19.0));
		} catch (PujaRechazadaException e) {
			return;
		}
		
		fail();
	}
	
	@Test
	public void pujaDemasiadoCercana() {
		try {
			subasta.pujar(new Puja(cliente, 25.00));
			subasta.pujar(new Puja(cliente, 25.01));
		} catch (PujaRechazadaException e) {
			return;
		}
		
		fail();
	}
	
	@Test
	public void finalizar() {
		try {
			subasta.pujar(new Puja(cliente, 25000.00));
			
			ResultadoSubasta resultado = subasta.finalizar();
			
			assertEquals(resultado.getGanador(), cliente);
			assertEquals(resultado.getObjetoSubasta(), cosa);
			assertTrue(resultado.getPrecioFinal() == 25000.00);
		} catch (PujaRechazadaException |
				FailedInternetConnectionException |
				NoAñadidoATiendaException e) {
			fail();
		}
	}
}

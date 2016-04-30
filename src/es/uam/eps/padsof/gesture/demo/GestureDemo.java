package es.uam.eps.padsof.gesture.demo;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import es.uam.eps.padsof.gesture.Articulo;
import es.uam.eps.padsof.gesture.ArticuloVoluminoso;
import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.ContratoEstandar;
import es.uam.eps.padsof.gesture.ContratoPreferente;
import es.uam.eps.padsof.gesture.Inventario;
import es.uam.eps.padsof.gesture.Menudencia;
import es.uam.eps.padsof.gesture.ObraDeArte;
import es.uam.eps.padsof.gesture.ObraDeArteDestino;
import es.uam.eps.padsof.gesture.PoliticaNotificacion;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.TipoDeArticulo;
import es.uam.eps.padsof.gesture.TipoDeObra;
import es.uam.eps.padsof.gesture.Usuario;
import es.uam.eps.padsof.gesture.balance.Venta;
import es.uam.eps.padsof.gesture.balance.VentaContrato;
import es.uam.eps.padsof.gesture.exception.AutorizacionIncorrectaException;
import es.uam.eps.padsof.gesture.exception.NoAñadidoATiendaException;
import es.uam.eps.padsof.gesture.exception.NoEstaEnInventarioException;
import es.uam.eps.padsof.gesture.exception.ParticipacionDuplicadaException;
import es.uam.eps.padsof.gesture.exception.ParticipacionSinContratoException;
import es.uam.eps.padsof.gesture.exception.PujaRechazadaException;
import es.uam.eps.padsof.gesture.exception.SubastaNoCancelableException;
import es.uam.eps.padsof.gesture.subasta.ParticipacionSubasta;
import es.uam.eps.padsof.gesture.subasta.Puja;
import es.uam.eps.padsof.gesture.subasta.Subasta;

/**
 * Demostrador general de la aplicación
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class GestureDemo {

	/**
     * Punto de entrada del demostrador
     *
	 * @param args Ignorado
	 */
	public static void main(String[] args) {
		try {
		// Cargar el estado de disco
		Tienda tienda = Tienda.cargarDeArchivo("demo.gesture");
		
		// Gerente
		System.out.println("Acciones como gerente");
		
		// Iniciar sesión y autenticarse frente a la aplicación
		if (tienda.log("gerente", "roottoor")) {
			System.out.println("Logeado como " + tienda.getUsuarioLogeado().getNombre());
		} else {
			return;
		}
		
		// Registrar empleado/añadir usuario
		
		tienda.añadirUsuario(new Usuario("normal", "qwerty"));
		
		// Acceder al inventario
		Inventario inventario = tienda.getInventario();
	

		// Añadir artículos al inventario manualmente
		if(inventario.size() < 5) {
			System.out.println("Añadiendo artículos a inventario manualmente");
			
			inventario.añadirArticulo(new Menudencia("Colgante", 5.0, "2001", new Date(), 2.0, 10));
			inventario.añadirArticulo(new ArticuloVoluminoso("Roca color queso", 250.0, "1996", new Date(), 76.0,
					100.0, 1.0, 2.0, 1.0));
			inventario.añadirArticulo(
					new ArticuloVoluminoso("Piedra gigante", 1000.0, "773", new Date(), 10.0,
							3000.0, 2.0, 1.0, 1.2));
			inventario.añadirArticulo(new ObraDeArte("Casa roja", 450.0, "1956", new Date(), 300.0,
					"Tio raro", TipoDeObra.Pintura, true));
			inventario.añadirArticulo(new ObraDeArte("Torre de queso", 4500.0, "1976", new Date(), 30.0,
					"Andy Warhol", TipoDeObra.Escultura, true));
		}
		
		// Añadir artículos desde archivo
		try {
			inventario.cargarArticulosDeArchivo("Articulos.txt");
		} catch (IOException | ParseException e1) {
			e1.printStackTrace();
			return;
		}
		
		// Acceder a articulos
		Articulo botella = inventario.filtrarPorDescripcion("BOTELLA").first();
		Articulo altar = inventario.filtrarPorDescripcion("Altar antiguo").first();
		ObraDeArte mater = (ObraDeArte)inventario.filtrarPorDescripcion("Mater").first();
		
		// Marcar obra para subasta(empieza sin poderse vender ni subastar)
		mater.setDestino(ObraDeArteDestino.Subasta);
		
		try {
			Cliente cliente = new Cliente("Mario", "Martin", "mario@aaa.com", "Calle Falsa 123", "22666", PoliticaNotificacion.Siempre);
			tienda.añadirCliente(cliente);
		} catch (InvalidEmailAddressException e) {
			e.printStackTrace();
			return;
		}
		
		// Iniciar subastas
		Subasta subasta;
		try {
			Date enDosDias = new Date(new Date().getTime() + 2*24*60*60*1000);
			
			subasta = new Subasta(mater, enDosDias, 20.0);
			
			tienda.añadirSubasta(subasta);
			
			subasta.cancelar();
			
			subasta = new Subasta(mater, enDosDias, 10.0);
			
			tienda.añadirSubasta(subasta);
		} catch (FailedInternetConnectionException
				| NoAñadidoATiendaException 
				| NoEstaEnInventarioException
				| SubastaNoCancelableException
				| AutorizacionIncorrectaException e) {
			e.printStackTrace();
			return;
		}
		
		// Empleado
		System.out.println("Acciones como empleado");
		
		if (tienda.log("normal", "qwerty")) {
			System.out.println("Logeado como " + tienda.getUsuarioLogeado().getNombre());
		} else {
			return;
		}
		
		// Mostrar el inventario
		System.out.println("Inventario:");
		System.out.println(inventario);
		
		// Mostrar el inventario por tipo
		System.out.println("Obras de arte:");
		System.out.println(inventario.filtrarPorTipo(TipoDeArticulo.ObraDeArte));
		
		// Mostrar el inventario por tipo y descripción
		System.out.println("Obras de arte de queso:");
		System.out.println(inventario.filtrarPorTipo(TipoDeArticulo.ObraDeArte).filtrarPorDescripcion("queso"));
		
		// Registrar clientes
		try {
			Cliente cliente1 = new Cliente("Jorge", "Martin", "jorge@aaa.com", "Calle Falsa 123", "22666", PoliticaNotificacion.AlParticipar);
			tienda.añadirCliente(cliente1);
			Cliente cliente2 = new Cliente("Pepe", "Sevilla", "pepe@aaa.com", "Calle Falsa 123", "22666", PoliticaNotificacion.AlParticipar);
			tienda.añadirCliente(cliente2);
			Cliente cliente3 = new Cliente("Ramón", "Peras", "email INVALIDO", "Calle Falsa 123", "22666", PoliticaNotificacion.Nunca);
			tienda.añadirCliente(cliente3);
		} catch (InvalidEmailAddressException e) {
			assert(e.getEmailAddress() == "email INVALIDO");
			System.out.println("EXCEPCION ESPERADA");
			e.printStackTrace();
		}
		
		Iterator<Cliente> it = tienda.getClientes().iterator();
		Cliente cliente1 = it.next(); // Primer cliente
		Cliente cliente2 = it.next(); // Segundo cliente
		
		// Otorgar contratos
		try {
			VentaContrato vc1 = cliente1.otorgarContrato(new ContratoEstandar());
			System.out.println("Contrato " + cliente1 + ":\n" + vc1.getPrecio());
			VentaContrato vc2 = cliente2.otorgarContrato(new ContratoPreferente());
			System.out.println("Contrato " + cliente2 + ":\n" + vc2.getPrecio());
		} catch (NoAñadidoATiendaException e) {
			e.printStackTrace();
			return;
		}
		
		// Registrar ventas
		try {
			Venta v1 = cliente1.comprar(altar);
			System.out.println(v1);
			Venta v2 = cliente1.comprar(botella);
			System.out.println(v2);
			Venta v3 = cliente1.comprar(botella); // Falla al intentar vender por un artículo vendido
			System.out.println(v3);
		} catch (NoAñadidoATiendaException 
				| NoEstaEnInventarioException e) {
			e.printStackTrace();
			System.out.println();
		}
		
		try {
			// Apuntar clientes a subastas
			ParticipacionSubasta p1 = subasta.añadirParticipante(cliente1);
			System.out.println(cliente1 + " participando en subasta\n");
			System.out.println(p1.getPrecio());
			ParticipacionSubasta p2 = subasta.añadirParticipante(cliente2);
			System.out.println(cliente2 + " participando en subasta\n");
			System.out.println(p2.getPrecio());
			
			// Registrar pujas
			try {
				System.out.println(cliente1 + " puja por 600\n");
				subasta.pujar(new Puja(cliente1, 600.0));
				System.out.println();
			} catch (PujaRechazadaException e) {
				e.printStackTrace();
				return;
			}
			
			// Si volvemos a pujar por una cantidad insuficiente
			// salta una excepción
			try {
				System.out.println(cliente2 + " puja por 550\n");
				subasta.pujar(new Puja(cliente2, 550.0));
			} catch (PujaRechazadaException e) {
				System.out.println("EXCEPCION ESPERADA");
				e.printStackTrace();
			}
			
			// Al desubscribir al cliente ya no recibe notificaciones...
			System.out.println(cliente1 + " se desubscribe de las notificaciones\n");
			subasta.desubscribir(cliente1);
			
			// ...de nuevas pujas
			try {
				System.out.println(cliente2 + " puja por 700\n");
				subasta.pujar(new Puja(cliente2, 700.0));
				System.out.println();
			} catch (PujaRechazadaException e) {
				e.printStackTrace();
				return;
			}
			
			System.out.println(cliente1 + " se vuelve a subscribir a las notificaciones\n");
			subasta.subscribir(cliente1);
			
			// Finalizamos subasta antes de tiempo(solo como demostración)
			System.out.println("Se finaliza la subasta\n");
			subasta.finalizar();
		} catch (ParticipacionDuplicadaException
				| ParticipacionSinContratoException
				| NoAñadidoATiendaException
				| FailedInternetConnectionException e) {
			e.printStackTrace();
			return;
		}
		
		System.out.println("\n\nBALANCE:\n" + tienda.getBalance());
		
		
		if (tienda.log("gerente", "roottoor")) {
			System.out.println("Logeado como " + tienda.getUsuarioLogeado().getNombre());
		} else {
			return;
		}
		
		// Cerramos tienda como gerente
		System.out.println("Cerrando tienda...");
		tienda.cerrarTienda();
		
		// Guardar en disco el estado
		Tienda.guardarEnArchivo(tienda, "demo.gesture");
		} catch (AutorizacionIncorrectaException e) {
			e.printStackTrace();
		}
	}

}

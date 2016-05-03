package es.uam.eps.padsof.gesture.gui.view;

import java.awt.Dimension;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import es.uam.eps.padsof.gesture.Articulo;
import es.uam.eps.padsof.gesture.ArticuloVoluminoso;
import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.ContratoPreferente;
import es.uam.eps.padsof.gesture.Lote;
import es.uam.eps.padsof.gesture.Menudencia;
import es.uam.eps.padsof.gesture.ObraDeArte;
import es.uam.eps.padsof.gesture.ObraDeArteDestino;
import es.uam.eps.padsof.gesture.PoliticaNotificacion;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.TipoDeObra;
import es.uam.eps.padsof.gesture.Usuario;
import es.uam.eps.padsof.gesture.exception.AutorizacionIncorrectaException;
import es.uam.eps.padsof.gesture.exception.NoAñadidoATiendaException;
import es.uam.eps.padsof.gesture.exception.NoEstaEnInventarioException;
import es.uam.eps.padsof.gesture.gui.controller.LoginController;
import es.uam.eps.padsof.gesture.gui.controller.LoteController;
import es.uam.eps.padsof.gesture.gui.controller.RegistrarUsuarioController;
import es.uam.eps.padsof.gesture.gui.controller.SubastaController;
import es.uam.eps.padsof.gesture.gui.controller.UsuarioController;
import es.uam.eps.padsof.gesture.gui.controller.VoidController;
import es.uam.eps.padsof.gesture.subasta.Subasta;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class ViewsTester {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Precio precio = new Precio();
		
		precio.añadirConcepto(new ConceptoPrecio("Concepto A", 100.0));
		precio.añadirConcepto(new ConceptoPrecio("Concepto B", -20.0));
		
		JFrame precioFrame = new JFrame();
		precioFrame.setSize(600, 400);
		precioFrame.add(new PrecioView(precio));
		precioFrame.setVisible(true);*/
		
		Tienda tienda = new Tienda();
		tienda.log("gerente", "roottoor");
		try {
			tienda.añadirUsuario(new Usuario("Borja", "abcdef123"));
			
			Cliente cliPerez = new Cliente("Cli", "Perez", "cli@eee.com", "", "", PoliticaNotificacion.Siempre);
			tienda.añadirCliente(cliPerez);
			cliPerez.otorgarContrato(new ContratoPreferente());
		} catch (AutorizacionIncorrectaException | InvalidEmailAddressException | NoAñadidoATiendaException e) {
			e.printStackTrace();
		}
		
		ObraDeArte obraSub = new ObraDeArte("Rojo y blanco", 240, "GGG", new Date(), 40, "John", TipoDeObra.Pintura, true);
		obraSub.setDestino(ObraDeArteDestino.Subasta);
		
		tienda.getInventario().añadirArticulo(obraSub);
		
		tienda.getInventario().añadirArticulo(new Menudencia("Cosa", 50, "1994", new Date(), 0, 0));
		tienda.getInventario().añadirArticulo(new Menudencia("Llave", 30, "1945", new Date(), 30, 03));
		tienda.getInventario().añadirArticulo(new Menudencia("Reloj", 230, "1955", new Date(), 30, 03));
		tienda.getInventario().añadirArticulo(new ArticuloVoluminoso("Piedra", 3230, "985", new Date(), 30, 500, 5, 5, 5));
		
		for (int i = 0; i < 10; ++i) {
			tienda.getInventario().añadirArticulo(new Menudencia("Basura", 1, "Desconocido", new Date(), 30, 03));
		}
		
		try {
			tienda.añadirSubasta(new Subasta(obraSub, new Date(), 10));
		} catch (FailedInternetConnectionException
				| AutorizacionIncorrectaException
				| NoAñadidoATiendaException
				| NoEstaEnInventarioException e) {
			e.printStackTrace();
			return;
		}
		
		tienda.logout();
		
		tienda.log("Borja", "abcdef123");
		
		MainFrame mainFrame = new MainFrame("Gesture");
		
		//mainFrame.setControladorActual(new LoteController(tienda, new Lote()));
		//mainFrame.setControladorActual(new LoginController(tienda));
		mainFrame.setControladorActual(new UsuarioController(tienda));
		//mainFrame.setControladorActual(new SubastaController(tienda));
		mainFrame.setVisible(true);

		/*LoginView view = new LoginView();
		LoginController ctrl = new LoginController(tienda, view);
		
		mainFrame.setControladorActual(ctrl);
		
		mainFrame.setVisible(true);
		
		JFrame loginFrame = new JFrame("Login de Usuario");
		loginFrame.setSize(320, 150);
		loginFrame.add(ctrl.getView());
		loginFrame.setVisible(true);*/
		
		// RegistrarClienteModel model = new RegistrarClienteModel();
		/*RegistrarClienteView view = new RegistrarClienteView();
		RegistrarClienteController ctrl = new RegistrarClienteController(new Tienda(), view);
		
		JFrame registrarClienteFrame = new JFrame("Registrar Cliente");
		registrarClienteFrame.setSize(600, 400);
		registrarClienteFrame.add(view);
		registrarClienteFrame.setVisible(true);*/
		
		/*SubastaModel model = new SubastaModel();
		SubastaView view = new SubastaView();
		
			
		JFrame SubastaFrame = new JFrame("Registrar Subasta");
		SubastaFrame.setSize(600, 400);
		SubastaFrame.add(view);
		SubastaFrame.setVisible(true);*/
		
		/*Tienda tienda = new Tienda();
		MainFrame mainFrame = new MainFrame();
		
		tienda.log("gerente", "roottoor");
		
		try {
			tienda.añadirUsuario(new Usuario("Borja", "abcdef123"));
		} catch (AutorizacionIncorrectaException e) {
			e.printStackTrace();
		}
		
		RegistrarUsuarioController ctrl = new RegistrarUsuarioController(tienda);
		
		mainFrame.setControladorActual(ctrl);
		
		mainFrame.setVisible(true);*/
		
		/*JFrame RegistrarUsuarioFrame = new JFrame("Registrar Usuario");
		RegistrarUsuarioFrame.setSize(320, 150);
		RegistrarUsuarioFrame.add(ctrl.getView());
		RegistrarUsuarioFrame.setVisible(true);*/
		
		/*Tienda tienda = new Tienda();
		
		tienda.getInventario().añadirArticulo(new Menudencia("Cosa", 50, "1994", new Date(), 0, 0));
		tienda.getInventario().añadirArticulo(new Menudencia("Llave", 30, "1945", new Date(), 30, 03));
		tienda.getInventario().añadirArticulo(new Menudencia("Reloj", 230, "1955", new Date(), 30, 03));
		tienda.getInventario().añadirArticulo(new ArticuloVoluminoso("Piedra", 3230, "985", new Date(), 30, 500, 5, 5, 5));
		
		RegistrarVentaView view = new RegistrarVentaView(tienda.getInventario());
				
		JFrame registrarVentaFrame = new JFrame("Registrar Venta");
		registrarVentaFrame.setSize(600, 400);
		registrarVentaFrame.add(view);
		registrarVentaFrame.setVisible(true);*/
	}

}

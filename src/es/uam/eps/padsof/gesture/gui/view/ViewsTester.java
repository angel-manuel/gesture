package es.uam.eps.padsof.gesture.gui.view;

import java.awt.Dimension;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import es.uam.eps.padsof.gesture.Articulo;
import es.uam.eps.padsof.gesture.ArticuloVoluminoso;
import es.uam.eps.padsof.gesture.Lote;
import es.uam.eps.padsof.gesture.Menudencia;
import es.uam.eps.padsof.gesture.ObraDeArte;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.TipoDeObra;
import es.uam.eps.padsof.gesture.Usuario;
import es.uam.eps.padsof.gesture.exception.AutorizacionIncorrectaException;
import es.uam.eps.padsof.gesture.gui.controller.LoginController;
import es.uam.eps.padsof.gesture.gui.controller.LoteController;
import es.uam.eps.padsof.gesture.gui.controller.RegistrarUsuarioController;
import es.uam.eps.padsof.gesture.gui.controller.SubastaController;
import es.uam.eps.padsof.gesture.gui.controller.VoidController;
import es.uam.eps.padsof.gesture.gui.model.RegistrarUsuarioModel;

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
		
		/*Tienda tienda = new Tienda();
		tienda.log("gerente", "roottoor");
		try {
			tienda.añadirUsuario(new Usuario("Borja", "abcdef123"));
		} catch (AutorizacionIncorrectaException e) {
			e.printStackTrace();
		}
		
		tienda.getInventario().añadirArticulo(new Menudencia("Cosa", 50, "1994", new Date(), 0, 0));
		tienda.getInventario().añadirArticulo(new Menudencia("Llave", 30, "1945", new Date(), 30, 03));
		tienda.getInventario().añadirArticulo(new Menudencia("Reloj", 230, "1955", new Date(), 30, 03));
		tienda.getInventario().añadirArticulo(new ArticuloVoluminoso("Piedra", 3230, "985", new Date(), 30, 500, 5, 5, 5));
		
		for (int i = 0; i < 10; ++i) {
			tienda.getInventario().añadirArticulo(new Menudencia("Basura", 1, "Desconocido", new Date(), 30, 03));
		}
		
		tienda.logout();
		
		MainFrame mainFrame = new MainFrame();*/
		
		//mainFrame.setControladorActual(new LoteController(tienda, new Lote()));
		//mainFrame.setControladorActual(new LoginController(tienda));
		//mainFrame.setControladorActual(new SubastaController(tienda));
		//mainFrame.setVisible(true);

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
		
		Tienda tienda = new Tienda();
		
		tienda.getInventario().añadirArticulo(new Menudencia("Cosa", 50, "1994", new Date(), 0, 0));
		tienda.getInventario().añadirArticulo(new Menudencia("Llave", 30, "1945", new Date(), 30, 03));
		tienda.getInventario().añadirArticulo(new Menudencia("Reloj", 230, "1955", new Date(), 30, 03));
		tienda.getInventario().añadirArticulo(new ArticuloVoluminoso("Piedra", 3230, "985", new Date(), 30, 500, 5, 5, 5));
		
		RegistrarVentaView view = new RegistrarVentaView(tienda.getInventario());
				
		JFrame registrarVentaFrame = new JFrame("Registrar Venta");
		registrarVentaFrame.setSize(600, 400);
		registrarVentaFrame.add(view);
		registrarVentaFrame.setVisible(true);
	}

}

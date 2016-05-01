package es.uam.eps.padsof.gesture.gui.view;

import javax.swing.JFrame;

import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.Usuario;
import es.uam.eps.padsof.gesture.exception.AutorizacionIncorrectaException;
import es.uam.eps.padsof.gesture.gui.controller.LoginController;

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
		
		//MainFrame mainFrame = new MainFrame();
		
		Tienda tienda = new Tienda();
		tienda.log("gerente", "roottoor");
		try {
			tienda.añadirUsuario(new Usuario("Borja", "abcdef123"));
		} catch (AutorizacionIncorrectaException e) {
			e.printStackTrace();
		}
		
		tienda.getInventario().añadirArticulo(new Menudencia("cosa", 0, "", new Date(), 0, 0));
		tienda.getInventario().añadirArticulo(new Menudencia("Llave", 30, "", new Date(), 30, 03));
		
		tienda.logout();
		
		JFrame invenFrame = new JFrame("Invent");
		invenFrame.setSize(700, 700);
		invenFrame.add(new ColeccionArticulosView(tienda.getInventario()));
		invenFrame.setVisible(true);

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
		
		SubastaModel model = new SubastaModel();
		SubastaView view = new SubastaView();
		
			
		JFrame SubastaFrame = new JFrame("Registrar Subasta");
		SubastaFrame.setSize(600, 400);
		SubastaFrame.add(view);
		SubastaFrame.setVisible(true);
	}

}

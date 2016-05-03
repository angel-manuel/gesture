package es.uam.eps.padsof.gesture;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.util.List;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.gesture.balance.Balance;
import es.uam.eps.padsof.gesture.exception.AutorizacionIncorrectaException;
import es.uam.eps.padsof.gesture.exception.NoAñadidoATiendaException;
import es.uam.eps.padsof.gesture.exception.NoEstaEnInventarioException;
import es.uam.eps.padsof.gesture.subasta.Subasta;

/**
 * Representa la tienda de antiguedades.
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class Tienda implements Serializable {
	private static final long serialVersionUID = 20160329L;
	
	private static final String CONTRASEÑA_GERENTE = "roottoor";
	
	private TreeSet<Usuario> usuarios = new TreeSet<>();
	private TreeSet<Cliente> clientes = new TreeSet<>();
	private ArrayList<Subasta> subastas = new ArrayList<>();
	private ArrayList<Lote> lotesReservados = new ArrayList<>();
	private Usuario usuarioLogeado = null;
	private Inventario inventario = new Inventario();
	private Balance balance = new Balance();
	
	/**
	 * Instancia una nueva tienda.
	 */
	public Tienda() {
		usuarios.add(new Usuario("gerente", CONTRASEÑA_GERENTE));
	}
	
	/**
	 * Guarda la tienda en disco.
	 *
	 * @param tienda Tienda
	 * @param filename Nombre de archivo donde guardar
	 */
	public static void guardarEnArchivo(Tienda tienda, String filename) {
		try {
			FileOutputStream fileOut = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(tienda);
			out.close();
			fileOut.close();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Carga una Tienda de archivo, si el archivo no existe una tienda nueva es creada.
	 *
	 * @param filename Nombre de archivo a usar
	 * @return La Tienda cargada
	 */
	public static Tienda cargarDeArchivo(String filename) {
		try {
			FileInputStream fileIn = new FileInputStream(filename);
        	ObjectInputStream in = new ObjectInputStream(fileIn);
        	Tienda tienda = (Tienda) in.readObject();
        	in.close();
        	fileIn.close();
        	
            return tienda;
		} catch(FileNotFoundException e) {
			Tienda nt = new Tienda();
			Tienda.guardarEnArchivo(nt, filename);
			return nt;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Getter de usuarioLogeado.
	 *
	 * @return el usuarioLogeado de Tienda
	 */
	public Usuario getUsuarioLogeado() {
		return usuarioLogeado;
	}

	/**
	 * Devuelve el inventario.
	 *
	 * @return el inventario de Tienda
	 */
	public Inventario getInventario() {
		return inventario;
	}

	/**
	 * Añade un usuario comprobando que no está duplicado.
	 *
	 * @param nuevoUsuario Usuario a añadir
	 * @return Si se ha añadido con éxito
	 * @throws AutorizacionIncorrectaException Si no se es gerente
	 */
	public boolean añadirUsuario(Usuario nuevoUsuario) throws AutorizacionIncorrectaException {
		if (usuarioLogeado == null || !usuarioLogeado.isGerente()) {
			throw new AutorizacionIncorrectaException();
		}
		
		return usuarios.add(nuevoUsuario);
	}
	
	/**
	 * Intenta logearse.
	 *
	 * @param nombre Nombre de usuario
	 * @param contraseña Contraseña de usuario
	 * @return Si el login se ha completado con éxito
	 */
	public boolean log(String nombre, String contraseña) {
		for(Usuario usuario: usuarios) {
			if(usuario.getNombre().contentEquals(nombre) && usuario.comprobarContraseña(contraseña)) {
				usuarioLogeado = usuario;
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Iterador de usuarios
	 *
	 * @return iterador
	 */
	public Iterator<Usuario> usuariosIter() {
		return usuarios.iterator();
	}
	
	/**
	 * Comprueba si se puede añadir un nuevo cliente
	 *
	 * @param nuevoCliente 
	 * @return true si se puede añadir cliente
	 * @return false en caso contrario
	 */
	public boolean añadirCliente(Cliente nuevoCliente) {
		nuevoCliente.setTienda(this);
		
		if (nuevoCliente.getPoliticaNotificacion() == PoliticaNotificacion.Siempre) {
			for (Subasta subasta: subastas) {
				subasta.subscribir(nuevoCliente);
			}
		}
		
		return clientes.add(nuevoCliente);
	}
	
	/**
	 * Deslogea al usuario actual.
	 */
	public void logout() {
		usuarioLogeado = null;
	}
	
	/**
	 * Añadir subasta.
	 *
	 * @param nuevaSubasta the nueva subasta
	 * @return true, if successful
	 * @throws FailedInternetConnectionException
	 * @throws AutorizacionIncorrectaException 
	 */
	public boolean añadirSubasta(Subasta nuevaSubasta) throws FailedInternetConnectionException, AutorizacionIncorrectaException {
		if (usuarioLogeado == null || !usuarioLogeado.isGerente()) {
			throw new AutorizacionIncorrectaException();
		}
		
		nuevaSubasta.setTienda(this);
		
		for (Cliente cliente: clientes) {
			if (cliente.getPoliticaNotificacion() == PoliticaNotificacion.Siempre) {
				nuevaSubasta.subscribir(cliente);
			}
		}
		
		nuevaSubasta.notificarInicio();
		
		return subastas.add(nuevaSubasta);
	}

	/**
	 * Getter de usuarios.
	 *
	 * @return usuarios de Tienda
	 */
	public List<Usuario> getUsuarios() {
		return usuarios.stream().collect(Collectors.toCollection(ArrayList::new));
	}

	/**
	 * Getter de clientes.
	 *
	 * @return clientes de Tienda
	 */
	public List<Cliente> getClientes() {
		return clientes.stream().collect(Collectors.toCollection(ArrayList::new));
	}

	/**
	 * Getter de subastas.
	 *
	 * @return subastas de Tienda
	 */
	public List<Subasta> getSubastas() {
		return subastas.stream().collect(Collectors.toCollection(ArrayList::new));
	}

	/**
	 * Getter de lotesReservados.
	 *
	 * @return lotesReservados de Tienda
	 */
	public List<Lote> getLotesReservados() {
		return lotesReservados.stream().collect(Collectors.toCollection(ArrayList::new));
	}
	
	/**
	 * Añadir lote.
	 *
	 * @param nuevoLote the nuevo lote
	 * @throws NoAñadidoATiendaException 
	 * @throws NoEstaEnInventarioException 
	 */
	public void añadirLote(Lote nuevoLote) throws NoAñadidoATiendaException, NoEstaEnInventarioException {
		nuevoLote.retirarDeInventario();
		
		lotesReservados.add(nuevoLote);
	}

	/**
	 * Getter de balance.
	 *
	 * @return balance de Tienda
	 */
	public Balance getBalance() {
		return balance;
	}
	
	
	/**
	 * Limpia la tienda de subastas y contratos finalizados
	 * 
	 * @throws AutorizacionIncorrectaException Si no se es gerente
	 */
	public void cerrarTienda() throws AutorizacionIncorrectaException {
		if (usuarioLogeado == null || !usuarioLogeado.isGerente()) {
			throw new AutorizacionIncorrectaException();
		}
		
		for (Subasta subasta: subastas) {
			if (subasta.isCiega()) { // Es el último día y estamos cerrando, mañana no hay subasta
				try {
					subasta.finalizar();
				} catch (FailedInternetConnectionException |
						NoAñadidoATiendaException e) {
					throw new RuntimeException(e);
				}
			}
		}
		
		for (Cliente cliente: clientes) {
			Contrato contrato = cliente.getContrato();
			
			if (contrato != null && !contrato.isValido()) {
				cliente.invalidarContrato();
			}
		}
	}
}

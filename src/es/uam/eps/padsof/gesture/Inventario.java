package es.uam.eps.padsof.gesture;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;

import es.uam.eps.padsof.gesture.exception.NoEstaEnInventarioException;

/**
 * Representa un inventario.
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class Inventario extends ColeccionArticulosMutable implements Serializable {
	private static final long serialVersionUID = 20160327L;
	
	/**
	 * Comprueba que el inventario contiene la coleccion de artículos
	 * esperada
	 *
	 * @param col (coleccion de articulos)
	 * @return si la coleccion de articulos esta en el inventario
	 */
	public boolean contieneArticulos(ColeccionArticulos col) {
		for (Articulo articulo: col) {
			if (!articulos.contains(articulo)) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Retirar artículo.
	 *
	 * @param articulo Artículo
	 * @throws NoEstaEnInventarioException Si no está en el inventario
	 */
	public void retirarArticulo(Articulo articulo) throws NoEstaEnInventarioException {
		if (articulos.remove(articulo) == false) {
			throw new NoEstaEnInventarioException(articulo);
		}
	}
	
	/**
	 * Comprueba que se puede retirar una coleccion de artículos del inventario
	 *
	 * @param col
	 * @return si se puede retirar la coleccion de articulos
	 */
	public boolean retirarArticulos(ColeccionArticulos col) throws NoEstaEnInventarioException {
		if (!contieneArticulos(col)) {
			return false;
		}
		
		for (Articulo articulo: col) {
			retirarArticulo(articulo);
		}
		
		return true;
	}
	
	/**
	 * Añade un artículo al inventario
	 *
	 * @param articulo Artículo
	 */
	public void añadirArticulo(Articulo articulo) {
		articulo.setInventario(this);
		articulos.add(articulo);
	}
	
	/**
	 * Añade una coleccion de artículos al inventario.
	 *
	 * @param coleccion de artículos
	 */
	public void añadirArticulos(ColeccionArticulos col) {
		for (Articulo articulo: col) {
			añadirArticulo(articulo);
		}
	}

	/**
	 * Cargar artículos de archivo.
	 *
	 * @param filename Archivo a cargar
	 */
	public void cargarArticulosDeArchivo(String filename) throws IOException, ParseException {
		ArticulosReader ar = new ArticulosReader(filename);
		
		añadirArticulos(ar.leerTodo());
	}

	/**
	 * Cargar artículos de archivo.
	 *
	 * @param file Archivo a cargar
	 */
	public void cargarArticulosDeArchivo(File file) throws IOException, ParseException {
		ArticulosReader ar = new ArticulosReader(file);
		
		añadirArticulos(ar.leerTodo());
	}
}

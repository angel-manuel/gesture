package es.uam.eps.padsof.gesture;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Un colección inmutable de artículos que se puede filtrar
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class ColeccionArticulos implements Serializable, Iterable<Articulo> {
	private static final long serialVersionUID = 20160326L;
	protected ArrayList<Articulo> articulos;
	
	private ColeccionArticulos(ArrayList<Articulo> articulos) {
		this.articulos = articulos;
	}
	
	/**
	 * Crea una colección vacia
	 */
	public ColeccionArticulos() {
		this.articulos = new ArrayList<>();
	}
	
	/**
	 * Contiene artículo.
	 *
	 * @param articulo Artículo
	 * @return si el articulo está en la coleccion
	 */
	public boolean contieneArticulo(Articulo articulo) {
		return articulos.contains(articulo);
	}
	
	/**
	 * Obtiene el tamaño de la coleccion de articulos
	 *
	 * @return tamaño de la coleccion de articulos
	 */
	public int size() {
		return articulos.size();
	}
	
	/**
	 * Filtrar por tipo.
	 *
	 * @param tipo Tipo
	 * @return una nueva coleccion de articulos
	 */
	public ColeccionArticulos filtrarPorTipo(TipoDeArticulo tipo) {
		ArrayList<Articulo> res = new ArrayList<>();
		
		for(Articulo articulo: articulos) {
			if (articulo.getTipo() == tipo) {
				res.add(articulo);
			}
		}
		
		return new ColeccionArticulos(res);
	}
	
	
	/**
	 * Filtrar por descripcion.
	 *
	 * @param fragmentoDescripcion 
	 * @return una nueva coleccion de articulos
	 */
	public ColeccionArticulos filtrarPorDescripcion(String fragmentoDescripcion) {
		ArrayList<Articulo> res = new ArrayList<>();
		
		for(Articulo articulo: articulos) {
			if (articulo.getDescripcion().contains(fragmentoDescripcion)) {
				res.add(articulo);
			}
		}
		
		return new ColeccionArticulos(res);
	}
	
	/**
	 * Filtrar por precio maximo.
	 *
	 * @param precioMaximo
	 * @return ColeccionArticulos (la coleccion de articulos que sea menor 
	 * o igual al precio maxico)
	 */
	public ColeccionArticulos filtrarPorPrecioMaximo(double precioMaximo) {
		ArrayList<Articulo> res = new ArrayList<>();
		
		for(Articulo articulo: articulos) {
			if (articulo.getPrecioBase() <= precioMaximo) {
				res.add(articulo);
			}
		}
		
		return new ColeccionArticulos(res);
	}
	
	/**
	 * String que muestra por pantalla la coleccion de articulos
	 *
	 * @return ret: string de coleccion de articulos
	 */
	@Override
	public String toString() {
		String ret = "";
		
		for(Articulo articulo: articulos) {
			ret += articulo.toString() + '\n';
		}
		
		return ret;
	}

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Articulo> iterator() {
		return articulos.iterator();
	}
	
	public Stream<Articulo> stream() {
		return articulos.stream();
	}
	
	/**
	 * @return el primer artículo
	 */
	public Articulo first() {
		return iterator().next();
	}
}

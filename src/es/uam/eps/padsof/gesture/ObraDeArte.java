package es.uam.eps.padsof.gesture;

import java.io.Serializable;
import java.util.Date;

import es.uam.eps.padsof.gesture.subasta.Subastable;

/**
 * Representa una obra de arte.
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class ObraDeArte extends Articulo implements Subastable, Serializable {
	private static final long serialVersionUID = 20160326L;
	private String autor;
	private TipoDeObra tipoDeObra;
	private boolean certificado;
	private ObraDeArteDestino destino = ObraDeArteDestino.Venta;
	
	/**
	 * Constructor de ObraDeArte.
	 *
	 * @param autor Autor de la obra
	 * @param tipoDeObra Tipo de obra de arte
	 * @param certificado Si dispone de certificado de autenticidad
	 */
	public ObraDeArte(String descripcion, double precioBase, String año, Date fechaAdquisicion, double costeAdquisicion,
			String autor, TipoDeObra tipoDeObra, boolean certificado) {
		super(descripcion, precioBase, año, fechaAdquisicion, costeAdquisicion);
		this.autor = autor;
		this.tipoDeObra = tipoDeObra;
		this.certificado = certificado;
	}
	
	@Override
	public boolean isDisponibleParaSubasta() {
		return destino == ObraDeArteDestino.Subasta;
	}
	
	@Override
	public boolean isALaVenta() {
		return destino == ObraDeArteDestino.Venta;
	}
	
	/**
	 * String que muestra las caracteristicas de la obra de arte por pantalla
	 *
	 * @return string
	 */
	@Override
	public String toString() {
		return super.toString() + ": Obra de arte(" + tipoDeObra + ") de " + autor + (certificado ? " con certificado de autenticidad" : "");
	}
	
	@Override
	public TipoDeArticulo getTipo() {
		return TipoDeArticulo.ObraDeArte;
	}
	/**
	 * Obtiene el autor de la obra
	 * @return autor Autor
	 */
	public String getAutor(){
		return autor;
	}
	
	/**
	 * Obtiene el certificado
	 * @return true si tiene certificado de autenticidad, false en caso contrario
	 */
	public boolean getCertificado(){
		return certificado;
	}
	/**
	 * Obtiene el tipo de obra
	 * @return tipoDeObra Tipo de obra
	 */
	public TipoDeObra getTipoObra(){
		return tipoDeObra;
	}

	/**
	 * Getter de destino.
	 *
	 * @return el destino de ObraDeArte
	 */
	public ObraDeArteDestino getDestino() {
		return destino;
	}

	/**
	 * Setter de destino.
	 *
	 * @param destino el destino de ObraDeArte
	 */
	public void setDestino(ObraDeArteDestino destino) {
		this.destino = destino;
	}
}

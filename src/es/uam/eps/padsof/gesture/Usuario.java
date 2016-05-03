package es.uam.eps.padsof.gesture;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;

/**
 * Representa un usuario de la aplicación.
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class Usuario implements Serializable, Comparable<Usuario> {
	private static final long serialVersionUID = 20160325L;
	
	/** Nombre que tiene el gerente. */
	public static final String NOMBRE_GERENTE = "gerente";

	private final String nombre;
	private final byte[] salt;
	private final byte[] hashContraseña;
	
	/**
	 * Compara dos byte arrays en tiempo constante para evitar timing attacks.
	 *
	 * @param a Un byte array
	 * @param b Otro byte array
	 * @return Si son iguales
	 */
	private static boolean slowEquals(byte[] a, byte[] b) {
	    int diff = a.length ^ b.length;
	    for(int i = 0; i < a.length && i < b.length; i++)
	        diff |= a[i] ^ b[i];
	    return diff == 0;
	}
	
	/**
	 * Aplica un hash con salt a una contraseña.
	 *
	 * @param contraseña Contraseña a aplicar el hash
	 * @param salt Salt usado en el hash
	 * @return El hash
	 */
	private static byte[] hash(String contraseña, byte[] salt) {
       try {
    	   SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
    	   PBEKeySpec spec = new PBEKeySpec(contraseña.toCharArray(), salt, 16384, 128);
    	   SecretKey key = skf.generateSecret(spec);
    	   return key.getEncoded();
       } catch( NoSuchAlgorithmException | InvalidKeySpecException e ) {
    	   throw new RuntimeException( e );
       }
	}
	
	/**
	 * Constructor de Usuario.
	 *
	 * @param nombre Nombre del usuario
	 * @param contraseña Contraseña del usuario(no se guarda directamente)
	 */
	public Usuario(String nombre, String contraseña) {
		this.nombre = nombre;
		
		SecureRandom random = new SecureRandom();
		this.salt = new byte[16];
		random.nextBytes(this.salt);
		this.hashContraseña = hash(contraseña, this.salt);
	}

	/**
	 * Getter de nombre.
	 *
	 * @return el nombre de Usuario
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Comprueba si determinada contraseña es la del usuario.
	 *
	 * @param contraseña contraseña a comprobar
	 * @return Si la contraseña es la del usuario
	 */
	public boolean comprobarContraseña(String contraseña) {
		byte[] hashTest = hash(contraseña, salt);
		return slowEquals(hashContraseña, hashTest);
	}
	
	/**
	 * Comprueba si el usuario es el gerente a partir del nombre de usuario.
	 *
	 * @return Si el usuario es un gerente
	 */
	public boolean isGerente() {
		return nombre.contentEquals(NOMBRE_GERENTE);
	}
	
	@Override
	public int compareTo(Usuario otro) {
		return nombre.compareTo(otro.nombre);
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}


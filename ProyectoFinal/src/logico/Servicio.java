package logico;

import java.io.Serializable;

public class Servicio implements Serializable {
	
	 protected String codigo;
	 protected String nombre;
	 protected float precio;
	 
	 
	public Servicio(String codigo, String nombre,
			float precioFinal) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precioFinal;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}
	 
	
	 
	
}

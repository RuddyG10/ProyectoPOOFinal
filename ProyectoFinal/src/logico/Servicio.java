package logico;

public class Servicio {
	
	 protected String codigo;
	 protected String nombre;
	 protected String estado;
	 protected float precioFinal;
	 
	public Servicio(String codigo, String nombre, String estado,
			float precioFinal) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.estado = estado;
		this.precioFinal = precioFinal;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public float getPrecioFinal() {
		return precioFinal;
	}
	 
	
	 
	
}

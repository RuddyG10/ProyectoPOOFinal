package logico;

public class Servicio {
	
	 protected String codigo;
	 protected String nombre;
	 protected String tipo;
	 protected String estado;
	 protected float costoImp;
	 protected float valorGanancia;
	 protected float precioFinal;
	 
	public Servicio(String codigo, String nombre, String tipo, String estado, float costoImp, float valorGanancia,
			float precioFinal) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.estado = estado;
		this.costoImp = costoImp;
		this.valorGanancia = valorGanancia;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getCostoImp() {
		return costoImp;
	}

	public float getValorGanancia() {
		return valorGanancia;
	}

	public float getPrecioFinal() {
		return precioFinal;
	}
	 
	
	 
	
}

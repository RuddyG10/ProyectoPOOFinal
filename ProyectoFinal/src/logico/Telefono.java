package logico;

public class Telefono extends Servicio {
	private float cantMinutos;

	public Telefono(String codigo, String nombre, String estado,
			float precioFinal, float cantMinutos) {
		super(codigo, nombre, estado, precioFinal);
		this.cantMinutos = cantMinutos;
	}

	public float getCantMinutos() {
		return cantMinutos;
	}

	public void setCantMinutos(float cantMinutos) {
		this.cantMinutos = cantMinutos;
	}
	
	

}

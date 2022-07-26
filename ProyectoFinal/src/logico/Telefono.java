package logico;

public class Telefono extends Servicio {
	private float cantMinutos;

	public Telefono(String codigo, String nombre,
			float precioFinal, float cantMinutos) {
		super(codigo, nombre, precioFinal);
		this.cantMinutos = cantMinutos;
	}

	public float getCantMinutos() {
		return cantMinutos;
	}

	public void setCantMinutos(float cantMinutos) {
		this.cantMinutos = cantMinutos;
	}
	
	

}

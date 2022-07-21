package logico;

public class Telefono extends Servicio {
	private float cantMinutos;

	public Telefono(String codigo, String nombre, String tipo, String estado, float costoImp, float valorGanancia,
			float precioFinal, float cantMinutos) {
		super(codigo, nombre, tipo, estado, costoImp, valorGanancia, precioFinal);
		this.cantMinutos = cantMinutos;
	}

	public float getCantMinutos() {
		return cantMinutos;
	}

	public void setCantMinutos(float cantMinutos) {
		this.cantMinutos = cantMinutos;
	}
	
	

}

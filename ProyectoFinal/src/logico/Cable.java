package logico;

public class Cable extends Servicio {
	private int cantCanales;

	public Cable(String codigo, String nombre,
			float precioFinal, int cantCanales) {
		super(codigo, nombre, precioFinal);
		 this.cantCanales = cantCanales;
	}

	public int getCantCanales() {
		return cantCanales;
	}

	public void setCantCanales(int cantCanales) {
		this.cantCanales = cantCanales;
	}

	
}

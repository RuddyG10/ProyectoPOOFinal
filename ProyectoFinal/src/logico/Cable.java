package logico;

public class Cable extends Servicio {
	private int cantCanales;

	public Cable(String codigo, String nombre, String tipo, String estado, float costoImp, float valorGanancia,
			float precioFinal, int cantCanales) {
		super(codigo, nombre, tipo, estado, costoImp, valorGanancia, precioFinal);
		 this.cantCanales = cantCanales;
	}

	public int getCantCanales() {
		return cantCanales;
	}

	public void setCantCanales(int cantCanales) {
		this.cantCanales = cantCanales;
	}

	
}

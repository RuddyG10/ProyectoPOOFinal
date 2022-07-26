package logico;

public class Internet extends Servicio {

		 private float cantMegasSubida;
		 private float cantMegasBajada;
		 
	public Internet(String codigo, String nombre,
			float precioFinal, float cantMegasSubida, float cantMegasBajada) {
		super(codigo, nombre, precioFinal);
		this.cantMegasBajada= cantMegasBajada;
		this.cantMegasSubida = cantMegasSubida;
		}

	public float getCantMegasSubida() {
		return cantMegasSubida;
	}

	public void setCantMegasSubida(float cantMegasSubida) {
		this.cantMegasSubida = cantMegasSubida;
	}

	public float getCantMegasBajada() {
		return cantMegasBajada;
	}

	public void setCantMegasBajada(float cantMegasBajada) {
		this.cantMegasBajada = cantMegasBajada;
	}

	
}

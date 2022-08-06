package logico;

import java.io.Serializable;
import java.util.Date;

public class Factura implements Serializable {
	
	private String codigo;
	private Plan plan;
	private Cliente miCliente;
	private Date fecha;
	private Date fechaCorte;
	private Trabajador vendedor;
	private float total;
	private boolean pagada;
	public Factura(String codigo, Cliente client,Plan plan,Trabajador vendedor,Date fecha, float total) {
		super();
		this.codigo = codigo;
		this.miCliente = client;
		this.plan = plan;
		this.vendedor = vendedor;
		this.total = total;
		this.fecha = Altice.getInstance().fechaFactura(new Date(), 3);
		this.fechaCorte= fecha;
		this.pagada = false;
	}
	
	
	public boolean isPagada() {
		return pagada;
	}


	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}


	public Date getFechaCorte() {
		return fechaCorte;
	}


	public Trabajador getVendedor() {
		return vendedor;
	}

	public Plan getPlan() {
		return plan;
	}

	public Cliente getMiCliente() {
		return miCliente;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Date getFecha() {
		return fecha;
	}
	public float getTotal() {
		return total;
	}
	//TODO
	
}

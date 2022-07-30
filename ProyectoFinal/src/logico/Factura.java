package logico;

import java.util.Date;

public class Factura {
	
	private String codigo;
	private Plan plan;
	private Cliente miCliente;
	private Date fecha;
	private float total;
	public Factura(String codigo, Cliente client,Plan plan, float total) {
		super();
		this.codigo = codigo;
		this.miCliente = client;
		this.plan = plan;
		this.total = total;
		this.fecha = new Date();
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

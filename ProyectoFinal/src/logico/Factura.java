package logico;

import java.io.Serializable;
import java.util.Date;

public class Factura implements Serializable {
	
	private String codigo;
	private Plan plan;
	private Cliente miCliente;
	private Date fecha;
	private Trabajador vendedor;
	private float total;
	public Factura(String codigo, Cliente client,Plan plan,Trabajador vendedor, float total) {
		super();
		this.codigo = codigo;
		this.miCliente = client;
		this.plan = plan;
		this.vendedor = vendedor;
		this.total = total;
		this.fecha = new Date();
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

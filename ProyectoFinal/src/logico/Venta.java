package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Venta implements Serializable{
	private String numIdent;
	private Trabajador vendedor;
	private Cliente cliente;
	private ArrayList<Plan> planes;
	private Date fecha;
	public Venta(String numIdent, Trabajador vendedor, Cliente cliente, ArrayList<Plan> planes) {
		super();
		this.numIdent = numIdent;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.planes = planes;
		this.fecha = new Date();
	}
	public String getNumIdent() {
		return numIdent;
	}
	public void setNumIdent(String numIdent) {
		this.numIdent = numIdent;
	}
	public Trabajador getVendedor() {
		return vendedor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public ArrayList<Plan> getPlanes() {
		return planes;
	}
	public Date getFecha() {
		return fecha;
	}
	
	
	
}

package logico;

import java.util.Date;

public class Factura {
	
	private String codigo;
	private Venta venta;
	private Date fecha;
	private float total;
	public Factura(String codigo, Venta venta, float total) {
		super();
		this.codigo = codigo;
		this.venta = venta;
		this.total = total;
		this.fecha = new Date();
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Venta getVenta() {
		return venta;
	}
	public Date getFecha() {
		return fecha;
	}
	public float getTotal() {
		return total;
	}
	//TODO
	
}

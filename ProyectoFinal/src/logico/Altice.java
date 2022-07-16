package logico;

import java.util.ArrayList;

public class Altice {
	private ArrayList<Trabajador> misTrabajadores;
	private ArrayList<Plan> planes;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Factura> facturas;
	public static int genCodePlan=1;
	public static int genCodeFac = 1;
	public Altice() {
		super();
		this.facturas = new ArrayList<Factura>();
		this.misClientes = new ArrayList<Cliente>();
		this.misTrabajadores = new ArrayList<Trabajador>();
		this.planes = new ArrayList<Plan>();
	}
	public ArrayList<Trabajador> getMisTrabajadores() {
		return misTrabajadores;
	}
	public ArrayList<Plan> getPlanes() {
		return planes;
	}
	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}
	public ArrayList<Factura> getFacturas() {
		return facturas;
	}
	public void insertarTrabajador(Trabajador empleado) {
		misTrabajadores.add(empleado);
	}
	public void insertarCliente(Cliente auxClient) {
		misClientes.add(auxClient);
	}
	public void insertarFactura(Factura fac) {
		facturas.add(fac);
		genCodeFac++;
	}
	public void insertarPlan(Plan plan) {
		planes.add(plan);
		genCodePlan++;
	}
	
	
}

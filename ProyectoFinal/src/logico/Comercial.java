package logico;

import java.util.ArrayList;

public class Comercial extends Trabajador {
	
	private ArrayList<Venta> misVentas;
	public Comercial(String nombre,String apellidos, String cedula, String telefono, String email, String userName, String password) {
		super(nombre,apellidos, cedula, telefono, email, userName, password);

		this.misVentas = new ArrayList<Venta>();
	}
	public ArrayList<Venta> getMisVentas() {
		return misVentas;
	}
	public void salario() {
		salario = 17000;
	}
}

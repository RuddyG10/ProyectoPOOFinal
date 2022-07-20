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
	public Trabajador buscarTrabajadorByCedula(String cedula) {
		Trabajador auxTrab = null;
		boolean found = false;
		int i = 0;
		while(i< misTrabajadores.size() && !found) {
			if(misTrabajadores.get(i).getCedula().equalsIgnoreCase(cedula)) {
				auxTrab = misTrabajadores.get(i);
				found = true;
			}
			i++;
		}
		return auxTrab;
	}
	public Trabajador mejorComercial() {
		Trabajador mejorComercial = null;
		int cantV = 0;
		for (Trabajador trabajador : misTrabajadores) {
			if(trabajador instanceof Comercial) {
				if(((Comercial) trabajador).getMisVentas().size() > cantV) {
					cantV = ((Comercial) trabajador).getMisVentas().size();
					mejorComercial = trabajador;
				}
			}
		}
		
		return mejorComercial;
	}
	public Trabajador buscarTrabajadorPorUserOEmail(String user) {
		Trabajador aux = null;
		boolean found = false;
		int i = 0;
		while(i< misTrabajadores.size() && !found) {
			if(misTrabajadores.get(i).getUserName().equalsIgnoreCase(user) ||
					misTrabajadores.get(i).getEmail().equalsIgnoreCase(user)) {
				
				aux = misTrabajadores.get(i);
				found = true;
			}
			i++;
		}
		return aux;
	}
	
	public boolean login(String userName, String password) {
		boolean log = false;
		Trabajador admin = buscarTrabajadorPorUserOEmail(userName);
		if(admin != null) {
			if(admin.getPassword().equalsIgnoreCase(password)) {
				log =true;
			}
		}
		
		return log;
	}
	public Cliente buscarClientePorCedula(String cedula) {
		Cliente auxClient = null;
		boolean found = false;
		int i = 0;
		while(i< misClientes.size() && !found) {
			/*if(misClientes.get(i).getCedula().equalsIgnoreCase(cedula)) {
				auxClient = misTrabajadores.get(i);
				found = true;
			}
			i++;*/
		}
		return auxClient;
	}
	
}

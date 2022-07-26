package logico;

import java.util.ArrayList;


public class Altice {
	private ArrayList<Trabajador> misTrabajadores;
	private ArrayList<Plan> misPlanes;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Factura> facturas;
	private ArrayList<Servicio> servicios;
	public static int genCodePlan=1;
	public static int genCodeFac = 1;
	public static int genCodeVent = 1;
	public static int genCodeServ = 1;
	public static Altice altice = null;
	
	private Altice() {
		super();
		this.facturas = new ArrayList<Factura>();
		this.misClientes = new ArrayList<Cliente>();
		this.misTrabajadores = new ArrayList<Trabajador>();
		this.misPlanes = new ArrayList<Plan>();
		this.servicios = new ArrayList<Servicio>();
	}
	public static Altice getInstace() {
		if(altice == null) {
			altice = new Altice();
		}
		return altice;
	}
	public ArrayList<Servicio> getServicios() {
		return servicios;
	}

	public ArrayList<Trabajador> getMisTrabajadores() {
		return misTrabajadores;
	}
	public ArrayList<Plan> getmisPlanes() {
		return misPlanes;
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
	public boolean insertarCliente(Cliente auxClient) {
		boolean reg = false;
		Cliente verificar = buscarClientePorCedula(auxClient.getCedula());
		if(verificar == null) {
			reg = true;
			misClientes.add(auxClient);
		}
		
		return reg;
	}
	public void insertarFactura(Factura fac) {
		facturas.add(fac);
		genCodeFac++;
	}
	public void insertarPlan(Plan plan) {
		misPlanes.add(plan);
		genCodePlan++;
	}
	public void insertarServicio(Servicio serv) {
		servicios.add(serv);
		genCodeServ++;
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
		
		
		return log;
	}
	public Cliente buscarClientePorCedula(String cedula) {
		Cliente auxClient = null;
		boolean found = false;
		int i = 0;
		while(i< misClientes.size() && !found) {
			if(misClientes.get(i).getCedula().equalsIgnoreCase(cedula)) {
				auxClient = misClientes.get(i);
				found = true;
			}
			i++;
		}
		return auxClient;
	}
	public Venta realizarVenta(String cedulaCliente,String cedulaTrabajador,ArrayList<Plan> planes) {
		Venta auxVenta = null;
		Trabajador auxTrab = buscarTrabajadorByCedula(cedulaTrabajador);
		Cliente auxClient = buscarClientePorCedula(cedulaCliente);
		boolean habilitado = false;
		int i = 0;
		
		if(auxTrab != null && auxClient != null && auxTrab instanceof Comercial) {
			if(planesHabilitados(auxClient)) {
				auxVenta = new Venta("V-"+genCodeVent, auxTrab, auxClient, planes);
				Factura fac = realizarFactura(auxVenta);
				if(fac != null) {
					((Comercial) auxTrab).getMisVentas().add(auxVenta);
					genCodeVent++;
					auxClient.getMisFacturas().add(fac);
					insertarFactura(fac);
					for (Plan plan : planes) {
						misPlanes.remove(plan);
					}
				}
			}
			
			
		}
		
		return auxVenta;
		
	}
	public boolean planesHabilitados(Cliente auxClient) {
		boolean habilitado = true;
		ArrayList<Plan> planesCliente = auxClient.getPlanes();
		int i = 0;
		while(i< planesCliente.size() && habilitado) {
			if(planesCliente.get(i).getEstado().equalsIgnoreCase("Inhabilitado")) {
				habilitado = false;
			}
			i++;
		}
		return habilitado;
	}

	public Factura realizarFactura(Venta venta) {
		float total = 0;
		Factura auxFac = null;
		if(venta != null) {
			ArrayList<Plan> planes = venta.getPlanes();
			for (Plan plan : planes) {
				total+=plan.getTotalPrecio();
			}
		}
		if(total > 0) {
			auxFac = new Factura("F-"+genCodeFac, venta, total);
			insertarFactura(auxFac);
		}
		return auxFac;
	}
	
	
}

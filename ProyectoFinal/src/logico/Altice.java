package logico;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


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
	private static Altice altice = null;
	
	private Altice() {
		super();
		this.facturas = new ArrayList<Factura>();
		this.misClientes = new ArrayList<Cliente>();
		this.misTrabajadores = new ArrayList<Trabajador>();
		this.misPlanes = new ArrayList<Plan>();
		this.servicios = new ArrayList<Servicio>();
	}
	public static Altice getInstance() {
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
	public Date calcularFechaCorte(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH,1);
		Date newDate = c.getTime();
		return newDate;
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
	public Factura realizarVenta(String cedulaCliente,String cedulaTrabajador,ArrayList<Plan> planes) {
		Venta auxVenta = null;
		Trabajador auxTrab = buscarTrabajadorByCedula(cedulaTrabajador);
		Cliente auxClient = buscarClientePorCedula(cedulaCliente);
		Factura fac = null;
		boolean habilitado = false;
		if(auxTrab != null && auxClient != null && auxTrab instanceof Comercial) {
			if(planesHabilitados(auxClient)) {
				auxVenta = new Venta("V-"+genCodeVent, auxTrab, auxClient, planes);
				fac = realizarFactura(auxVenta);
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
		
		return fac;
		
	}
	public boolean planesHabilitados(Cliente auxClient) {
		boolean habilitado = true;
		ArrayList<Plan> planesCliente = auxClient.getPlanes();
		int i = 0;
		while(i< planesCliente.size() && habilitado) {
			if(!planesCliente.get(i).getEstado().equalsIgnoreCase("Habilitado")) {
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
		}
		return auxFac;
	}
	public boolean planTieneServicio(Plan plan, String string) {
		ArrayList<Servicio> servicios = plan.getServicios();
		boolean find = false;
		int i = 0;
		while(i< servicios.size() && !find) {
			
			if(string.equalsIgnoreCase("Cable")) {
				if(servicios.get(i) instanceof Cable) {
					find = true;
					
				}
			}
			else if(string.equalsIgnoreCase("Internet")) {
				if(servicios.get(i) instanceof Internet) {
					find = true;
					System.out.println(servicios.get(i).getCodigo());
				}
			}
			else if(string.equalsIgnoreCase("Telefono")) {
				if(servicios.get(i) instanceof Telefono) {
					find = true;
				}
			}
			i++;
		}
		return find;
	}
	public Plan buscarPlanByCode(String code) {
		Plan auxPlan = null;
		boolean found = false;
		int i = 0;
		while(i< misPlanes.size() && !found) {
			if(misPlanes.get(i).getCodigo().equalsIgnoreCase(code)) {
				auxPlan = misPlanes.get(i);
				found = true;
			}
			i++;
		}
		return auxPlan;
}

	public float calcularPrecioServicio(float cantidad) {
		float precioTotal = 0f;
		float precioUnidad = 1.2f;
		precioTotal+= precioUnidad *cantidad;
		return precioTotal;
	}
	public float calcularPrecioPlan(ArrayList<Servicio> ServiciosDelPlan) {
		float precioTotal = 0f;
		for (Servicio servicio : ServiciosDelPlan) {
		  precioTotal += servicio.getPrecio();
		}
		return precioTotal;
	}
	public Factura buscarFacturaByCode(String codigo) {
		Factura fac = null;
		boolean found = false;
		int i = 0;
		while(i< facturas.size() && !found) {
			if(facturas.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				fac = facturas.get(i);
				found = true;
			}
			i++;
		}
		return fac;
	}
	
	
}

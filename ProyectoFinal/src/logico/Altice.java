package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Altice implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Trabajador> misTrabajadores;
	private ArrayList<Plan> misPlanes;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Factura> facturas;
	private ArrayList<Servicio> servicios;
	private ArrayList<Venta> ventas;
	public static int genCodePlan=1;
	public static int genCodeFac = 1;
	public static int genCodeVent = 1;
	public static int genCodeServ = 1;
	private static Altice altice = null;
	private static boolean firstTime;

	private Altice() {
		super();
		this.facturas = new ArrayList<Factura>();
		this.misClientes = new ArrayList<Cliente>();
		this.misTrabajadores = new ArrayList<Trabajador>();
		this.misPlanes = new ArrayList<Plan>();
		this.servicios = new ArrayList<Servicio>();
		this.ventas= new ArrayList<Venta>();
	}
	public static boolean isFirstTime() {
		return firstTime;
	}

	public static void setFirstTime(boolean firstTime) {
		Altice.firstTime = firstTime;
	}
	public static Altice getInstance() {
		if(altice == null) {
			altice = new Altice();
		}
		return altice;
	}
	public static void setAltice(Altice altice) {
		Altice.altice = altice;
	}
	public ArrayList<Venta> getVentas() {
		return ventas;
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
	public void insertarVenta(Venta vent) {
		ventas.add(vent);
		genCodeVent++;
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
		c.add(Calendar.MONTH,3);
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

	public Trabajador login(String userName, String password) {
		Trabajador admin = null;
		if(buscarTrabajadorPorUserOEmail(userName) != null && buscarTrabajadorPorUserOEmail(userName).getPassword().equalsIgnoreCase(password)) {
			admin = buscarTrabajadorPorUserOEmail(userName);
			
		}
		
		return admin;
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
		if(auxTrab != null && auxClient != null) {
			if(planesHabilitados(auxClient)) {
				auxVenta = new Venta("V-"+genCodeVent, auxTrab, auxClient, planes);
				realizarFactura(auxVenta);
				if(auxTrab instanceof Comercial) {
					((Comercial) auxTrab).getMisVentas().add(auxVenta);
				}
				
				insertarVenta(auxVenta);
				}
			}
			
		return auxVenta;


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

	public void realizarFactura(Venta venta) {
		Factura auxFac = null;
		if(venta != null) {
			ArrayList<Plan> planes = venta.getPlanes();
			for (Plan plan : planes) {
				auxFac = new Factura("F-"+genCodeFac, venta.getCliente(),plan , plan.getTotalPrecio());
				venta.getCliente().getMisFacturas().add(auxFac);
				insertarFactura(auxFac);
				genCodeFac++;
			}
		}
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
		float precioUnidad = 5.6f;
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


	public void eliminarPlan(Plan selected) {
		int index = -1;
		index = buscarIndexByPlan (selected.getCodigo());
		misPlanes.remove(index);

	}
	private int buscarIndexByPlan(String codigo) {
		int aux = -1;
		int i =0;
		boolean encontrado = false;
		while (i < misPlanes.size() && !encontrado) {
			if (misPlanes.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				aux = i;
				encontrado = true;
			}
			i++;
		}
		return aux;
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
	public Plan planMasVendido() {
		Plan planVendido = null;
		int cantVenta = 0;
		for (Venta venta : ventas) {
			ArrayList<Plan> planesVenta = venta.getPlanes();
			for (Plan plan : planesVenta) {
				if(cantVenta<cantidadPlanVendido(planesVenta,plan)) {
					cantVenta = cantidadPlanVendido(planesVenta,plan);
					planVendido = plan;
				}
			}
		}
		return planVendido;
	}
	public int cantidadPlanVendido(ArrayList<Plan> planesVenta, Plan plan) {
		int cantidad = 0;
		if(plan != null && planesVenta != null) {
			if(planesVenta.contains(plan)) {
				for (Plan plan2 : planesVenta) {
					if(plan2 == plan) {
						cantidad++;
					}
				}
			}
		}
		return cantidad;
	}
	public Venta buscarFacturaByVenta(String codigo) {
		Venta vent = null;
		boolean found = false;
		int i = 0;
		while(i< ventas.size() && !found) {
			if(ventas.get(i).getNumIdent().equalsIgnoreCase(codigo)) {
				vent = ventas.get(i);
				found = true;
			}
			i++;
		}
		return vent;
	}
	public void eliminarUsuario(Trabajador selected) {
		int index = -1;
		index = buscarIndexByTrabajador(selected.getCedula());
		misPlanes.remove(index);

		
	}
	private int buscarIndexByTrabajador(String cedula) {
		int aux = -1;
		int i =0;
		boolean encontrado = false;
		while (i < misTrabajadores.size() && !encontrado) {
			if (misTrabajadores.get(i).getCedula().equalsIgnoreCase(cedula)) {
				aux = i;
				encontrado = true;
			}
			i++;
		}
		return aux;
	}
	
}

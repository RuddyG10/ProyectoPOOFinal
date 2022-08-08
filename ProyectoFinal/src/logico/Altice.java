package logico;


import java.io.FileInputStream;		
import java.io.FileNotFoundException;		
import java.io.FileOutputStream;		
import java.io.IOException;		
import java.io.ObjectInputStream;		
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
	public static int genCodeFile = 1;
	private static Altice altice = null;
	private ArrayList<Date> fechasGanancias;
	private ArrayList<Float> ingresoE;
	private ArrayList<Float> ingresoR;
	private float ingresoEstimada;
	private float ingresoReal;

	private Altice() {
		super();
		this.facturas = new ArrayList<Factura>();
		this.misClientes = new ArrayList<Cliente>();
		this.misTrabajadores = new ArrayList<Trabajador>();
		this.misPlanes = new ArrayList<Plan>();
		this.servicios = new ArrayList<Servicio>();
		this.ventas= new ArrayList<Venta>();
		this.fechasGanancias = new ArrayList<Date>();
		this.ingresoE = new ArrayList<Float>();
		this.ingresoR = new ArrayList<Float>();
		this.ingresoEstimada = 0;
		this.ingresoReal = 0;
	}
	public static Altice getInstance() {
		if(altice == null) {
			altice = new Altice();
		}
		return altice;
	}
	
	public ArrayList<Date> getFechasGanancias() {
		return fechasGanancias;
	}
	public ArrayList<Float> getIngresoE() {
		return ingresoE;
	}
	public ArrayList<Float> getIngresoR() {
		return ingresoR;
	}
	public float getIngresoEstimada() {
		return ingresoEstimada;
	}
	public float getIngresoReal() {
		return ingresoReal;
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
	public void insertarPlan(Plan plan) throws ParseException {
		misPlanes.add(plan);
		genCodePlan++;
		ingresoEstimada+= plan.getTotalPrecio();
		ingresarGanancias(new Date());
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
	public Date fechaFactura(Date date,int month) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(c.MONTH, 1);
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
		if(buscarTrabajadorPorUserOEmail(userName) != null && buscarTrabajadorPorUserOEmail(userName).getPassword().equals(password)) {
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
	public Venta realizarVenta(String cedulaCliente,String cedulaTrabajador,ArrayList<Plan> planes) throws ParseException {
		Venta auxVenta = null;
		Trabajador auxTrab = buscarTrabajadorByCedula(cedulaTrabajador);
		Cliente auxClient = buscarClientePorCedula(cedulaCliente);
		if(auxTrab != null && auxClient != null) {
				auxVenta = new Venta("V-"+genCodeVent, auxTrab, auxClient, planes);
				realizarFactura(auxVenta);
				if(auxTrab instanceof Comercial) {
					((Comercial) auxTrab).getMisVentas().add(auxVenta);
				}
				
				insertarVenta(auxVenta);
				ingresarGanancias(new Date());
				}
			
			
		return auxVenta;


	}
	public boolean revisarFacturasClient(Cliente aux) {
		ArrayList<Factura> facturas = aux.getMisFacturas();
		ArrayList<Plan> planes = aux.getPlanes();
		boolean alDia = true;
		for (Plan plan : planes) {
			int count = 0;
			for (Factura fac : facturas) {
				if(fac.getPlan().equals(plan)) {
					if(!fac.isPagada()) {
						count++;
					}
				}
			}
			if(count >=3) {
				plan.setEstado("Cancelado");
				alDia = false;
			}
			else if(count>0 && count < 3){
				plan.setEstado("Inhabilitado");
				alDia = false;
			}
			else if(count == 0) {
				plan.setEstado("Habilitado");
			}
		}
		return alDia;
	}
	public int cantFacturasPendientes(Cliente aux){
		ArrayList<Factura> facturas = aux.getMisFacturas();
		ArrayList<Plan> planes = aux.getPlanes();
		int count = 0;
		for (Plan plan : planes) {
			int auxcount = 0;
			for (Factura fac : facturas) {
				if(fac.getPlan().equals(plan)) {
					if(!fac.isPagada()) {
						auxcount++;
					}
				}
			}
			if(count < auxcount) {
				count = auxcount;
			}
			if(auxcount >=3) {
				plan.setEstado("Cancelado");
			}
			else if(auxcount>0 && auxcount < 3){
				plan.setEstado("Inhabilitado");
			}
			else if(count == 0) {
				plan.setEstado("Habilitado");
			}
		}
		return count;
	}

	public boolean planesHabilitados(Cliente auxClient) {
		boolean habilitado = true;
		ArrayList<Plan> planesCliente = auxClient.getPlanes();
		int i = 0;
		while(i< planesCliente.size() && habilitado) {
			if(planesCliente.get(i).getEstado().equalsIgnoreCase("Cancelado")) {
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
				auxFac = new Factura("F-"+genCodeFac, venta.getCliente(),plan,venta.getVendedor(),calcularFechaCorte(new Date()) , plan.getTotalPrecio());
				venta.getCliente().getMisFacturas().add(auxFac);
				insertarFactura(auxFac);
				ingresoReal+=plan.getTotalPrecio();
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
		
		
		for (Plan plan : misPlanes) {
			int cantidad = 0;
			for(Venta vent: ventas) {
				ArrayList<Plan> planesVenta = vent.getPlanes();
				if(planesVenta.contains(plan)) {
					cantidad++;
				}
			}
			if(cantidad>cantVenta) {
				cantVenta = cantidad;
				planVendido = plan;
			}
		}
		return planVendido;
	}
	
	public Plan planMenosVendido () {
		Plan menosVendido = null;
		int menor = 1;
		for (Plan plan: misPlanes){
			int cantidad =0;
			for (Venta vent : ventas) {
				ArrayList<Plan> planes = vent.getPlanes();
				if (planes.contains(plan)) {
					cantidad++;
				}
				if(cantidad <= menor) {
					menor = cantidad;
					menosVendido = plan;
				}
			}
		}
		return menosVendido;
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
	public Factura buscarFacturaClientByCode(String codigo) {
		Factura vent = null;
		boolean found = false;
		int i = 0;
		while(i< facturas.size() && !found) {
			if(facturas.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				vent = facturas.get(i);
				found = true;
			}
			i++;
		}
		return vent;
	}
	
	
	public void eliminarUsuario(Trabajador selected) {
		int index = -1;
		index = buscarIndexByTrabajador(selected.getCedula());
		misTrabajadores.remove(index);

		
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
	public ArrayList<Factura> buscarFacturasSinPagar(Cliente cliente, Plan plan) {
		ArrayList<Factura> facturas = null;
		if(cliente != null && plan != null) {
			facturas = new ArrayList<Factura>();
			for (Factura factura : cliente.getMisFacturas()) {
				if(factura.getPlan().equals(plan) && !factura.isPagada()) {
					facturas.add(factura);
				}
			}
		}
		
		return facturas;
	}
	public Factura buscarFacPorClientPlan(Plan plan, Cliente cliente) {
		Factura vent = null;
		boolean found = false;
		ArrayList<Factura> clientFac = cliente.getMisFacturas();
		int i = 0;
		while(i< clientFac.size()&&!found) {
			System.out.println(clientFac.get(i).getPlan().getCodigo());
			if(clientFac.get(i).getPlan().equals(plan)) {
				vent = clientFac.get(i);
				found = true;
			}
			i++;
		}
		return vent;
	}
	
	public void ingresarGanancias(Date date) throws ParseException {
		boolean ingreso = ingresarFecha(date);
		if(ingreso && fechasGanancias.size()== ingresoE.size() && fechasGanancias.size()== ingresoR.size()) {
			ingresoE.add(ingresoEstimada);
			ingresoR.add(ingresoReal);
			
		}else if (ingreso && fechasGanancias.size()> ingresoE.size() && fechasGanancias.size()> ingresoR.size()) {
			ingresoE.add(ingresoEstimada);
			ingresoR.add(ingresoReal);
			ingresoEstimada = 0;
			ingresoReal = 0;
		}
		else if(!ingreso){
			int i = fechasGanancias.size();
			if(ingresoR.size()>0) {
				float real = ingresoR.get(i-1);
				real+=ingresoReal;
				ingresoR.add(i-1, real);
				ingresoReal = 0;
			}
			else {
				ingresoR.add(ingresoReal);
				ingresoReal = 0;
			}
			if(ingresoE.size()>0) {
				float est = ingresoE.get(i-1);
				est+=ingresoEstimada;
				ingresoE.add(i-1, est);
				ingresoEstimada = 0;
			}
			else {
				ingresoE.add(ingresoEstimada);
				ingresoEstimada = 0;
			}
			}
	}
	
	public boolean ingresarFecha(Date date) {
		boolean newDate = false;
		
		if(fechasGanancias.size() == 0) {
			fechasGanancias.add(date);
			newDate = true;
		}
		else if(fechasGanancias.size()>0 && !newDate) {
			int i = fechasGanancias.size()-1;
			Date firstDate = fechasGanancias.get(i);
			
			try {
				if(mayorFecha(firstDate,date)>=1) {
					fechasGanancias.add(date);
					newDate = true;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return newDate;
		
	}
	private long mayorFecha(Date firstDate, Date date) throws ParseException {
		boolean esMayor = false;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String firstDateString = formato.format(firstDate);
		String lastDayString = formato.format(date);
		Date firstDateFormat = formato.parse(firstDateString);
		Date lastDayFormat = formato.parse(lastDayString);
		long tiempoTrans = lastDayFormat.getTime() - firstDateFormat.getTime();
		TimeUnit unidad = TimeUnit.DAYS;
		long dias = unidad.convert(tiempoTrans, TimeUnit.MILLISECONDS);
		
		return dias;
	}
	public void editarPlan(String cod, Plan auxiliar) {
		Plan aux = buscarPlanByCode(cod);
		aux.setNombrePlan(auxiliar.getNombrePlan());
		aux.setDescripcion(auxiliar.getDescripcion());
	}
	public void editarInfoClient(String ced, Cliente auxiliar) {
		Cliente aux = buscarClientePorCedula(ced);
		aux.setNombre(auxiliar.getNombre());
		aux.setApellido(auxiliar.getApellido());
		aux.setDireccion(auxiliar.getDireccion());
		aux.setTelefono(auxiliar.getTelefono());
}
	
}
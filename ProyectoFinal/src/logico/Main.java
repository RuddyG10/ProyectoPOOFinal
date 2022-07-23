package logico;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Altice adm = new Altice();
		float totalPrecio = 0;
		ArrayList<Servicio> servicios = new ArrayList<>();
		ArrayList<Plan> planes = new ArrayList<>();
		Trabajador jose = new Comercial("Jose", "Rod", "402", "829", "Jose@hotmail.com", "Jose402", "3000");
		
		Servicio internet = new Internet("I-"+adm.genCodeServ, "Internet", "Habilitado", 100, 100, 100);
		adm.insertarServicio(internet);
		servicios.add(internet);
		
		for (Servicio servicio : servicios) {
			totalPrecio+= servicio.getPrecioFinal();
		}
		
		Plan planInt = new Plan("P-"+adm.genCodePlan, "InternetFull", "Internet 100mbps", 20, servicios, totalPrecio);
		planes.add(planInt);
		Cliente Ruddy = new Cliente("444", "Ruddy", "Gomez", "809", "Dorado", planes);
		adm.insertarCliente(Ruddy);
		adm.insertarTrabajador(jose);
		adm.realizarVenta(Ruddy.getCedula(), jose.getCedula(), planes);
		ArrayList<Factura> factura = Ruddy.getMisFacturas();
		
		for (Factura factura2 : factura) {
			System.out.println(factura2.getTotal());
		}
	}

}

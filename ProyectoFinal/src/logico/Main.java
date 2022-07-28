package logico;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		/*
		float totalPrecio = 0;
		ArrayList<Servicio> servicios = new ArrayList<>();
		ArrayList<Plan> planes = new ArrayList<>();
		Trabajador jose = new Comercial("Jose", "Rod", "402", "829", "Jose@hotmail.com", "Jose402", "3000");
		
		Servicio internet = new Internet("I-"+Altice.getInstace().genCodeServ, "Internet", 100, 100, 100);
		Altice.getInstace().insertarServicio(internet);
		servicios.add(internet);
		
		for (Servicio servicio : servicios) {
			totalPrecio+= servicio.getPrecio();
		}
		
		Plan planInt = new Plan("P-"+Altice.getInstace().genCodePlan, "InternetFull", "Internet 100mbps", servicios, totalPrecio);
		planes.add(planInt);
		Altice.getInstace().insertarPlan(planInt);
		/*
		Cliente Ruddy = new Cliente("444", "Ruddy", "Gomez", "809", "Dorado", planes);
		Altice.getInstace().insertarCliente(Ruddy);
		Altice.getInstace().insertarTrabajador(jose);
		Altice.getInstace().realizarVenta(Ruddy.getCedula(), jose.getCedula(), planes);
		ArrayList<Factura> factura = Ruddy.getMisFacturas();
		
		for (Factura factura2 : factura) {
			System.out.println(factura2.getTotal());
		}*/
	}

}

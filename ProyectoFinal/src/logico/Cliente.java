package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Cliente implements Serializable{
	
	private String cedula;
	private String nombre;
	private String apellido;
	private String telefono;
	private String direccion;
	private Date fechaRegistro;
	private ArrayList<Plan> planes;
	private ArrayList<Factura> misFacturas;
	public Cliente(String cedula, String nombre, String apellido, String telefono, String direccion) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.planes = new ArrayList<Plan>();
		this.misFacturas = new ArrayList<Factura>();
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public ArrayList<Plan> getPlanes() {
		return planes;
	}
	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}
	public void insertPlanes(ArrayList<Plan> planes2) {
		ArrayList<Plan> planesNuevos = planes2;
		if(planesNuevos != null) {
			for (Plan plan : planesNuevos) {
				planes.add(plan);
			}
		}
		
		
	}
	
	
	

}

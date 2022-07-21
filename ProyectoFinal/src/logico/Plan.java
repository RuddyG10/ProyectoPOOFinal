package logico;

import java.util.ArrayList;
import java.util.Date;

public class Plan {
	private String codigo;
	private String nombrePlan;
	private int duracionPlan;
	private ArrayList<Servicio> servicios;
	private float totalPrecio;
	private Date fechaInicio;
	private Date fechaTermino;
	
	public Plan(String codigo, String nombrePlan, int duracionPlan, ArrayList<Servicio> servicios, float totalPrecio,
			Date fechaInicio, Date fechaTermino) {
		super();
		this.codigo = codigo;
		this.nombrePlan = nombrePlan;
		this.duracionPlan = duracionPlan;
		this.servicios = new ArrayList<>();
		this.totalPrecio = totalPrecio;
		this.fechaInicio = new Date();
		this.fechaTermino = new Date();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombrePlan() {
		return nombrePlan;
	}

	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}

	public int getDuracionPlan() {
		return duracionPlan;
	}

	public void setDuracionPlan(int duracionPlan) {
		this.duracionPlan = duracionPlan;
	}

	public ArrayList<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(ArrayList<Servicio> servicios) {
		this.servicios = servicios;
	}

	public float getTotalPrecio() {
		return totalPrecio;
	}

	public void setTotalPrecio(float totalPrecio) {
		this.totalPrecio = totalPrecio;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaTermino() {
		return fechaTermino;
	}
	
	

}

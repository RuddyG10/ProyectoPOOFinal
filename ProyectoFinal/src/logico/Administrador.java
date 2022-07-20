package logico;

public class Administrador extends Trabajador {
	
	private int experiencia;
	public Administrador(String nombre,String apellidos, String cedula, String telefono, String email, String userName,
			String password,int experiencia) {
		super(nombre,apellidos, cedula, telefono, email, userName, password);
		this.experiencia = experiencia;
	}
	
	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public void salario() {
		salario = 25000;
	}
}

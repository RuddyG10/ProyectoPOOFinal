package logico;

public class Administrador extends Trabajador {

	public Administrador(String nombre, String cedula, String telefono, String email, String userName,
			String password) {
		super(nombre, cedula, telefono, email, userName, password);
	}
	public void salario() {
		salario = 25000;
	}
}

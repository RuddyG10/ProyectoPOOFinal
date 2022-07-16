package logico;

public class Trabajador {
	protected String nombre;
	protected String Cedula;
	protected String telefono;
	protected String email;
	protected float salario;
	protected String userName;
	protected String password;
	public Trabajador(String nombre, String cedula, String telefono, String email, String userName, String password) {
		super();
		this.nombre = nombre;
		Cedula = cedula;
		this.telefono = telefono;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.salario = 0;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return Cedula;
	}
	public void setCedula(String cedula) {
		Cedula = cedula;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public float getSalario() {
		return salario;
	}
	public String getPassword() {
		return password;
	};
	public void salario() {
		salario = 0;
	}

}

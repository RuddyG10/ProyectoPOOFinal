package logico;

import java.util.Vector;

public class Trabajador {
	protected String nombre;
	protected String apellidos;
	protected String Cedula;
	protected String telefono;
	protected String email;
	protected float salario;
	protected String userName;
	protected String password;
	
	
	
	public Trabajador() {
		super();
	}

	public Trabajador(String nombre, String apellidos, String cedula, String telefono, String email, String userName, String password) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		Cedula = cedula;
		this.telefono = telefono;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.salario = 0;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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
	
	public static int verificarUserNuevo (String usuario) {
		Vector lista = mostrar();
		Trabajador obj;
		for(int i=0; i<lista.size();i++) {
			obj = (Trabajador) lista.elementAt(i);
			if(obj.getUserName().equalsIgnoreCase(usuario)){
				return i;
			}
		}
		return -1;
	}
	
	public static int verificarLogueo(String usuario, String contraseña) {
		Vector lista = mostrar();
		Trabajador obj;
		for(int i=0;i<lista.size();i++) {
			obj =(Trabajador) lista.elementAt(i);
			if(obj.getUserName().equalsIgnoreCase(usuario)&&obj.getPassword().equalsIgnoreCase(contraseña)) {
				return i;
			}
		}
		return -1;
	}
	
	public static Vector mostrar() {
		return ListaUsuario.mostrar();
	}

}

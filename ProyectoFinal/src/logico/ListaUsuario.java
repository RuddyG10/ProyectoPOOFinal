package logico;

import java.util.Vector;

public class ListaUsuario {
	private static Vector<Trabajador> datos = new Vector<Trabajador>();
	
	public  static void agregar(Trabajador obj){
		datos.addElement(obj);
	}

	public  static void eliminar(int pos) {
		datos.removeElementAt(pos);
	}
	
	public static Vector mostrar() {
		return datos;
	}
}

package SegundoEjercicio;
import java.util.List;
import java.util.ArrayList;
public class Cliente {
	//Atributos
	private String DNI;
	private String nombre;
	private String apellidos;
	private String direccion;
	private int telefono;
	//Colección en la clase Cliente de Banco, ya que un Cliente puede pertenecer a muchos bancos
	List<Banco> banco = new ArrayList<>();
	//Constructor
	public Cliente(String DNI, String nom, String ap, String dir, int tel) {
		this.DNI = DNI;
		this.nombre = nom;
		this.apellidos = ap;
		this.direccion = dir;
		this.telefono = tel;
	}
	//Métodos getters y setters
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	//Método toString
	@Override
	public String toString() {
		return "Cliente [DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ ", telefono=" + telefono +  "]";
	}
	
}

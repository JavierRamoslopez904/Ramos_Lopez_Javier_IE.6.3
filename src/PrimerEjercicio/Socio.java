package PrimerEjercicio;
import java.util.ArrayList;
import java.util.List;
public class Socio {
	//Atributos
	private String nombre;
	private String num_carnet;
	private int lista_prestamos;
	//Definimos una colección de socios, ya que un socio puede pertenecer a varias bibliotecas
	List<Socio> socios = new ArrayList<>();
	//Constructor
	public Socio(String nom, String num, int lis) {
		this.nombre = nom;
		this.num_carnet = num;
		this.lista_prestamos = lis;
	}
	//Métodos
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNum_carnet() {
		return num_carnet;
	}
	public void setNum_carnet(String num_carnet) {
		this.num_carnet = num_carnet;
	}
	public int getLista_prestamos() {
		return lista_prestamos;
	}
	public void setLista_prestamos(int lista_prestamos) {
		this.lista_prestamos = lista_prestamos;
	}
	public List<Socio> getSocios() {
		return socios;
	}
	public void setSocios(List<Socio> socios) {
		this.socios = socios;
	}
	//Método toString
	@Override
	public String toString() {
		return "Socio [nombre=" + nombre + ", num_carnet=" + num_carnet + ", lista_prestamos=" + lista_prestamos
				+ "]";
	}
}

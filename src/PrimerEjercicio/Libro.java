package PrimerEjercicio;
import java.util.List;
import java.util.ArrayList;

public class Libro {
	//Atributos
	private String titulo;
	private String autor;
	//Vamos a crear una colecci�n, ya que un libro puede pertenecer a varias bibliotecas
	List<Biblioteca> biblioteca = new ArrayList<>();
	//Constructor
	public Libro(String tit, String aut) {
		this.titulo = tit;
		this.autor = aut;
	}
	//M�todos
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public List<Biblioteca> getBiblioteca() {
		return biblioteca;
	}
	public void setBiblioteca(List<Biblioteca> biblioteca) {
		this.biblioteca = biblioteca;
	}
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + "]";
	}
	
}

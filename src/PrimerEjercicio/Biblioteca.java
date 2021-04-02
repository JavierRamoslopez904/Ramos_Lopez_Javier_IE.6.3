package PrimerEjercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
	Scanner S = new Scanner(System.in);
	// Definimos los atributos
	List<Libro> libros = new ArrayList<>();
	List<Socio> socios = new ArrayList<>();
	// Otro atributo de la clase biblioteca
	private String nombre;

	// Constructor
	public Biblioteca(String nom) {
		this.nombre = nom;
	}

	// Métodos
	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public List<Socio> getSocios() {
		return socios;
	}

	public void setSocios(List<Socio> socios) {
		this.socios = socios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// toString
	@Override
	public String toString() {
		return "Biblioteca [libros=" + libros + ", socios=" + socios + ", nombre=" + nombre + "]";
	}

	// Método para añadir libros
	public void añadirLibros() {
		String titulo;
		String autor;
		int opcion;
		int num_libros;
		try {
			System.out.println("Introduzca el número de libros que quiere añadir a la biblioteca");
			num_libros = S.nextInt();
			for (int i = 0; i < num_libros; i++) {
				System.out.println("Introduzca el nombre del titulo");
				titulo = S.next();
				System.out.println("Introduzca el nombre del autor del libro");
				autor = S.next();
				// Creamos un objeto de la clase libro para añadirlo a la colección
				Libro l = new Libro(titulo, autor);
				// Lo añadimos a la coleccion de libros dentro de la clase bibilioteca
				libros.add(l);
			}
			// Mostramos con un for each o con la api Stream el resultado del titulo y el
			// autor añadido
			System.out.println("Introduzca una opción para mostrar la información del libro añadido");
			System.out.println("1 --> Bucle forEach");
			System.out.println("2 --> Api Stream");
			opcion = S.nextInt();
			switch (opcion) {
			case 1:
				for (Libro li : libros) {
					System.out.println(li);
				}
				break;
			case 2:
				// Primero mostramos el título del libro
				System.out.println("Nombre/s de/los libro/s");
				libros.parallelStream().map(s -> s.getTitulo()).forEach(System.out::println);
				// Luego el autor del libro
				System.out.println("Nombre/s de/los autor/es");
				libros.parallelStream().map(s -> s.getAutor()).forEach(System.out::println);

				break;
			}
		} catch (Exception e) {
			System.out.println("ERROR, ha introducido un valor erróneo");
		}
	}

	// Método para añadir el socio
	public void añadirSocios() {
		int numero_socios;
		String nombre;
		String num_carnet;
		int prestamos;
		String titulo, autor;
		int opcion;
		try {
			System.out.println("Introduzca el número de socios que quiere añadir a la biblioteca");
			numero_socios = S.nextInt();
			for (int i = 0; i < numero_socios; i++) {
				System.out.println("Introduzca el nombre del socio");
				nombre = S.next();
				System.out.println("Introduzca su carnet");
				num_carnet = S.next();
				System.out.println("Introduzca el número de libros que tiene en préstamo");
				prestamos = S.nextInt();
				for (int j = 0; j < prestamos; j++) {
					System.out.println("Introduzca el título del libro");
					titulo = S.next();
					System.out.println("Introduzca el autor del libro");
					autor = S.next();
				}
				// Creamos un objeto de la clase socio para añadirlo a la colección
				Socio s = new Socio(nombre, num_carnet, prestamos);
				// Lo añadimos a la coleccion de socios dentro de la clase bibilioteca
				socios.add(s);
			}

			// Mostramos con un for each o con la api Stream el resultado del titulo y el
			// autor añadido
			System.out.println("Introduzca una opción para mostrar la información del libro añadido");
			System.out.println("1 --> Bucle forEach");
			System.out.println("2 --> Api Stream");
			opcion = S.nextInt();
			switch (opcion) {
			case 1:
				for (Socio so : socios) {
					System.out.println(so);
				}
				break;
			case 2:
				// Primero mostramos el nombre del socio
				System.out.println("Nombre del socio");
				socios.parallelStream().map(p -> p.getNombre()).forEach(System.out::println);
				// Luego mostramos su número de carnet
				System.out.println("Número de carnet");
				socios.parallelStream().map(p -> p.getNum_carnet()).forEach(System.out::println);
				// Por último mostramos el número de préstamos
				System.out.println("Número de préstamos");
				socios.parallelStream().map(p -> p.getLista_prestamos()).forEach(System.out::println);

				break;
			}
		} catch (Exception e) {
			System.out.println("ERROR, ha introducido un valor erróneo");
		}
	}

	// Método para atender petición
	public void atenderPeticion() {
		int opcion;
		int segunda_opcion;
		String titulo, carnet;
		String new_titulo, new_carnet;
		try {
			System.out.println("Introduzca el título del libro que quiera buscar");
			titulo = S.next();
			for (Libro l : libros) {
				if (l.getTitulo().equals(titulo)) {
					System.out.println("Enorhabuena, el libro " + l.getTitulo() + " se encuentra en la biblioteca");
					System.out.println("¿Desea retirarlo?");
					System.out.println("1 ---> Sí");
					System.out.println("2 ---> No");
					opcion = S.nextInt();
					switch (opcion) {
					case 1:
						System.out.println("Por favor, introduzca su carnet");
						carnet = S.next();
						for (Libro li : libros) {
							System.out.println("El libro con título " + li.getTitulo()
									+ " queda reservado para el cliente con carnet " + carnet);
						}
						break;
					case 2:
						System.out.println("¿Desea retirar otro libro?");
						System.out.println("1 ---> Sí");
						System.out.println("2 ---> No");
						segunda_opcion = S.nextInt();

						switch (segunda_opcion) {
						case 1:
							System.out.println("Introduzca el título del libro");
							new_titulo = S.next();
							for (Libro lib : libros) {
								if (lib.getTitulo().equals(titulo)) {
									for (Socio soc : socios) {
										System.out.println(
												"El libro ya está reservadop por el cliente " + soc.getNombre());
									}
								} else {
									System.out.println("Puede retirar el libro, deme su carnet porfavor");
									new_carnet = S.next();
									for (Libro libr : libros) {
										System.out.println("El libro con título " + libr.getTitulo()
												+ " queda ocupado por el cliente con carnet " + new_carnet);

									}
								}
							}
							break;
						case 2:
							System.out.println("¡¡Vuelva pronto!!");
							break;
						}
						break;
					}
				} else {
					System.out.println("Lo sentimos, el libro no se encuentra disponible en la biblioteca");
				}
			}
		} catch (Exception e) {
			System.out.println("ERROR, ha introducido un valor erróneo");
		}
	}

	// Método para borrar a un socio
	public void borrarSocio() {
		String carnet_socio;
		try {
			System.out.println("Introduzca el carnet del socio que quiere eliminar de la biblioteca");
			carnet_socio = S.next();
			for (Socio s : socios) {
				if (s.getNum_carnet().equals(carnet_socio)) {
					System.out.println("El carnet coincide con el socio llamado " + s.getNombre() + " que tiene "
							+ s.getLista_prestamos() + " libros en préstamos, que pasarán a estar disponibles");
					System.out.println("Le comunicamos señor " + s.getNombre()
							+ " que está eliminado de la lista de socios de la biblioteca");
					break;

				} else {
					System.out.println("El carnet no coincide con ningún socio de la biblioteca");
				}
			}
		} catch (Exception e) {
			System.out.println("ERROR, ha introducido algún valor erróneo");
		}
	}
}

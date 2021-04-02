
package PrimerEjercicio;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner S = new Scanner (System.in);
		Biblioteca b = new Biblioteca("El Quijote");
		int opcion;
		do {
		System.out.println("Bienvenido a la biblioteca "+b.getNombre());
		System.out.println("\t\t <----MENÚ---->");
		System.out.println("1. Añadir Libros");
		System.out.println("2. Añadir Socio");
		System.out.println("3. Atender Petición");
		System.out.println("4. Borrar Socio");
		System.out.println("0. Salir");
		System.out.println("Introduzca una opción");
		opcion = S.nextInt();
		
		switch(opcion) {
		case 1:
			b.añadirLibros();
		break;
		case 2:
			b.añadirSocios();
		break;
		case 3:
			b.atenderPeticion();
		break;
		case 4:
			b.borrarSocio();
		break;
		case 0:
			System.out.println("¡¡Vuelva cuando quiera!!");
		break;
		}
		}while(opcion != 0);
	}

}

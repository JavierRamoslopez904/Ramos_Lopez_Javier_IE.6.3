
package PrimerEjercicio;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner S = new Scanner (System.in);
		Biblioteca b = new Biblioteca("El Quijote");
		int opcion;
		do {
		System.out.println("Bienvenido a la biblioteca "+b.getNombre());
		System.out.println("\t\t <----MEN�---->");
		System.out.println("1. A�adir Libros");
		System.out.println("2. A�adir Socio");
		System.out.println("3. Atender Petici�n");
		System.out.println("4. Borrar Socio");
		System.out.println("0. Salir");
		System.out.println("Introduzca una opci�n");
		opcion = S.nextInt();
		
		switch(opcion) {
		case 1:
			b.a�adirLibros();
		break;
		case 2:
			b.a�adirSocios();
		break;
		case 3:
			b.atenderPeticion();
		break;
		case 4:
			b.borrarSocio();
		break;
		case 0:
			System.out.println("��Vuelva cuando quiera!!");
		break;
		}
		}while(opcion != 0);
	}

}

package SegundoEjercicio;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner S = new Scanner (System.in);
		Banco b = new Banco("Santander");
		int opcion;
		do {
		System.out.println("BIENVENIDO AL BANCO  :"+b.getNombre());
		System.out.println("\t Menú");
		System.out.println("1. Nuevo cliente");
		System.out.println("2. Nueva cuenta");
		System.out.println("3. Listar clientes y cuentas");
		System.out.println("4. Ingresar dinero y retirar dinero");
		System.out.println("5. Consultar saldo");
		System.out.println("6. Revisión mensual y posibilidad de cambiar dicha revisión mensual");
		System.out.println("0. Salir");
		opcion = S.nextInt();
		
		switch(opcion) {
		
		case 1:
			b.añadirCliente();
		break;
		case 2:
			b.nuevaCuenta();
		break;
		case 3:
			b.listarClientes();
		break;
		case 4:
			b.ingresarDinero();
		break;
		case 5:
			b.consultarSaldo();
		break;
		case 6:
			b.revisionMensual();
		break;
		
		}
			
		}while(opcion != 0);
}
}

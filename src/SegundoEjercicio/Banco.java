package SegundoEjercicio;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
	Scanner S = new Scanner (System.in);
	//Atributos
	private String nombre;
	//Definimos las colecciones para representar tanto a las cuentas como los clientes
	List<Cuenta> cuentas = new ArrayList<>();
	List<Cliente> clientes = new ArrayList<>();
	//Constructor
	public Banco(String nom) {
		this.nombre = nom;
	}
	//M�todos getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//M�todo toString
	@Override
	public String toString() {
		return "Banco [nombre=" + nombre + ", cuentas=" + cuentas + ", clientes=" + clientes + "]";
	}
	//Primer m�todo a�adirCliente
	public void a�adirCliente() {
		int nClientes;
		String DNI;
		String nombre;
		String apellidos;
		String direccion;
		int telefono;
		String nombre_banco;
		int opcion;
		System.out.println("�Cu�ntos clientes quiere a�adir");
		nClientes = S.nextInt();
		for(int i = 0; i < nClientes; i++) {
			try {
			System.out.println("Introduzca su DNI");
			DNI = S.next();
			System.out.println("Introduzca su nombre");
			nombre = S.next();
			System.out.println("Introduzca sus apellidos");
			apellidos = S.next();
			System.out.println("Introduzca su direcci�n");
			direccion = S.next();
		
			System.out.println("Introduzca su tel�fono");
			telefono = S.nextInt();
			nombre_banco = "Santander";
			
			Cliente c = new Cliente(DNI,nombre,apellidos,direccion,telefono);

			clientes.add(c);
		
			System.out.println("Introduzca la opci�n que quiera");
			System.out.println("1 --> forEach");
			System.out.println("2 --> ApiStream");
			opcion = S.nextInt();
			switch(opcion) {
			case 1:
			for(Cliente c1 : clientes) {
				System.out.println(c);
			}
			break;
			case 2:
			//Con este for se va a mostrar la informaci�n de los clientes.
			//Vamos a usar el parallelStream para que recorra la colecci�n m�s r�pido
			//Para mostrar la informaci�n vemos como hacerlo con la API Stream
			//1. Convertimos la colecci�n a stream con (.parallelStream) o simplemente (.Stream), que esto va a servir para
			//convertir la colecci�n clientes a flujo
			//2. Luego con el map vamos a SELECCIONAR los campos que queramos, y podemos seleccionarlo con dos opcion:
			//2.1 (Cliente::getApellidos) con el nombre de la clase y con los dos puntos hacemos referencia al m�todo getApellidos
			//2.2 (s->s.getApellidos)
			//3. Tambi�n podemos usar un filter que va a servir como para establecer condiciones y que el map, cuando nos muestre
			//lo que nosotros queramos, el filter va a condicionar el valor de ese map
			//4. Con el for each mostramos
				System.out.println("El/Los apellidos del/los cliente/s es/son : ");
				clientes
				.parallelStream()
				.map(Cliente::getApellidos)
				.forEach(System.out::println);
				System.out.println("El/Los nombre del/los cliente/s es/son : ");
				clientes
				.parallelStream()
				.map(s->s.getNombre())
				.forEach(System.out::println);
//				clientes
//				.parallelStream()
//				.map(s->s.getApellidos())
//				.forEach(System.out::println);
				System.out.println("La/Las direcci�n del/los cliente/s es/son : ");
				clientes
				.parallelStream()
				.map(s->s.getDireccion())
				.forEach(System.out::println);
				System.out.println("El/Los tel�fono del/los cliente/s es/son : ");
				clientes
				.parallelStream()
				.map(s->s.getTelefono())
				.forEach(System.out::println);
			break;
			}
			}catch(Exception e) {
				System.out.println("ERROR, ha introducido alg�n car�cter err�neo");
			}
		}
		System.out.println("WII, CLIENTE A�ADIDO");
		//Vamos a realizar un ejemplo implementando el filter
		//�Qu� nos mostrar�?
		//Empezamos poniendo lo de siempre, el nombre de la colecci�n y el parallelStream o el Stream
		//Luego en el filter hemos implementado una condici�n, que el apellido sea Jos�
		//El map, va a mostrar, el nombre, pero claro va a mostrar el nombre SI y solo SI el apellido que hemos
		//metido es "Jos�"
//		clientes
//			.parallelStream()
//			.filter(s->s.getApellidos().equals("Jos�"))
//			.map(s->s.getNombre())
//			.forEach(System.out::println);
	}
	public void nuevaCuenta() {
		double dinero;
		int opcion;
		try {
		do {
		System.out.println("INTRODUZCA UNA CANTIDAD DE DINERO. El programa se repetir� hasta que introduzca una cantidad");
		dinero = S.nextDouble();
		}while(dinero == 0);
		Banco b = new Banco("Santander");
		Cuenta c = new Cuenta(dinero,b);
		
		cuentas.add(c);
		
		System.out.println("Introduzca una opci�n para mostrar la informaci�n que le sea m�s oportuna");
		System.out.println("1 --> forEach");
		System.out.println("2 --> ApiStream");
		opcion = S.nextInt();
		switch(opcion) {
		case 1:
		//Con este for nos va a mostrar la informaci�n de la cuenta
			for(Cuenta cu : cuentas) {
				System.out.println(cu);
			}	
		break;
		case 2:
		//Usando la api stream vamos a mostrar el dinero de la nueva cuenta
			System.out.println("El dinero en su cuenta es de : ");
			cuentas
				.parallelStream()
				.map(s->s.getDinero())
				.forEach(System.out::println);
		break;
		}
		}catch(Exception e) {
			System.out.println("ERROR, ha introducido alg�n valor err�neo");
		}
	}
	public void listarClientes() {
		int opcion;
		int segunda_opcion;
		try {
		System.out.println("INTRODUZCA UNA OPCI�N");
		System.out.println("1 --> LISTAR CLIENTES");
		System.out.println("2 --> LISTAR CUENTAS");
		opcion = S.nextInt();
		switch(opcion) {
		case 1:
			System.out.println("� Por qu� m�todo quiere mostrar la informaci�n");
			System.out.println("1. --> Bucle For Each");
			System.out.println("2. --> Api Stream");
			segunda_opcion = S.nextInt();
			switch(segunda_opcion) {
			case 1:
				for(Cliente c : clientes) {
					System.out.println(c);
				}
			break;
			case 2:
				//Vamos a mostrar con la api stream la informaci�n de los clientes
				clientes
					.parallelStream()
					.map(s->s.getDNI())
					.forEach(System.out::println);
				clientes
					.parallelStream()
					.map(s->s.getNombre())
					.forEach(System.out::println);
				clientes
					.parallelStream()
					.map(s->s.getApellidos())
					.forEach(System.out::println);
				clientes
					.parallelStream()
					.map(s->s.getDireccion())
					.forEach(System.out::println);
				clientes
					.parallelStream()
					.map(s->s.getTelefono())
					.forEach(System.out::println);
			break;
			}
		break;
		case 2:
			System.out.println("� Por qu� m�todo quiere mostrar la informaci�n");
			System.out.println("1. --> Bucle For Each");
			System.out.println("2. --> Api Stream");
			segunda_opcion = S.nextInt();
			switch(segunda_opcion) {
			case 1:
				for(Cuenta cu : cuentas) {
					System.out.println(cu);
				}
			break;
			case 2:
				//Vamos a mostrar la informaci�n de la cuenta
				cuentas
					.parallelStream()
					.map(s->s.getDinero())
					.forEach(System.out::println);
			break;
			}
		break;
		}
		}catch(Exception e) {
			System.out.println("ERROR, ha introducido alg�n valor err�neo");
		}
	}
	public void ingresarDinero() {
		double dineroa�adir = 0;
		double dineroretirar;
		int opcion;
		double dinero_total;
		try {
		do {
		System.out.println("BIENVENIDO AL APARTADO 5, POR FAVOR MARQUE UNA OPCI�N");
		System.out.println("1 ---> Ingresar dinero");
		System.out.println("2 ---> Sacar dinero");
		System.out.println("3 ---> Salir de este apartado");
		opcion = S.nextInt();
		Banco b = new Banco("Santander");
		switch(opcion) {
		case 1:
			System.out.println("�Cu�nto dinero quiere a�adir a su cuenta?");
			dineroa�adir = S.nextDouble();
			
			Cuenta c1 = new Cuenta(dineroa�adir,b);
			
			cuentas.add(c1);
		//Vamos a usar la api stream para mostrar el dinero de la cuenta
		cuentas
			.stream()
			.map(s->s.getDinero())
			.forEach(System.out::println);
//			for(Cuenta c : cuentas) {
//				System.out.println(c);
//			}
		break;
		case 2:
			System.out.println("�Cu�nto dinero quiere sacar de la cuenta?");
			System.out.println("Asegurese de la cantidad a retirar sea menor a la que ha a�adido");
			dineroretirar = S.nextDouble();
			
			if(dineroretirar > dineroa�adir) {
				System.out.println("Ha querido retirar una cantidad mayor a la cantidad introducida anteriormente");
			}else {
				dinero_total = dineroa�adir - dineroretirar;
				Cuenta c = new Cuenta(dinero_total,b);
				
				cuentas.add(c);
			//Vamos a usar la api stream para mostrar el dinero retirado
			cuentas
				.stream()
				.map(s->s.getDinero())
				.forEach(System.out::println);
//				for(Cuenta cu : cuentas) {
//					System.out.println(cu);
//				}
			}
		break;
		}
		}while(opcion != 3);
		}catch(Exception e) {
			System.out.println("ERROR, ha introducido un valor err�neo");
		}
		
	}
	public void consultarSaldo() {
		String carnet;
		try {
		System.out.println("Introduzca su carnet para acceder a su cuenta");
		carnet = S.next();
		for(Cliente i : clientes) {
			if(i.getDNI().equals(carnet)) {
			//Vamos a mostrar con la api stream
				System.out.println("El dinero almacenado en su cuenta es de :");
			cuentas
				.stream()
				.map(s->s.getDinero())
				.forEach(System.out::println);
//				for(Cuenta c : cuentas) {
//					System.out.println("Su sueldo "+c.getDinero());
//				}
			}else {
				System.out.println("No tenemos sueldo asociado con su DNI, lo sentimos");
			}
		}
		}catch(Exception e) {
			System.out.println("ERROR, ha introducido alg�n valor err�neo");
		}
	}
	public void revisionMensual() {
		double interes_mensual = 0.1;
		int num_meses;
		double total_interes_mensual;
		int cambio;
		double new_comision = 0;
		double total;
		try {
		System.out.println("�Cu�ntos meses ha estado usted?");
		num_meses = S.nextInt();
		total_interes_mensual = num_meses * interes_mensual;
		
		System.out.println("La comisi�n tomar� el valor de 0.6, �desea cambiar el valor?");
		System.out.println("1 --> S�");
		System.out.println("2 --> NO");
		cambio = S.nextInt();
		
		if(cambio == 1) {
			System.out.println("Introduzca el nuevo valor de la comisi�n");
			new_comision = S.nextDouble();
		}else if(cambio == 2) {
			new_comision = 0.6;
		}
		for(Cuenta c : cuentas) {
			System.out.println(c.getDinero() + total_interes_mensual - new_comision);
		}	
		}catch(Exception e) {
			System.out.println("ERROR, ha introducido alg�n valor err�neo");
		}
	}
}

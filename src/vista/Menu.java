package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.*;
import servicio.*;
import utilidades.Utilidad;

public class Menu {

	ClienteServicio clienteServicio = new ClienteServicio();
	ArchivoServicio archivoServicio = new ArchivoServicio();
	ExportadorCsv exportadorCsv = new ExportadorCsv();
	ExportadorTxt exportarTxt = new ExportadorTxt();
	Utilidad util = new Utilidad();
	String FileName1;
	String FileName;
	Scanner scan = new Scanner(System.in);
	List<Cliente> lista = new ArrayList<>();
	int p = -1, cc = 0;

	public final void iniciarMenu() {
		String opcion = "";
		do {
			System.out.println("\n***** SISTEMA DE CLIENTES ***** ");
			System.out.println("\n1-Listar Clientes");
			System.out.println("2-Agregar Cliente");
			System.out.println("3-Editar Cliente");
			System.out.println("4-Cargar Datos");
			System.out.println("5-Exportar Datos");
			System.out.println("6-Salir");
			System.out.println("\nIngrese una opcion:");
			opcion = scan.nextLine().trim();

			switch (opcion) {
			case "1":
				util.limpiar();
				util.espera();
				this.listarClientes();
				break;
			case "2":
				util.limpiar();
				util.espera();
				this.agregarClientes();
				break;
			case "3":
				util.limpiar();
				util.espera();
				this.editarClientes();
				break;
			case "4":
				util.limpiar();
				util.espera();
				this.importarDatos();
				break;
			case "5":
				util.limpiar();
				util.espera();
				this.exportarDatos();
				break;
			case "6":
				util.limpiar();
				util.espera();
				this.terminarPrograma();
				break;
			default:
				System.out.println("Ingrese una opción válida 1-6 ");
				break;
			}

		} while (!(opcion.equals("6")));
		scan.close();

	}

	public void listarClientes() {
		clienteServicio.listarClientes();
	}

	public void agregarClientes() {

		Cliente c = new Cliente();
		
		System.out.println("\n-------------CREAR CLIENTE-------------");
		System.out.println("Ingrese RUN del Cliente: ");
		c.setRunCliente(scan.nextLine().trim());
		System.out.println("Ingrese Nombre del Cliente: ");
		c.setNombreCliente(scan.nextLine().trim());
		System.out.println("Ingrese Apellido del Cliente: ");
		c.setApellidoCliente(scan.nextLine().trim()); 
		System.out.println("Ingrese años como Cliente: ");
		c.setAniosCliente(scan.nextLine().trim());
		c.setNombreCategoria(CategoriaEnum.ACTIVO);
		System.out.println("\n---------------------------------------");

		clienteServicio.agregarClientes(c);
	}

	public void editarClientes() {

		if (clienteServicio.getListaClientes().size() == 0) {
			System.out.println("\nNo hay productos en la base de datos");
		} else {
			int opcion = 0;
			do {
				System.out.println("\n-------------EDITAR CLIENTE-------------");
				System.out.println("Seleccione qué desea hacer: ");
				System.out.println("1-Cambiar el estado del Cliente");
				System.out.println("2-Editar los datos ingresados del Cliente");
				System.out.println("Ingrese opcion: ");
				opcion = Integer.parseInt(scan.nextLine().trim());
			} while (!(opcion >= 1 && opcion <= 2));
			System.out.println("\n---------------------------------------");
			System.out.println("Ingrese RUN del Cliente: ");
			String run = scan.nextLine().trim();
			if (opcion == 1) {
				this.clienteServicio.getListaClientes().stream().forEach((cs) -> {
					if (run.equals(cs.getRunCliente())) {
						int opcionIf = 0;
						do {
							System.out.println("\n-------------Actualizando Datos del Cliente-------------");
							System.out.println("\nEl estado actual es: " + cs.getNombreCategoria());
							System.out.println("1-Si desea cambiar el estado del Cliente a Inactivo");
							System.out.println("2-Si desea mantener el estado del Cliente Activo");
							System.out.println("Ingrese opción: ");
							opcionIf = Integer.parseInt(scan.nextLine().trim());
						} while (!(opcionIf >= 1 && opcionIf <= 2));
						if (opcionIf == 1) {
							cs.setNombreCategoria(CategoriaEnum.INACTIVO);
							System.out.println("El estado del Cliente ha sido modificado con éxito");
						} else {
							cs.setNombreCategoria(CategoriaEnum.ACTIVO);
							System.out.println("El estado del Cliente ha sido modificado con éxito");
						}
						System.out.println("\n---------------------------------------");

					} else {
						System.out.println("El run ingresado no corresponde a ningun cliente de la base de datos");
					}
				});
			} else {

				this.clienteServicio.getListaClientes().stream().forEach((cs) -> {
					if (run.equals(cs.getRunCliente())) {
						System.out.println("\n-------------Actualizando Datos del Cliente-------------");
						System.out.println("\n1-RUN del Cliente: " + cs.getRunCliente());
						System.out.println("2-Nombre del Cliente: " + cs.getNombreCliente());
						System.out.println("3-Apellido del Cliente: " + cs.getApellidoCliente());
						System.out.println("4-Años del Cliente: " + cs.getAniosCliente());
						System.out.println("\n---------------------------------------");
						p = cc;
						String opc = "";
						String mod = "";
						int op = 0;

						do {
							System.out.println("\nIngrese opción a editar de los datos del cliente (1-4): ");
							opc = scan.nextLine().trim();
							op = Integer.parseInt(opc);
							switch (opc) {
							case "1": {
								System.out.println("\n-------------Actualizando estado del Cliente-------------");
								System.out.println("Ingrese nuevo RUN del Cliente:");
								mod = scan.nextLine().trim();
								cs.setRunCliente(mod);
								break;
							}
							case "2": {
								System.out.println("\nIngrese el nuevo nombre del Cliente: ");
								mod = scan.nextLine().trim();
								cs.setNombreCliente(mod);
								break;
							}
							case "3": {
								System.out.println("\nIngrese el nuevo apellido del Cliente: ");
								mod = scan.nextLine().trim();
								cs.setApellidoCliente(mod);
								break;
							}
							case "4": {
								System.out.println("\nIngrese la nueva cantidad de años: ");
								mod = scan.nextLine().trim();
								cs.setAniosCliente(mod);
								break;
							}
							default: {
								System.out.println("\nIngrese una opcion valida 1-4");
								break;
							}
							}
						} while (!(op >= 1 && op <= 4));
						clienteServicio.editarClientes(p, cs);
					}

					else {
						System.out.println("El run ingresado no corresponde a ningun cliente de la base de datos");
					}
					cc++;
				});
			}
		}
	}

	public void importarDatos() {

		FileName1 = "DBClientes.csv";
		System.out.println("---------Cargar Datos en Windows---------------");
		System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv: ");

		String ruta = this.scan.nextLine().trim();

		archivoServicio.cargarDatos(FileName1, ruta, lista);
	}

	public void exportarDatos() {
		FileName = "Clientes";
		int opcion = 0;
		if (lista.size() == 0) {
			System.out.println("No hay Clientes que exportar");
		} else {
			do {
				System.out.println("\n---------Exportar Datos-----------\n");
				System.out.println("Seleccione el formato a exportar:");
				System.out.println("1.-Formato csv");
				System.out.println("2.-Formato txt");
				System.out.println("\nIngrese una opción para exportar: ");
				opcion = Integer.parseInt(scan.nextLine().trim());
				System.out.println("\n----------------------------------\n");
			} while (!(opcion >= 1 && opcion <= 2));

			System.out.println("---------Exportar Datos en Windows---------------");
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes: ");
			String ruta = this.scan.nextLine().trim();
			System.out.println("-----------------------------------------------");

			if (opcion == 1) {
				String rutaArchivo = ruta + "\\" + FileName + ".csv";
				exportadorCsv.exportar(rutaArchivo, lista);
			} else if (opcion == 2) {
				String rutaArchivo = ruta + "\\" + FileName + ".txt";
				exportarTxt.exportar(rutaArchivo, lista);
			}
		}
	}

	public void terminarPrograma() {
		System.out.println("Abandonando el sistema...");
		System.out.println("Ha salido del sistema");
	}

}

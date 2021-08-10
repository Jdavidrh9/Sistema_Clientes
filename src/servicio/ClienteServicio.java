package servicio;

import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

public class ClienteServicio {

	List<Cliente> listaClientes = new ArrayList<Cliente>();
	Cliente cs = new Cliente();
	int v = 0;
	public ClienteServicio(List<Cliente> listaClientes) {
		super();
		this.listaClientes = listaClientes;
		this.listaClientes = new ArrayList<Cliente>();
	}

	public ClienteServicio() {
		this.listaClientes = new ArrayList<Cliente>();
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void listarClientes() {
		
		if (this.getListaClientes().size() == 0) {
			System.out.println("\nNo hay productos en la base de datos");
		} else {
			this.listaClientes.stream().forEach((cs) ->  {
				System.out.println("\n-------------DATOS DEL CLIENTE-------------");
				System.out.println("\nRUN del Cliente: " + cs.getRunCliente());
				System.out.println("Nombre del Cliente: " + cs.getNombreCliente());
				System.out.println("Apellido del Cliente: " + cs.getApellidoCliente());
				System.out.println("Años del Cliente: " + cs.getAniosCliente());
				System.out.println("Categoria del Cliente: " + cs.getNombreCategoria());
				System.out.println("\n---------------------------------------");
			});
		}
	}

	public void agregarClientes(Cliente c) {

		if (c!=null) {
		this.listaClientes.stream().forEach((cs) -> {
			if (cs.getRunCliente().equals(c.getRunCliente())) { // Si hay un cliente con el mismo run devuelve un 1
				v = 1;
			}
		});
		if (v == 1) { // Se le informa al usuario que hay un registro con el mismo run
			System.out.println("El cliente ingresado ya se encuentra registrado");
		} else { // Si no hay registro previo con ese mismo rut, crea al cliente
			this.listaClientes.add(c);
			this.setListaClientes(listaClientes);
			System.out.println("Cliente agregado con éxito");
			System.out.println(this.listaClientes);
		}}
	}

	public void editarClientes(int p, Cliente cs) {
		this.listaClientes.set(p, cs);
		this.setListaClientes(listaClientes);
		System.out.println("Datos del cliente modificados con éxito");

	}

}

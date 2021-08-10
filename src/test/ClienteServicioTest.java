package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import modelo.Cliente;
import servicio.ClienteServicio;

public class ClienteServicioTest {
	
	private ClienteServicio clienteServicio;

	@Before 
	public void setup() {
		clienteServicio = new ClienteServicio();
	}

	@Test
	public void agregarClienteTest() { 
		//Given
		Cliente c = new Cliente("2", "2", "2", "2", null);
		
		//When
		clienteServicio.agregarClientes(c);
		
		//Then
		assertTrue(c.getRunCliente().equals("2"));
	}

	@Test
	public void agregarClienteNullTest() {
		//Given
		Cliente c = null;
		
		//When
		clienteServicio.agregarClientes(c);
		
		//Then
		assertEquals(clienteServicio.getListaClientes().size(),0);
	}
}

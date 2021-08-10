package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ArchivoServicio{
	
	ClienteServicio clienteServicio = new ClienteServicio();
	
	
	public void cargarDatos(String FileN, String ruta, List<Cliente> lista) {
			
		try {
			String rutaArchivo = ruta+"\\"+FileN;
			File archivo = new File(rutaArchivo);
			FileReader fr = new FileReader(archivo);
			BufferedReader bw = new BufferedReader(fr);
			
			String linea = bw.readLine();
			Cliente c = new Cliente();
			lista.clear();
			while(linea!=null) {
				 
				String[] valores = linea.split(",");
				if (valores.length==5) {
					
					c.setRunCliente(valores[0]);
					c.setNombreCliente(valores[1]);
					c.setApellidoCliente(valores[2]);
					c.setAniosCliente(valores[3]);
					
					CategoriaEnum estado = CategoriaEnum.ACTIVO;
					
					if (valores[4].equals("ACTIVO")){
						estado = CategoriaEnum.ACTIVO;
					}else if (valores[4].equals("INACTIVO")) {
						estado = CategoriaEnum.INACTIVO;
					}
					c.setNombreCategoria(estado);
					lista.add(c);
				}
				clienteServicio.setListaClientes(lista);
				linea = bw.readLine();
			}
			
			bw.close();
			
			System.out.println("El archivo 'DBClientes.csv' se ha cargado exitosamente");
			
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no ha sido encontrado");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("El archivo no pudo ser leído");
			System.out.println(e.getMessage());
		}
	}
	
	/*public void exportar() {} 
	 * 
	 * Método optimizado através de una clase abstracta Exportador ya que su uso en esta clase carece de lógica y genera redudancia en el código
	 * 
	 * */ 
}

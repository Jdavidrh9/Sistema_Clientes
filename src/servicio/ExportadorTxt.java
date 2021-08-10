package servicio;
//import java.util.List;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ExportadorTxt extends Exportador{
	
	@Override
	public void exportar(String ruta, List<Cliente> listaClientes) {
		
		
		try {
			File fl = new File(ruta);
			FileWriter fr = new FileWriter(fl);
			BufferedWriter bw = new BufferedWriter(fr);
			
			for (Cliente cl:listaClientes) {
				
				String estado = "ACTIVO";
				if (cl.getNombreCategoria().equals(CategoriaEnum.ACTIVO)) {
					estado = "Activo";
				}else if (cl.getNombreCategoria().equals(CategoriaEnum.INACTIVO)){
					estado = "Inactivo";
				} 
				bw.write("-------------CREAR CLIENTE-------------\n");
				bw.write("\nRUN del Cliente: " + cl.getRunCliente()+"\n");
				bw.write("Nombre del Cliente: " + cl.getNombreCliente()+"\n");
				bw.write("Apellido del Cliente: " + cl.getApellidoCliente()+"\n");
				bw.write("Años del Cliente: " + cl.getAniosCliente()+"\n");
				bw.write("Categoria del Cliente: " + estado+"\n");
				bw.write("\n---------------------------------------\n");
			}
			bw.close();
			System.out.println("El archivo TXT ha sido generado exitosamente");
		} catch (IOException e) {
			System.out.println("Error al crear el archivo");
			System.out.println(e.getMessage());
		}
	}
	
}

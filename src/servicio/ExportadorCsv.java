package servicio;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.*;

public class ExportadorCsv extends Exportador{
	
	@Override
	public void exportar(String FileName, List<Cliente> listaClientes) {
		
		try {
			File fl = new File(FileName);
			FileWriter fr = new FileWriter(fl);
			BufferedWriter bw = new BufferedWriter(fr); 
			for (Cliente cl:listaClientes) {
				//Los Archivos CSV van separados por coma (,)
				
				
				String estado = "ACTIVO";
				if (cl.getNombreCategoria().equals(CategoriaEnum.ACTIVO)) {
					estado = "Activo";
				}else if (cl.getNombreCategoria().equals(CategoriaEnum.INACTIVO)){
					estado = "Inactivo";
				}
				
				bw.write(cl.getRunCliente()+","); 
				bw.write(cl.getNombreCliente()+",");
				bw.write(cl.getApellidoCliente()+",");
				bw.write(cl.getAniosCliente()+",");
				bw.write(estado);
				bw.write("\n");
			} 
			bw.close();
			System.out.println("El archivo CSV ha sido generado exitosamente");
		} catch (IOException e) {
			System.out.println("Error al crear el archivo");
			System.out.println(e.getMessage());
		}
	}
}

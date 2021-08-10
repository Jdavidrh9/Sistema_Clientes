package modelo;



public class Cliente {

	String runCliente;
	String nombreCliente;
	String apellidoCliente;
	String aniosCliente;
	CategoriaEnum nombreCategoria;
	
	
	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum nombreCategoria) {
		super();
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.aniosCliente = aniosCliente;
		this.nombreCategoria = nombreCategoria;
	}
	/**
	 * 
	 */
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	public String getRunCliente() {
		return runCliente;
	}
	public void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public String getAniosCliente() {
		return aniosCliente;
	}
	public void setAniosCliente(String aniosCliente) {
		this.aniosCliente = aniosCliente;
	}
	public CategoriaEnum getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(CategoriaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [runCliente=");
		builder.append(runCliente);
		builder.append(", nombreCliente=");
		builder.append(nombreCliente);
		builder.append(", apellidoCliente=");
		builder.append(apellidoCliente);
		builder.append(", aniosCliente=");
		builder.append(aniosCliente);
		builder.append(", nombreCategoria=");
		builder.append(nombreCategoria);
		builder.append("]");
		return builder.toString();
	}
	
	
}

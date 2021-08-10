package utilidades;

public class Utilidad {
	
	public void limpiar() {		
		for (int i=0;i<=20;i++) {
		System.out.println("");
		}
		System.out.println("\nSe ha limpiado la pantalla...");
	}

	public void espera() {
		delay(10);
	}

	static void delay(long milis) {
		try {
			for (int i = 0; i <= milis; i++) {
				System.out.println("Cargando " + i * 10 + "%...");
				Thread.sleep(milis);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

package co.edu.uniquindio.estructuras.laboratoriocolas;

import java.util.UUID;

public class Prueba {

	public static String generarUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
	
	 public static String generarIDCorto() {
	        UUID uuid = UUID.randomUUID();
	        String uuidString = uuid.toString().replace("-", "");
	        return uuidString.substring(0, 10); // Truncar a 8 caracteres
	    }

    // Ejemplo de uso
    public static void main(String[] args) {
        String idGenerado = generarUUID();
        System.out.println("UUID generado: " + idGenerado);
        
        String idGenerado2 = generarIDCorto();
        System.out.println("ID corto generado: " + idGenerado2);
    }

}

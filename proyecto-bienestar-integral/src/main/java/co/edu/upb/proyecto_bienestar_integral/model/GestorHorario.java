package co.edu.upb.proyecto_bienestar_integral.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class GestorHorario {
	
	public static String obtenerFechaYHoraActualJunta() {
		 // Obtener la fecha y hora actual
        Date fechaHoraActual = new Date();
        
        // Definir el formato de salida (sin puntos ni guiones)
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMddHHmmss");
        
        // Formatear la fecha y hora como una cadena de texto
        String fechaHoraFormateada = formato.format(fechaHoraActual);
        
        return fechaHoraFormateada;
	} // public static String obtenerFechaYHoraActualJunta() 

}

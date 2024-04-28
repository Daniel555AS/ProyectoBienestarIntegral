package co.edu.upb.proyecto_bienestar_integral.model;

import java.util.Comparator;

public class ComparadorFechaHoraOrdenes implements Comparator<Orden> {
    @Override
    public int compare(Orden o1, Orden o2) {
        // Comparación por fecha
        int comparacionFecha = o1.getFecha().compareTo(o2.getFecha());
        if (comparacionFecha != 0) {
            return comparacionFecha;
        }
        
        // Si las fechas son iguales, se compara por hora
        return o1.getHora().compareTo(o2.getHora());
    }
}

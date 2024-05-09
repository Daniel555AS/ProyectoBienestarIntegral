package co.edu.upb.proyecto_bienestar_integral.model;

import java.math.BigInteger;
import java.util.Comparator;

import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.Paciente;

public class ComparadorIdentificacionPaciente implements Comparator<Paciente> {
    @Override
    public int compare(Paciente paciente1, Paciente paciente2) {
        // Convertir las identificaciones a BigInteger
        BigInteger idPaciente1 = new BigInteger(paciente1.getIdentificacion());
        BigInteger idPaciente2 = new BigInteger(paciente2.getIdentificacion());
        
        // Comparar los números de identificación
        return idPaciente1.compareTo(idPaciente2);
    }
}

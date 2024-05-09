package co.edu.upb.proyecto_bienestar_integral;

import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.SistemaDeSalud;
import co.edu.upb.proyecto_bienestar_integral.view.*;

public class App {
    public static void main( String[] args ){
    	SistemaDeSalud.iniciarSistemaDeSalud();
    	SistemaDeSalud.iniciarEspecialidades();
        VistaInicioDeSesion vistaInicioDeSesion = new VistaInicioDeSesion();
        vistaInicioDeSesion.setVisible(true);
    } // main
} // public class App

package co.edu.upb.proyecto_bienestar_integral;

import co.edu.upb.proyecto_bienestar_integral.view.*;
import co.edu.upb.proyecto_bienestar_integral.model.SistemaDeSalud;

public class App {
    public static void main( String[] args ){
    	SistemaDeSalud.iniciarSistemaDeSalud();
    	SistemaDeSalud.iniciarEspecialidades();
        VistaInicioDeSesion vistaInicioDeSesion = new VistaInicioDeSesion();
        vistaInicioDeSesion.setVisible(true);
    } // main
} // public class App

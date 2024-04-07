package co.edu.upb.proyecto_bienestar_integral.model;

public enum TipoExamen {
	// Exámenes de Cardiología:
	ELECTROCARDIOGRAMA("Electrocardiograma", 70000,
			"Un electrocardiograma es una prueba no invasiva que registra la actividad "
					+ "\neléctrica del corazón. Se colocan electrodos en la piel del paciente para "
					+ "\nmedir la actividad eléctrica del corazón y detectar cualquier anormalidad "
					+ "\nen el ritmo cardíaco."),

	ECOCARDIOGRAFIA("Ecocardiografía", 150000,
			"La ecocardiografía es una técnica de ultrasonido "
					+ "\nque se utiliza para crear imágenes en tiempo real del corazón. Proporciona información"
					+ "\ndetallada sobre la estructura y función del corazón, incluyendo el tamaño de "
					+ "\nlas cavidades cardíacas, la función de las válvulas cardíacas y el flujo "
					+ "\nsanguíneo a través del corazón."),

	PRUEBA_DE_ESFUERZO("Prueba de Esfuerzo", 100000,
			"La prueba de esfuerzo, también conocida como ergometría o prueba de ejercicio, "
					+ "\nevalúa cómo responde el corazón durante el ejercicio físico. Se utiliza para "
					+ "\ndiagnosticar enfermedades cardíacas, evaluar la capacidad cardiovascular y "
					+ "\ndeterminar el riesgo de eventos cardiovasculares."),

	// Exámenes de Neurología:
	ELECTROENCEFALOGRAMA("Electroencefalograma", 250000,
			"El Electroencefalograma (EEG) es una prueba que registra la actividad "
					+ "\neléctrica del cerebro para diagnosticar condiciones neurológicas."),

	// Exámenes de Oftalmología:
	TONOMETRIA("Tonometría", 80000,
			"La Tonometría permite medir la presión intraocular para detectar signos de glaucoma.");

	private String nombre;
	private int costo;
	private String descripcion;

	private TipoExamen(String nombre, int costo, String descripcion) {
		this.nombre = nombre;
		this.costo = costo;
		this.descripcion = descripcion;
	}

	public int getCosto() {
		return costo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public String toString() {
		return nombre;
	}

}

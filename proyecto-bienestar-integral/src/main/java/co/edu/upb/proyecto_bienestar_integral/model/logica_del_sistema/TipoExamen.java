package co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema;

public enum TipoExamen {
	// Exámenes de Cardiología:
	ELECTROCARDIOGRAMA("Electrocardiograma", "ECG", 70000,
			"Un electrocardiograma es una prueba no invasiva que registra la actividad "
					+ "eléctrica del corazón. Se colocan electrodos en la piel del paciente para "
					+ "medir la actividad eléctrica del corazón y detectar cualquier anormalidad "
					+ "en el ritmo cardíaco."),

	ECOCARDIOGRAFIA("Ecocardiografía", "ECF", 150000,
			"La ecocardiografía es una técnica de ultrasonido "
					+ "que se utiliza para crear imágenes en tiempo real del corazón. Proporciona información "
					+ "detallada sobre la estructura y función del corazón, incluyendo el tamaño de "
					+ "las cavidades cardíacas, la función de las válvulas cardíacas y el flujo "
					+ "sanguíneo a través del corazón."),

	PRUEBA_DE_ESFUERZO("Prueba de Esfuerzo", "PF", 100000,
			"La prueba de esfuerzo, también conocida como ergometría o prueba de ejercicio, "
					+ "evalúa cómo responde el corazón durante el ejercicio físico. Se utiliza para "
					+ "diagnosticar enfermedades cardíacas, evaluar la capacidad cardiovascular y "
					+ "determinar el riesgo de eventos cardiovasculares."),

	// Exámenes de Neurología:
	ELECTROENCEFALOGRAMA("Electroencefalograma", "ELE", 250000,
			"El Electroencefalograma (EEG) es una prueba que registra la actividad "
					+ "eléctrica del cerebro para diagnosticar condiciones neurológicas."),

	TOMOGRAFIA_COMPUTARIZADA("Tomografía Computarizada", "TC", 800000,
			"La tomografía computarizada es una herramienta fundamental en neurología "
					+ "para diagnosticar una variedad de trastornos cerebrales y del sistema nervioso. "
					+ "Durante el procedimiento, el paciente se coloca en una mesa que se desliza hacia "
					+ "adentro de un escáner de forma circular. Este escáner utiliza rayos X para crear "
					+ "imágenes transversales detalladas del cerebro y la médula espinal."),

	ELECTROMIOGRAFIA("Electromiografía", "EMG", 275000,
			"La electromiografía (EMG) es una herramienta esencial en neurología para diagnosticar "
					+ "trastornos neuromusculares. Durante la prueba, se colocan electrodos en la piel o se "
					+ "insertan agujas delgadas en los músculos para registrar la actividad eléctrica mientras "
					+ "el paciente realiza movimientos específicos. Esta actividad eléctrica proporciona información"
					+ "sobre el funcionamiento de los músculos y los nervios. "),

	// Exámenes de Oftalmología:
	TONOMETRIA("Tonometría", "TON", 80000,
			"La Tonometría permite medir la presión intraocular para detectar signos de glaucoma."),

	QUERATOMETRIA("Queratometría", "QM", 65000,
			"" + "Examen para la medición de la curvatura de la córnea para evaluar la astigmatismo."),

	GONIOSCOPIA("Gonioscopia", "GPA", 70000,
			"Examen para la evaluación de la angulación de la cámara anterior"
					+ "del ojo para detectar posibles problemas de drenaje del humor acuoso, relacionados con"
					+ "el glaucoma."),

	// Exámenes de Medicina Interna:
	HEMOGRAMA("Hemograma", "HMG", 35000,
			"Examen para evaluar la cantidad y calidad de células sanguíneas, así como la función"
					+ "de órganos como el hígado y los riñones."),

	PERFIL_LIPIDICO("Perfil Lipídico", "PFL", 95000,
			"Examen para medir los niveles de colesterol total, colesterol "
					+ "HDL, colesterol LDL y triglicéridos, y evaluar el riesgo cardiovascular."),

	PERFIL_METABOLICO_BASICO("Perfil Metabólico Básico", "PFMB", 90000,
			"Para evaluar la función renal, hepática y "
					+ "electrolitos en sangre, como sodio, potasio, calcio y glucosa."),

	// Exámenes de Gastroenterología:
	COLONOSCOPIA("Colonoscopia", "COL", 230000,
			"Procedimiento que permite examinar el interior del colon y el recto para detectar "
					+ "pólipos, cáncer colorrectal, enfermedad inflamatoria intestinal "
					+ "(como la enfermedad de Crohn y la colitis ulcerosa) y otras afecciones intestinales."),

	ENDOSCOPIA_DIGESTIVA_ALTA("Endoscopia Digestiva Alta", "EGA", 275000,
			"Permite visualizar el esófago, "
					+ "el estómago y la primera parte del intestino delgado (duodeno) para diagnosticar condiciones "
					+ "como úlceras, gastritis, esofagitis, y detectar pólipos o cáncer."),

	MANOMETRIA_ESOFAGICA("Manometría Esofágica", "MNEF", 420000,
			"Examen que permite medir la presión y la coordinación de los "
					+ "músculos del esófago para evaluar trastornos como el reflujo gastroesofágico, la acalasia "
					+ "y los trastornos motores esofágicos.");

	private String nombre;
	private String abreviatura;
	private int costo;
	private String descripcion;

	private TipoExamen(String nombre, String abreviatura, int costo, String descripcion) {
		this.nombre = nombre;
		this.abreviatura = abreviatura;
		this.costo = costo;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getAbreviatura() {
		return abreviatura;
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

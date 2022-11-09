package EjercicioHospital.inicio;

public class Enfermo extends Persona {

	//Variables de instancia
	private String enfermedad;

	//Constructor
	public Enfermo(String nombre, String apellidos, String dNI, String enfermedad) {
		super(nombre, apellidos, dNI);
		this.enfermedad = enfermedad;
	}

	//Getters y setters
	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
	
	
}

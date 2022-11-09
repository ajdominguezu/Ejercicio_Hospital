package EjercicioHospital.inicio;

public class Paciente extends Persona {

	//Variables de instancia
	private String sintoma;

	//Constructor
	public Paciente(String nombre, String apellidos, String dNI, String sintoma) {
		super(nombre, apellidos, dNI);
		this.sintoma = sintoma;
	}

	//Getters y setters
	public String getSintoma() {
		return sintoma;
	}

	public void setSintoma(String sintoma) {
		this.sintoma = sintoma;
	}
	
	
	
}

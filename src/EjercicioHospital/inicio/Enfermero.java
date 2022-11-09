package EjercicioHospital.inicio;

public class Enfermero extends Persona {

	//Variables de instancia
	private String seccion;

	//Constructor
	public Enfermero(String nombre, String apellidos, String dNI, String seccion) {
		super(nombre, apellidos, dNI);
		this.seccion = seccion;
	}

	//Getters y setters
	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	
	/**
	 * Funcion para que los enfermeros devuelvan un paciente para asignar a una sala de espera
	 * @param pacientes el array de pacientes que le vamos a pasar a la funcion
	 * @return devuelve el paciente si el array no esta vacio, null en caso contrario
	 */
	public Paciente atenderPaciente(Paciente[] pacientes) {
		Paciente paciente;
		for (int i = 0; i < pacientes.length; i++) {
			if(pacientes[i]!=null) {
				paciente=pacientes[i];
				pacientes[i]=null;
				return paciente;
			}
		}
		return null;
	}
}

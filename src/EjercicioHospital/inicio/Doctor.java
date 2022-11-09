package EjercicioHospital.inicio;

import EjercicioHospital.funciones.Utils;

public class Doctor extends Persona{

	//Variables de instancia
	private String especialidad;

	//Constructor
	public Doctor(String nombre, String apellidos, String dNI, String especialidad) {
		super(nombre, apellidos, dNI);
		this.especialidad = especialidad;
	}

	//Getters y setters
	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	/**
	 * Funcion para diagnosticar a un paciente de una consulta y si esta enfermo devuelve el enfermo
	 * @param consulta Le pasamos la consulta desde donde esta el paciente y el doctor
	 * @return devolvemos al enfermo si esta enfermo y en caso contrario null
	 */
	public Enfermo diagnosticar(Consulta consulta) {
		int random=Utils.tiradaAleatoria(10);
		int randomE=Utils.tiradaAleatoria(5)-1;
		String[] enfermedades= {"Covid-19","Antrax","Cancer","Gripe aviar","Tuberculosis"};
		if(random>7) {
			if(consulta.getPaciente()!=null) {
				System.out.println("El paciente "+consulta.getPaciente().getNombre()
						+" diagnosticado por el Doctor "+consulta.getDoctor().getNombre()+" esta grave");
				
				Enfermo enfermo = new Enfermo(consulta.getPaciente().getNombre(),consulta.getPaciente().getApellidos(),
						consulta.getPaciente().getDNI(),enfermedades[randomE]);
				consulta.setPaciente(null);
				return enfermo;
			}else {
				return null;
			}
			
		}else {
			return null;
		}
	}
}

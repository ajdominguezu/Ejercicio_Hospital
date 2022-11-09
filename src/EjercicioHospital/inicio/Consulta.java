package EjercicioHospital.inicio;

public class Consulta {

	//Variables de instancia
	private Doctor doctor;
	private Paciente paciente;
	
	//Constructor
	public Consulta(Doctor doctor, Paciente paciente) {
		super();
		this.doctor = doctor;
		this.paciente = paciente;
	}
	
	public Consulta(Doctor doctor) {
		super();
		this.doctor = doctor;
	}

	//Getters y setters
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
	
}

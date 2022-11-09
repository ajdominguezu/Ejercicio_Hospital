package EjercicioHospital.inicio;

import EjercicioHospital.funciones.Utils;

public class Hospital implements FicharHospital{
	private String nombre;
	private Paciente[] salaEspera;
	private Enfermo[] habitaciones;
	private Consulta[] consultas;
	private Enfermero[] enfermeros;
	private Doctor[] doctores;

	public Hospital(String nombre) {
		super();
		this.nombre = nombre;
	}

	public static void main(String[] args) {
		Hospital hospital = new Hospital("Virgen del Rocio");
		hospital.crearEstructuraHospital();
		hospital.crearPersonal();
		hospital.crearPacientes();
		System.out.println("Hospital "+hospital.nombre);
		System.out.println("=====================");
		hospital.FicharDoctoresEntrada();
		hospital.FicharEnfermerosEntrada();
		System.out.println("=====================\n");
		
		hospital.iniciarHospital();
		
		System.out.println("\n=====================");
		hospital.FicharDoctoresSalida();
		hospital.FicharEnfermerosSalida();
		System.out.println("=====================");
		

	}
	/**
	 * Funcion para hacer funcionar al hospital.
	 */
	private void iniciarHospital() {
		//Asignamos los pacientes a la consulta
		int pacientesSala=salaEspera.length;//Para llevar la cuenta de cuantos pacientes quedan en la sala de espera
		int aleatorioEnfermero=Utils.tiradaAleatoria(2)-1;//Para que un enfermero aleatorio lleve al paciente a la consulta
		while(pacientesSala!=0) {
		for (Consulta consulta : consultas) {
			if(consulta.getPaciente()==null) {
				Paciente pacienteActual1=enfermeros[aleatorioEnfermero].atenderPaciente(salaEspera);//Asignamos el atenderPaciente a paciente actual
				if(pacienteActual1!=null) {
					consulta.setPaciente(pacienteActual1);
					pacientesSala-=1;
					
				}
			}
		}

		
		//Diagnosticamos a todos los pacientes de las consultas
		boolean full=false;
		String nombreEnfermo="";
		for (Consulta consulta : consultas) {
			Enfermo enfermoActual = consulta.getDoctor().diagnosticar(consulta);
			if(enfermoActual!=null) {//Hemos visto que esta enfermo con lo que asignamos a una habitacion vacia
				for (int i = 0; i < habitaciones.length; i++) {
					if (habitaciones[i]==null) {
						habitaciones[i]=enfermoActual;
						
						break;
					}else if(habitaciones[habitaciones.length-1]!=null) {
						full=true;
						nombreEnfermo=enfermoActual.getNombre();
					}
				}
				
			}
		}
		if (full) {
			System.out.println("!!!No quedan habitaciones disponibles, se trasladara a "+nombreEnfermo
			+" a otro Hospital");
		}
		}
		//Mostramos por pantalla los el array de habitaciones con los enfermos
		for (int i = 0; i < habitaciones.length; i++) {
			System.out.println("=====================");
			System.out.println("Habitacion numero "+(i+1)+": ");
			if (habitaciones[i]!=null) {
				System.out.println("Nombre: "+habitaciones[i].getNombre());
				System.out.println("Enfermedad: "+habitaciones[i].getEnfermedad());
			}else {
				System.out.println("Habitacion vacía");
			}
			
		}
	}
	
	
	/**
	 * Funcion para crear la estructura principal del hospital
	 */
	private void crearEstructuraHospital() {
		salaEspera=new Paciente[4];
		consultas=new Consulta[2];
		habitaciones=new Enfermo[3];
		
		
	}
	
	/**
	 * Funcion para crear el personal del hospital y asignar los doctores a las consultas.
	 */
	private void crearPersonal() {
		enfermeros=new Enfermero[2];
		doctores=new Doctor[2];
		
		enfermeros[0]=new Enfermero("Pepe","Ap1","62315611D","Seccion1");
		enfermeros[1]=new Enfermero("Juan","Ap1","83334870M","Seccion2");
		
		doctores[0]=new Doctor("Francisco","Ap1","35812762Z","Neurologia");
		doctores[1]=new Doctor("Jose","Ap1","44925617Q","Oftalmologia");
		
		consultas[0]=new Consulta(doctores[0]);
		consultas[1]=new Consulta(doctores[1]);
	}
	
	/**
	 * Funcion que crea los pacientes directamente en la sala de espera
	 */
	private void crearPacientes() {
		salaEspera[0]=new Paciente("Maria","Ap1","15317976E","Dolor de cabeza");
		salaEspera[1]=new Paciente("Alejandro","Ap1","31524280C","Malestar general");
		salaEspera[2]=new Paciente("Daniel","Ap1","43252993K","Manchas raras en la piel");
		salaEspera[3]=new Paciente("Jorge","Ap1","13006623P","Dolor de cuello");
	}

	/**
	 * Funcion para que los doctores fichen a la entrada del hospital
	 */
	@Override
	public void FicharDoctoresEntrada() {
		for (Doctor doctor : doctores) {
			System.out.println("El doctor "+doctor.getNombre()+" ha fichado a la entrada");
		}
		
	}

	/**
	 * Funcion para que los doctores fichen a la salida del hospital
	 */
	@Override
	public void FicharDoctoresSalida() {
		for (Doctor doctor : doctores) {
			System.out.println("El doctor "+doctor.getNombre()+" ha fichado a la salida");
		}
		
	}

	/**
	 * Funcion para que los enfermeros fichen a la entrada del hospital
	 */
	@Override
	public void FicharEnfermerosEntrada() {
		for (Enfermero enfermero: enfermeros) {
			System.out.println("El enfermero "+enfermero.getNombre()+" ha fichado a la entrada");
		}
		
	}

	/**
	 * Funcion para que los enfermeros fichen a la salida del hospital
	 */
	@Override
	public void FicharEnfermerosSalida() {
		for (Enfermero enfermero: enfermeros) {
			System.out.println("El enfermero "+enfermero.getNombre()+" ha fichado a la salida");
		}
		
	}
}

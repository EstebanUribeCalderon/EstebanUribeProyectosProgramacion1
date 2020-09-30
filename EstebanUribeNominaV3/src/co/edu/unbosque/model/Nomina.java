package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ArchivoNomina;


public class Nomina{
	
	private ArchivoNomina archivo;
	private double[] salario;
	
	public Nomina() {
		archivo = new ArchivoNomina();
		salario = new double[26];
	}
	
	public void procesarNomina() {
		archivo.leerArchivo();
		salario = archivo.getSalario();
		
		int i = 0;
		double retención = 0.0;
		double sueldoNeto;
		salario = archivo.getSalario();
		
		for(i=0; i<salario.length; i++ ) {
		
		if(salario[i]<=2000.0) {
			retención = 0.1;
		}
		if(salario[i]>2000.0 && salario[i]<=5000.0) {
			retención = 0.15;
		}
		if(salario[i]>5000.0) {
			retención = 0.2;
		}
		sueldoNeto = salario[i] - (salario[i] * retención);
		System.out.println(sueldoNeto);
		
		
		}
		
	}
	
}




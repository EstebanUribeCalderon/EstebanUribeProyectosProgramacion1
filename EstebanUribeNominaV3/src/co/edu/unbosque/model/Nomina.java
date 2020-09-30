package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ArchivoNomina;


public class Nomina{
	
	private ArchivoNomina archivo;
	private double[] salario;
	private String[] documento;
	
	public Nomina() {
		archivo = new ArchivoNomina();
		salario = new double[26];
		documento = new String[26];
	}
	
	public String procesarNomina() {
		archivo.leerArchivo();
		salario = archivo.getSalario();
		
		int i = 0;
		double retención = 0.0;
		double sueldoNeto;
		String nombreNomina = "";
		String data;
		salario = archivo.getSalario();
		documento = archivo.getDocumento();
		
		for(i=0; i<salario.length; i++ ) {
		
		if(salario[i]<=2000.0) {
			retención = 0.1;
			nombreNomina = "Nomina1";
		}
		if(salario[i]>2000.0 && salario[i]<=5000.0) {
			retención = 0.15;
			nombreNomina = "Nomina2";
		}
		if(salario[i]>5000.0) {
			retención = 0.2;
			nombreNomina = "Nomina3";
		}
		sueldoNeto = salario[i] - (salario[i] * retención);
		data = documento[i] + " , " + sueldoNeto;
		System.out.println(data);
		
		archivo.escribirArchivo(data, nombreNomina);
		
		
		
		}
		return "";
	}

	public ArchivoNomina getArchivo() {
		return archivo;
	}

	public void setArchivo(ArchivoNomina archivo) {
		this.archivo = archivo;
	}

	public double[] getSalario() {
		return salario;
	}

	public void setSalario(double[] salario) {
		this.salario = salario;
	}

	public String[] getDocumento() {
		return documento;
	}

	public void setDocumento(String[] documento) {
		this.documento = documento;
	}
	
}




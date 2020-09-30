package co.edu.unbosque.model.persistence;

import java.io.*;

public class ArchivoNomina {
	
	private String archivoData;
	private String nomina1;
	private String nomina2;
	private String nomina3;
	private String[] documento;
	private String[] nombre;
	private double[] salario;
	private int i;
	
	public ArchivoNomina() {
		documento = new String[26];
		nombre = new String[26];
		salario = new double[26];
		i = 0;
		archivoData = "./data/datosprincipales.csv";
		nomina1 = "./data/nomina1.txt";
		nomina2 = "./data/nomina2.txt";
		nomina3 = "./data/nomina3.txt";
		
	}
	

		public String leerArchivo() {
		
		String linea = "";
		
		File f = new File(this.archivoData); 
		
		try {
			FileReader fr = new FileReader(f);
			//BufferedReader br = new BufferedReader(fr);
			BufferedReader br = new BufferedReader (new InputStreamReader (new FileInputStream(f), "UTF-8")); 
			linea = br.readLine();  
			linea = linea.replace( "","");
			linea = linea.replace( "Â","");
			linea = linea.replace( ";"," ");
			
			System.out.println(linea+"\n");
			
			
			while (linea != null) {    
				linea = br.readLine();
				
				if(linea != null) {
					
					String[] file = linea.split(";");
					
					documento[i] = file[0].replace(" ", "");
					nombre[i] = file[1].replace("  ", "").replace(" ", "");
					salario[i] = Double.parseDouble(file[2]);
					
					System.out.println(documento[i] + " " + nombre[i] + " "  + salario[i] );
					
					i++;
				}
			}
			br.close();
		} 
		catch (IOException e) {
			return null;
		}
		return "";
	}
		public int escribirArchivo(String dato, String dato1, String dato2) {
			
			File f = new File(this.nomina1); // f-> carga el archivo
			
			try {
				FileWriter fw = new FileWriter(f); // fr-> Crea el flujo hacia f
				PrintWriter pw = new PrintWriter(fw); //pw-> Permite la escritura en el archivo
				
				pw.println(dato); //se escribe el contenido del parámetro dato en el archivo
				
				fw.close();
				
			} catch (IOException e) {
				return -1;
			} 
			
			return 0;
		}


		public String getArchivoData() {
			return archivoData;
		}


		public void setArchivoData(String archivoData) {
			this.archivoData = archivoData;
		}


		public String[] getDocumento() {
			return documento;
		}


		public void setDocumento(String[] documento) {
			this.documento = documento;
		}


		public String[] getNombre() {
			return nombre;
		}


		public void setNombre(String[] nombre) {
			this.nombre = nombre;
		}


		public double[] getSalario() {
			return salario;
		}


		public void setSalario(double[] salario) {
			this.salario = salario;
		}
		
}

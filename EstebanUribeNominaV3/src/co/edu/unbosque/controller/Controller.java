package co.edu.unbosque.controller;

import co.edu.unbosque.model.Nomina;
import co.edu.unbosque.view.View;

public class Controller {
	
	private View gui;
	private Nomina m;
	
	public Controller() {
		m = new Nomina();
		gui = new View();
		
		funcionar();
		
		
	}


	private void funcionar() {
		m.procesarNomina();
		
		
	}
	

}

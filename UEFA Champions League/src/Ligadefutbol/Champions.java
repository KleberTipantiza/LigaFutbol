package Ligadefutbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Champions {

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	
	// Estructura empleando excepciones personalizadas
	try {
	System.out.println("LA CHAMPIOOOOONS!!!");
	System.out.println("El torneo del deporte mas hermoso del planeta inicia!!!");
	System.out.println("Selecciona la etapa del torneo: 1 = Octavos, 2 = Cuartos, 3 = Semifinales, 4 = Final");
	char etapa = scanner.nextLine().charAt(0);
	
	// Menu de seleccion del torneo deseada
	int equiposEnJuego;
	switch (etapa) {
		case '1': 
			equiposEnJuego = 16;
			break;
		case '2' : 
			equiposEnJuego = 8;
			break;
		case '3' : 
			equiposEnJuego = 4;
			break;
		case '4' :
			equiposEnJuego = 2;
			break;
		default: 
			throw new EtapaInvalidaException("La etapa ingresada es invalida, intentelo nuevamente"); // Excepcion para verificar que la etapa seleccionada sea valida
	}
	
	// Ingresar el nombre de los equipos en una lista
	List<String> equipos = new ArrayList<>();
	System.out.println("Ingrese los " + equiposEnJuego + " equipos participantes");
	for (int i = 0; i < equiposEnJuego; i++) {
		System.out.print("Equipo " + (i +1) + ":");
		String equipo = scanner.nextLine();
		//equipos.add(scanner.nextLine());
		
		// Excepcion para que el nombre no tenga numeros
		if (!equipo.matches("[a-zA-Z]+")) {
			throw new NombreEquipoInvalidoException("El nombre del equipo solo debe contener letras");
		}
		
		equipos.add(equipo);
		
	}
	
	// Instancia de la clase sorteo y llamado al metodo de sorteo con rrecursividad
	Sorteo sorteo = new Sorteo();
	System.out.println("\nSorteando los enfrentamientos");
	sorteo.realizarSorteo(equipos, etapa);
	
	} catch (EtapaInvalidaException | NombreEquipoInvalidoException e) {
		System.out.println("Error: " + e.getMessage());
		
	} 
	
	}
}
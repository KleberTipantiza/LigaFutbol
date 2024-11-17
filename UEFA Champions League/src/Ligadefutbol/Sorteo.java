package Ligadefutbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sorteo {

	private Random random;
	
	public Sorteo() {
		this.random = new Random();
	}
	
	// Metodo para realizar el sorteo usando recursividad 
	public void realizarSorteo(List<String> equipos, char etapa) {
		
		//Mostrar la etapa en la que se ubica 
		switch (etapa) {
		case '1':
			System.out.println("\nOctavos de final");
			break;
		case '2':
			System.out.println("\nCuartos de final");
			break;
		case '3':
			System.out.println("\nSemifinales de final");
			break;
		case '4':
			System.out.println("\nFinalisima");
			break;
		default:
			System.out.println("Etapa desconocida");
		}
		
		
		// Si queda solo un equipo el sorteo termina
		if(equipos.size() == 1) {
			System.out.println("El campeon de la UEFA Champions League es : " + equipos.get(0) + "!!!!!");
			return;
		}
	

	// Mezclar equipos aleatoriamente
	Collections.shuffle(equipos);
	
	// Mostrar los enfrentamientos 
	System.out.println("\nEnfrentamientos: ");
	List<String> ganadores = new ArrayList<>();
	for (int i = 0; i < equipos.size(); i += 2) {
		String  competidor = equipos.get(i);
		String oponente = equipos.get(i + 1);
		
		System.out.println("Partido: " + competidor + " vs " + oponente);
		
		//Determinar ganador de manera aleatoria
		String ganador = random.nextBoolean() ? competidor : oponente;
		System.out.println("El ganador del partido es: " + ganador);
		ganadores.add(ganador);
		}
	
	//Determinar la siguiente etapa del torneo
	char siguienteEtapa;
	if (etapa == '1') {
	    siguienteEtapa = '2'; // Octavos a Cuartos
	} else if (etapa == '2') {
	    siguienteEtapa = '3'; // Cuartos a Semifinales
	} else if (etapa == '3') {
	    siguienteEtapa = '4'; // Semifinales a Final
	} else {
		System.out.println("\nEl campeon de la UEFA Champions League es : " + equipos.get(0) + "!!!!!");
	    return; // Finaliza el torneo
	}
	
	// Llamar recursivamente
	realizarSorteo(ganadores, siguienteEtapa);
	
	}
	
	
}

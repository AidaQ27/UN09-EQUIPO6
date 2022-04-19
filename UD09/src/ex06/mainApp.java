package ex06;

import java.util.ArrayList;
import java.util.Hashtable;

public class mainApp {

	public static void main(String[] args) {
		// Instanciamos pelicula
		Pelicula pelicula = new Pelicula("Spiderwoman", 132, 16, "Jhon Doe");
		
		// Instanciamos cine
		Cine cine = new Cine(pelicula);
		cine.crearAsientos();

		// Generamos los espectadores
		ArrayList<Espectador> espectadores = generarEspectadores(random(72, 72));
		System.out.println("Espectadores que NO entran en la Sala:\n");
		for (int i = 0; i < espectadores.size(); i++) {
			Espectador espectador = espectadores.get(i);
			
			// Comprobar si el espectador tiene la edad minima para ver la pelicula
			// Comprobar si tiene dinero para la entrada
			
			boolean tieneEdadMin = espectador.validarEdad(pelicula.getEdadMin());
			boolean tieneDinero = espectador.validarDinero(cine.getPrecioEntrada());
			if (tieneEdadMin && tieneDinero) {
				if (cine.comprobarAsientoLibre()) { // Asignar asiento si es true
					asignarAsiento(cine.getAsientos(), espectador);
				
				} else {
					System.out.println("La Sala esta completa");
				}
			} else {
				
				System.out.println(espectador.getNombre() + " tiene " + espectador.getEdad() + " a�os y "
						+ espectador.getDinero() + "�");
				if (!tieneEdadMin) {
					System.out.println("No tiene la edad para entrar.");
				}
				if (!tieneDinero) {
					System.out.println("No tiene suficiente dinero.");
				}
				System.out.println("");
			}

		}

		// Mostrar sala
		cine.mostrarSala();

	}

	/**********************************************
	 * /** Genera una cantidad de espectadores
	 * 
	 * @param numeroEspectadores
	 * @return
	 */
	public static ArrayList<Espectador> generarEspectadores(int numeroEspectadores) {
		ArrayList<Espectador> espectadores = new ArrayList<Espectador>();

		// Generar un numero de espectadores, con dinero, edad y nombre
		for (int i = 0; i < numeroEspectadores; i++) {
			String nombreEspectador = generarNombreApellido();
			int edad = random(5, 95);
			int dinero = random(3, 10);
			espectadores.add(new Espectador(nombreEspectador, edad, dinero));
		}

		return espectadores;

	}

	/**
	 * Generar un numero aleatorio entre un minimo y un maximo
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public static int random(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	/**
	 * Generar un nombre para Espectador
	 * 
	 * @return
	 */
	public static String generarNombreApellido() {
		String[] nombres = { "Pepe", "Juan", "Maria", "Isabel", "Carlos", "David", "Cristina" };
		String[] apellido = { "Sanchez", "Perez", "Gallego", "Marin", "Martinez", "Collado", "Marquez" };

		String nombreCompleto = nombres[random(0, 6)] + " " + apellido[random(0, 6)];

		return nombreCompleto;
	}

	/**
	 * Asignar asiento
	 * @param asientos
	 * @param espectador
	 */
	public static void asignarAsiento(ArrayList<Asiento> asientos, Espectador espectador) {
		Hashtable<Asiento, Espectador> mapaAsientoEspectador = new Hashtable<Asiento, Espectador>();

		boolean asignado = false;
		while (!asignado) {
			Asiento asiento = asientos.get(random(0, 72));

			if (asiento.getDisponible()) {
				mapaAsientoEspectador.put(asiento, espectador);
				asiento.setDisponible(false);
				asignado = true;
			}
		}

	}
}
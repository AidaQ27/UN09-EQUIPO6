package ex06;

import java.util.ArrayList;

public class mainApp {

	public static void main(String[] args) {
		Pelicula pelicula = new Pelicula("Spiderwoman", 132, 16, "Director");
		System.out.println(pelicula);
		Cine cine = new Cine(pelicula);
		cine.crearAsientos();

		// Generamos los espectadores
		ArrayList<Espectador> espectadores = generarEspectadores(random(20, 64));
		for (int i = 0; i < espectadores.size(); i++) {
			Espectador espectador = espectadores.get(i);
			// Comprobar si el espectador tiene la edad minima para ver la pelicula
			// Comprobar si tiene dinero para la entrada
			boolean tieneEdadMin = espectador.validarEdad(pelicula.getEdadMin());
			boolean tieneDinero = espectador.validarDinero(cine.getPrecioEntrada());
			if (tieneEdadMin && tieneDinero) {
				asignarAsiento(cine.getAsientos(),espectador);
			}
		}

	}

	/**********************************************/

	/**
	 * Genera una cantidad de espectadores
	 * 
	 * @param numeroEspectadores
	 * @return
	 */
	public static ArrayList<Espectador> generarEspectadores(int numeroEspectadores) {
		ArrayList<Espectador> espectadores = new ArrayList<Espectador>();

		// Generar un numero de espectadores
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
		String[] apellido = { "Sanchez", "Perez", "Vlad", "Marin", "Martinez", "Collado", "Marquez" };

		String nombreCompleto = nombres[random(0, 6)] + apellido[random(0, 6)];

		return nombreCompleto;
	}
	
	public static void asignarAsiento(ArrayList<Asiento>asientos, Espectador espectador) {
//		HashArray<Asiento, Espectador>
	}

}

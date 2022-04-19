package ex06;

public class mainApp {

	public static void main(String[] args) {
		// Instanciamos la pelicula
		Pelicula pelicula = new Pelicula("Spiderwoman", 132, 16, "Jhon Doe");

		// Instanciamos cine
		Cine cine = new Cine(pelicula);

		// Creamos los asientos y los guardamos en un ArrayList de asientos
		cine.crearAsientos();

		/*
		 * Itera cada espectador, comprueba si puede entar a ver la pelicula y le asigna
		 * un asiento
		 */
		cine.colocarAsiento();

		/*
		 * Mostrar el mapa del cine con los asientos ocupados y disponibles
		 */
		cine.mostrarSala();

		/*
		 * Mostrar el espectador con el asiento asignado
		 */
		cine.mostrarEspectadorAsiento();

	}

}
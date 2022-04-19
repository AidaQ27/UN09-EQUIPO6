package ex06;

import java.util.ArrayList;
import java.util.Hashtable;

public class Cine {

	// Atributos de la clase Cine
	private Pelicula pelicula;
	private int precioEntrada;
	private ArrayList<Asiento> asientos;
	private int asientosOcupados;
	private ArrayList<Espectador> espectadores;
	private Hashtable<Asiento, Espectador> mapaAsientoEspectador;

	// Constructor
	public Cine(Pelicula pelicula) {
		this.mapaAsientoEspectador = new Hashtable<Asiento, Espectador>();
		this.pelicula = pelicula;
		this.precioEntrada = 6;
		this.asientos = new ArrayList<Asiento>(); // Crea un array list para los asientos
		this.asientosOcupados = 0;
		this.espectadores = generarEspectadores(Helpers.random(20, 64));

	}

	// Getters Setters
	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public int getPrecioEntrada() {
		return precioEntrada;
	}

	public void setPrecioEntrada(int precioEntrada) {
		this.precioEntrada = precioEntrada;
	}

	public ArrayList<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(ArrayList<Asiento> asientos) {
		this.asientos = asientos;
	}

	public int getAsientosOcupados() {
		return this.asientosOcupados;
	}

	public void setAsientosOcupados(int asientosOcupados) {
		this.asientosOcupados = asientosOcupados;
	}

	/**
	 * @return the espectadores
	 */
	public ArrayList<Espectador> getEspectadores() {
		return espectadores;
	}

	/**
	 * @param espectadores the espectadores to set
	 */
	public void setEspectadores(ArrayList<Espectador> espectadores) {
		this.espectadores = espectadores;
	}

	/**
	 * @return the mapaAsientoEspectador
	 */
	public Hashtable<Asiento, Espectador> getMapaAsientoEspectador() {
		return mapaAsientoEspectador;
	}

	/**
	 * @param mapaAsientoEspectador the mapaAsientoEspectador to set
	 */
	public void setMapaAsientoEspectador(Hashtable<Asiento, Espectador> mapaAsientoEspectador) {
		this.mapaAsientoEspectador = mapaAsientoEspectador;
	}

	/**
	 * Crear Asientos
	 */
	public void crearAsientos() {

		char letraAsiento = 64; // 65 = 'A'

		for (int x = 0; x < 8; x++) { // for por cada fila
			letraAsiento++;
			for (int y = 0; y < 9; y++) { // for por cada columna
				Asiento asiento = new Asiento(letraAsiento, y + 1);
				this.asientos.add(asiento);

			}

		}

	}

	/**
	 * Metodo para mostrar asientos libres y ocupados
	 */
	public void mostrarSala() {

		// Printar la pelicula
		System.out.println("___________________________________");
		System.out.println(this.pelicula + "\n");

		// Printar los asientos
		for (int i = 1; i <= this.asientos.size(); i++) {
			Asiento asiento = asientos.get(i - 1);
			// Printar los asientos en consola
			// Si el asiento esta ocupado imprimir una "X"
			if (asiento.getDisponible()) {
				System.out.print("|" + asiento.getFila() + String.valueOf(asiento.getColumna()) + "| ");
			} else {
				System.out.print("|XX| ");
			}

			// Cada 8 columnas printar salto de linea
			if (i % 9 == 0) {
				System.out.println("\n");
			}

		}

	}

	public void mostrarEspectadores() {
		System.out.println();
	}

	/**
	 * Sumar al total de asientos ocupados al asignar asiento
	 */
	public void sumarAsientoOcupado() {
		this.asientosOcupados++;

	}

	/**
	 * Metodo para comprobar si hay asientos libres, segun el total de. Asientos(72)
	 * 
	 * @return
	 */
	public boolean comprobarAsientoLibre() {

		if (this.asientosOcupados < 72) {
			return true;
		}
		return false;

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
			String nombreEspectador = Espectador.generarNombreApellido();
			int edad = Helpers.random(5, 95);
			int dinero = Helpers.random(3, 10);
			espectadores.add(new Espectador(nombreEspectador, edad, dinero));
		}

		return espectadores;

	}

	public boolean comprobarEspectador(Espectador espectador) {
		// Comprobar si el espectador tiene la edad minima para ver la pelicula
		// Comprobar si tiene dinero para la entrada
		boolean tieneEdadMin = espectador.validarEdad(this.pelicula.getEdadMin());
		boolean tieneDinero = espectador.validarDinero(this.precioEntrada);

		boolean entrar = true;
		String motivo = "";

		if (!tieneDinero) {
			motivo += "No tiene suficiente dinero.";
			entrar = false;
		}

		if (!tieneEdadMin) {
			motivo += "No tiene la edad para entrar.";
			entrar = false;
		}
		if (entrar) {
			System.out.println(espectador.getNombre() + " tiene " + espectador.getEdad() + " años y "
					+ espectador.getDinero() + "€. " + "Ha entrado.");

		} else {
			System.out.println(espectador.getNombre() + " tiene " + espectador.getEdad() + " años y "
					+ espectador.getDinero() + "€. " + motivo);
		}
		return entrar;
	}

	public void colocarAsiento() {
		for (int i = 0; i < espectadores.size(); i++) {
			Espectador espectador = espectadores.get(i);

			// Comprobar si el espectador tiene la edad minima para ver la pelicula
			// Comprobar si tiene dinero para la entrada

			if (this.comprobarEspectador(espectador)) {
				if (this.comprobarAsientoLibre()) { // Asignar asiento si es true
					asignarAsiento(this.getAsientos(), espectador);

				} 
//				else {
//					System.out.println("La Sala esta completa");
//				}

			}
		}
	}

	/**
	 * Asignar asiento
	 * 
	 * @param asientos
	 * @param espectador
	 */
	public void asignarAsiento(ArrayList<Asiento> asientos, Espectador espectador) {

		boolean asignado = false;
		while (!asignado) {
			Asiento asiento = asientos.get(Helpers.random(0, 72));

			if (asiento.getDisponible()) {
				this.mapaAsientoEspectador.put(asiento, espectador);
				asiento.setDisponible(false);
				asignado = true;
			}
		}

	}

	/**
	 * Mostrar todos los
	 */
	public void mostrarEspectadorAsiento() {
		for (Asiento i : this.mapaAsientoEspectador.keySet()) {
			System.out.println("Asiento: " + i.getColumna() + i.getFila() + " esta sentado: "
					+ mapaAsientoEspectador.get(i).getNombre());
		}
	}

}

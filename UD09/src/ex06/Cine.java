package ex06;

import java.util.ArrayList;

public class Cine {

	// Atributos de la clase Cine
	private Pelicula pelicula;
	private int precioEntrada;
	private ArrayList<Asiento> asientos;
	private int asientosOcupados;

	// Constructor
	public Cine(Pelicula pelicula) {
		this.pelicula = pelicula;
		this.precioEntrada = 6;
		this.asientos = new ArrayList<Asiento>();
		this.asientosOcupados = 0;

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

}

package ex06;

import java.util.ArrayList;

public class Cine {

	// Atributos de la clase Cine
	private Pelicula pelicula;
	private int precioEntrada;
	private ArrayList<Asiento> asientos;

	// Constructor
	public Cine(Pelicula pelicula) {
		this.pelicula = pelicula;
		this.precioEntrada = 6;
		this.asientos = new ArrayList<Asiento>();	

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

	// Metodo para
	public void crearAsientos() {

		char letraAsiento = 64; // 65 = 'A'

		for (int x = 0; x < 8; x++) { // for por cada fila
			letraAsiento++;
			for (int y = 0; y < 9; y++) { // for por cada columna
				Asiento asiento = new Asiento(letraAsiento, y + 1);
				this.asientos.add(asiento);
				System.out.print(asiento.getFila() + String.valueOf(asiento.getColumna()) + " ");
				if (y == 8) {
					System.out.println("\n");
				}
			}

		}
		
	}

}

package ex06;

public class Asiento {

	// Attributes
	private char columna;
	private int fila;
	private boolean disponible;

	// Constructor
	public Asiento(char columna, int fila) {
		this.columna = columna;
		this.fila = fila;
		this.disponible = true;

	};

	// Getter Setter disponibilidad del asiento
	public boolean isDisponible() {
		return this.disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	public String toString() {
		return columna + " " + fila;
//		return "Numero asiento: " + columna + " " + fila;
	}
	
	public char getColumna() {
		return columna;
	}

	public void setColumna(char columna) {
		this.columna = columna;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	
}

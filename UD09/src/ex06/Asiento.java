package src.ex06;

public class Asiento {

	// Attributes
	private char columna;
	private int fila;
	private boolean disponible;

	// Constructor
	public Asiento(char columna, int fila) {
		this.columna = columna;
		this.fila = columna;
		this.disponible = true;

	};

	// Getter Setter disponibilidad del asiento
	public boolean isDisponible() {
		return this.disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	
}

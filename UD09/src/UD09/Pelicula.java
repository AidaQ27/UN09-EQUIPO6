package UD09;

public class Pelicula {
	// Atributos
	private String titulo;
	private int duracion;
	private int edadMin;
	private String director;
	
	// Constructor con todos los atributos
	public Pelicula(String titulo, int duracion, int edadMin, String director) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.edadMin = edadMin;
		this.director = director;
	}

	// Getter & setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getEdadMin() {
		return edadMin;
	}

	public void setEdadMin(int edadMin) {
		this.edadMin = edadMin;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "Pelicula [En taquilla " + titulo + ", con una duracion " + duracion + " min, la calificación de edad es " + edadMin + ",  del director "
				+ director + "]";
	}
	
	
}



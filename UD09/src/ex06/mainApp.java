package ex06;

public class mainApp {

	public static void main(String[] args) {
		Pelicula pelicula = new Pelicula("a", 1, 1, "b");
		System.out.println(pelicula);
		Cine cine = new Cine(pelicula);
		cine.crearAsientos();
//		cine.getAsientos();
//		System.out.println();

	}

}

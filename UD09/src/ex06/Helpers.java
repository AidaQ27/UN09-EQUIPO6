package ex06;

public class Helpers {

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

}

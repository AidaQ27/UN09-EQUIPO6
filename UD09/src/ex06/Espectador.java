package ex06;

public class Espectador {

		//Atributos//
		private  String nombre;
		private int edad;
		private double dinero;
		
		//Constructores//
		public Espectador(String nombre, int edad, double dinero) {
			this.nombre = nombre;
			this.edad = edad;
			this.dinero = dinero;			
		}	
		//Metodos//
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {			
			this.nombre = nombre;
		}
		public int getEdad() {
			return edad;
		}
		public void setEdad (int edad) {
			this.edad = edad;
		}
		public double getDinero() {
			return dinero;
		}
		public void setDinero(double dinero) {
			this.dinero = dinero;
		}
		public boolean validarEdad(int edadMin) {
			return edad >= edadMin;
		}
		public boolean validarDinero(double precioEntrada) {
			return dinero >= precioEntrada;
		}		
		
		public String toString() {
			return "El nombre del espectador es " + nombre + ",tiene" + edad + " años y tiene " + dinero + "euros para pagar la entrada";
		}
}



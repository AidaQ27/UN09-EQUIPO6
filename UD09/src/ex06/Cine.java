package src.ex06;
public class Cine {
	
	// Atributos de la clase Cine
	private Pelicula pelicula;
	private int precioEntrada;
	private Asiento[] asientos;
	
	
	
	//Constructor
	public Cine(Pelicula pelicula){
		this.pelicula=pelicula;
		this.precioEntrada = 6;
		
		
	}
	
	// Metodo para 
	private void crearAsientos() {
		for(int x=0; x<8; x++) { // for por cada fila
			for(int y=0; y<9; y++) { // for por cada columna
				Asiento asiento = new Asiento();
				
			}
			
		}
		
		
		
		
		
	}

}

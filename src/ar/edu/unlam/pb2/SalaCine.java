package ar.edu.unlam.pb2;

public class SalaCine {
	private Asiento [][] butacas;
	private Pelicula pelicula;

	public SalaCine(int filas, int columnas) {
		this.butacas = new Asiento[filas][columnas];
		asignarAsientos(filas, columnas);
	}
	
	private void asignarAsientos(int filas, int columnas) {
		for(int i= 0; i < filas; i++) {
			for(int j = 0; j < columnas; j++) {
				this.butacas[i][j] = new Asiento();
			}
		}
	}

	public Asiento[][] getButacas() {
		
		return butacas;
	}

	public Object getPeliculaActual() {
		
		return null;
	}

	public String getTitulo() {
		
		return null;
	}

	public int contarAsientosOcupados() {
		int contador =0;
		for(int i= 0; i< this.butacas.length ; i++) {
			for(int j = 0; j< this.butacas[i].length; j++) {
				if(butacas[i][j].estaOcupado()) {
					contador++;
				}
			}
		}
		
		return contador;
	}

	public int getTotalAsientos() {
		
		return butacas.length * butacas[0].length ;
	}

	public void cambiarPelicula(Pelicula nuevaPelicula) {
		
		
	}

	public boolean venderBoleto(int fila, int columna, int edad, String nombreComprador) {
		
		return false;
	}



}

package ar.edu.unlam.pb2;

public class SalaCine {
	private Asiento [][] butacas;
	private Pelicula pelicula;

	public SalaCine(int filas, int columnas) {
		this.butacas = new Asiento[filas][columnas];
		asignarAsientos(filas, columnas);
	}
	
	// LOGICA DE BUTACAS (Asientos) --> inicializa los asientos, total de asientos y cuantos estan ocupados. libera un asiento.
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
	
	public int contarAsientosOcupados() {
		int contador =0;
		for(int i= 0; i< this.butacas.length ; i++) {
			for(int j = 0; j< this.butacas[i].length; j++) {
				if(butacas[i][j] != null && butacas[i][j].estaOcupado()) {
					contador++;
				}
			}
		}
		
		return contador;
	}

	public int getTotalAsientos() {
		
		return butacas.length * butacas[0].length ;
	}
	
	public boolean liberarAsiento(int fila, int columna) {
		 if(existeButaca(fila, columna) && butacas[fila][columna].estaOcupado()) {
			 butacas[fila][columna].liberarAsiento();
		 }
		return false;
	}

 //LOGICA CON PELICULA --> proyecta una pelicula, devuelve con get pelicula acual y titulo
	public void cambiarPelicula(Pelicula nuevaPelicula) {
		pelicula = nuevaPelicula;
		
	}
	public Pelicula getPeliculaActual() {
				
		return pelicula;
	}

		

	public boolean venderBoleto(int fila, int columna, Cliente cliente) {
		if(existeButaca(fila, columna) && !butacas[fila][columna].estaOcupado() && edadMinimaValida(cliente)) {
			butacas[fila][columna].ocuparAsiento();
			return true;
		}
		
		return false;
	}

	private boolean edadMinimaValida(Cliente cliente) {
		return pelicula.getEdadMinima() < cliente.getEdad();
	}

		
	private boolean existeButaca(int fila, int columna) {
		return butacas.length >= fila && butacas[0].length >= columna;
	}

	

	public void reiniciarSala() {
		for(int i= 0; i< this.butacas.length ; i++) {
			for(int j = 0; j< this.butacas[i].length; j++) {
				butacas[i][j] = null;
				}
			}
		pelicula = null;
	}

	public void mostrarButacasDetalle() {
		// TODO Auto-generated method stub
		
	}



}

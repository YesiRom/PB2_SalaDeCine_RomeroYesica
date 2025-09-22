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

	public Pelicula getPeliculaActual() {
		
		
		return pelicula;
	}

	public String getTitulo() {
		
		return pelicula.getTitulo();
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

	public void proyectarPelicula(Pelicula nuevaPelicula) {
		
		this.pelicula = nuevaPelicula;
	}

	public boolean venderBoleto(int fila, int columna, int edad, String nombreComprador) {
		
		
		
		return false;
	}

	public String mostrarButacas() {
		 StringBuilder sb = new StringBuilder();
	        sb.append("Sala de cine (O = libre, X = ocupada):\n\n");

	        for (int i = 0; i < butacas.length; i++) {
	            for (int j = 0; j < butacas[i].length; j++) {
	                sb.append(butacas[i][j].estaOcupado() ? "X " : "O ");
	            }
	            sb.append("\n");
	        }
	        return sb.toString();
		
		
		}

	public boolean liberarAsiento(int fila, int columna) {
		// TODO Auto-generated method stub
		return false;
	}

	public void cambiarPelicula(Pelicula nuevaPelicula) {
		pelicula = nuevaPelicula;
		
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

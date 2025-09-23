package ar.edu.unlam.pb2;


public class Asiento {
	private Cliente ocupante;
	private boolean estado;

	public boolean estaOcupado() {
		
		return estado;
	}
	
	public void ocuparAsiento() {
		estado= true;
	}
	
	public void liberarAsiento() {
		estado = false;
	}

}

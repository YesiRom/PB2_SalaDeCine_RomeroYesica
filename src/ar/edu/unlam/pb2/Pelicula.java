package ar.edu.unlam.pb2;

public abstract class Pelicula {
	private String titulo, sinopsis;
	private int duracion, edadMinima;
	
	public Pelicula(String titulo, int duracion, int edadMin) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.edadMinima = edadMin;
	}

	public String getTitulo() {
		return "";
	}

	public int getEdadMinima() {
		// TODO Auto-generated method stub
		return edadMinima;
	}

	public void mostrarSinopsis() {
		
		
	}

	

}

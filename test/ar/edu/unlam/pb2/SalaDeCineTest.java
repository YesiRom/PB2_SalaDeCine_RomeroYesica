package ar.edu.unlam.pb2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SalaDeCineTest {

	Pelicula peliculas[] = new Pelicula[4];
	SalaCine sala1;
	
	@BeforeEach      // o @Before en junit4
	void metodoQueSeEjecutaAntesDeTodo() {
		
	// Películas de Acción
		peliculas[0] = new PeliculaAccion("Piratas del Caribe 1", 200, 14);
		peliculas[1] = new PeliculaAccion("Misión Imposible", 150, 13);
		peliculas[2] = new PeliculaAccion("John Wick 4", 169, 16);
		peliculas[3] = new PeliculaAccion("Top Gun: Maverick", 130, 13);
		
		sala1 = new SalaCine(4, 3);
	}
	
	
	@Test
	void crearSalaOk() {
		
		PeliculaAccion pelicomparacion = new PeliculaAccion("Piratas del Caribe 1", 200, 14);//  (peli1= 0x1235)
		
		sala1.cambiarPelicula(peliculas[0]);
		assertEquals(4, sala1.getButacas().length);
		assertEquals(3, sala1.getButacas()[0].length);
		
		assertEquals(pelicomparacion, sala1.getPeliculaActual());
		
	}
	
	@Test
	void cuandoSeCambiaUnaPeliculaObtenerTitulo() {
		sala1.cambiarPelicula(peliculas[1]);
		
		assertEquals("Misión Imposible", sala1.getPeliculaActual().getTitulo());
	}
	
	@Test
	void venderBoletoExitoso() {	
		Cliente cliente1 = new Cliente("Romi", 19);
		sala1.cambiarPelicula(peliculas[0]);
		boolean venta1 = sala1.venderBoleto(0, 1, cliente1);
		boolean venta2 = sala1.venderBoleto(0, 2, cliente1);
		assertTrue(venta1);
		assertTrue(venta2);
	}
	
	
	@Test
	void venderBoletoNoExitosoPorqueSeIntentaVenderYaVendido() {
		Cliente cliente1 = new Cliente("Romi", 19);
		sala1.cambiarPelicula(peliculas[0]);
		boolean venta1 = sala1.venderBoleto(0, 1, cliente1);
		boolean venta2 = sala1.venderBoleto(0, 1, cliente1);
		assertTrue(venta1);
		assertFalse(venta2);
	}
	
	
	@Test
	void venderBoletoNoExitosoPorqueEdadMinimaNoCumplida() {
		Cliente cliente1 = new Cliente("Romi", 12);	
		Cliente cliente2 = new Cliente("Cris", 5);	
		sala1.cambiarPelicula(peliculas[0]);
		boolean venta1 = sala1.venderBoleto(0, 1, cliente1);
		boolean venta3 = sala1.venderBoleto(0, 1, cliente2);
	
		assertFalse(venta1);
		assertFalse(venta3);
	}
	
	@Test
	void venderBoletoNoExitosoPorqueAsientoEstaOcupado() {
		Cliente cliente1 = new Cliente("Romi", 18);	
		Cliente cliente2 = new Cliente("cris", 25);
		sala1.cambiarPelicula(peliculas[0]);
		boolean venta1 = sala1.venderBoleto(0, 1, cliente1);
		boolean venta2 = sala1.venderBoleto(0, 1, cliente2);
	
		assertTrue(venta1);
		assertFalse(venta2);
	}
	
	@Test
	void obtenerTotalAscientosTest() {
		SalaCine sala1 = new SalaCine(2, 3);
		assertEquals(6, sala1.getTotalAsientos());
		
	}
	
	@Test
	void contarAsientosOcupadosAlIniciarLaSalaTest() {
		assertEquals(0, sala1.contarAsientosOcupados());
	}
	
	@Test
	void contarAsientosOcupadosTest() {
		Cliente cliente1 = new Cliente("Romi", 19);
		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleto(0, 1, cliente1);
		sala1.venderBoleto(0, 2, cliente1);
		sala1.venderBoleto(1, 2, cliente1);
		
		assertEquals(3, sala1.contarAsientosOcupados());
	}
	
	@Test
	void liberarAsientoVendido() {
		Cliente cliente1 = new Cliente("Romi", 19);
		sala1.cambiarPelicula(peliculas[0]);
		sala1.venderBoleto(0, 1, cliente1);
		sala1.venderBoleto(0, 2, cliente1 );
		sala1.venderBoleto(1, 2, cliente1);
		
		assertEquals(3, sala1.contarAsientosOcupados());
		assertTrue(sala1.liberarAsiento(0, 1));
		assertEquals(2, sala1.contarAsientosOcupados());
		sala1.venderBoleto(0, 1, cliente1);
		assertEquals(3, sala1.contarAsientosOcupados());
	}
	
	@Test
	void liberarAsientoVendidoFueraDeRangoTest() {
		sala1.cambiarPelicula(peliculas[0]);
		Cliente cliente1 = new Cliente("romi", 18);
		sala1.venderBoleto(0, 0, cliente1);
		Cliente cliente2 = new Cliente("cris", 15);
		sala1.venderBoleto(2, 2, cliente2);
		Cliente cliente3 = new Cliente("uriel", 19);
		sala1.venderBoleto(0, 2, cliente3);
		
		
		assertEquals(3, sala1.contarAsientosOcupados());
		assertFalse(sala1.liberarAsiento(5, 10));
		assertFalse(sala1.liberarAsiento(-1, -1));
		assertEquals(3, sala1.contarAsientosOcupados());
	}
	
	@Test
    void testVaciarLaSalaDebeDejarTodoLibre() {
		sala1.cambiarPelicula(peliculas[0]);
		Cliente cliente1 = new Cliente("romi", 18);
		sala1.venderBoleto(0, 0, cliente1);
		Cliente cliente2 = new Cliente("cris", 15);
		sala1.venderBoleto(2, 2, cliente2);
		Cliente cliente3 = new Cliente("uriel", 19);
		sala1.venderBoleto(0, 2, cliente3);
		
		assertEquals(3, sala1.contarAsientosOcupados());
		
		sala1.reiniciarSala();
		
		assertEquals(0, sala1.contarAsientosOcupados());
		
		
	}
	
	
}

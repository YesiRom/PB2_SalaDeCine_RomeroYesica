package ar.edu.unlam.pb2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AsientoTest {

	private Asiento asiento;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        asiento = new Asiento();
        cliente = new Cliente("Romi", 25); 
    }

    @Test
    void asientoDebeEstarLibreAlCrearse() {
        assertFalse(asiento.estaOcupado());
        assertNull(asiento.getOcupante());
    }

    @Test
    void ocuparAsientoDebeMarcarloComoOcupado() {
        asiento.ocuparAsiento(cliente);

        assertTrue(asiento.estaOcupado());
        assertEquals(cliente, asiento.getOcupante());
    }

    @Test
    void liberarAsientoDebeMarcarloComoLibre() {
        asiento.ocuparAsiento(cliente);
        asiento.liberarAsiento();

        assertFalse(asiento.estaOcupado());
        assertNull(asiento.getOcupante());
        
    }

    @Test
    void liberarAsientoLibreNoDebeGenerarError() {
        asiento.liberarAsiento();

        assertFalse(asiento.estaOcupado(), "Un asiento liberado sin ocupar debe seguir libre");
        assertNull(asiento.getOcupante(), "El ocupante debe seguir siendo null");
    }

}

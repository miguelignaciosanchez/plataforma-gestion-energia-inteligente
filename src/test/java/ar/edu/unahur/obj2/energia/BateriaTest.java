package ar.edu.unahur.obj2.energia;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BateriaTest{
    @Test
    public void testConsultarEnergiaInicial(){
        Bateria bateria = new Bateria("BAT-01", 1000);
        assertEquals(1000, bateria.getEnergiaActual());
        assertEquals("BAT-01", bateria.getId());
    }
    @Test
    public void testModificarEnergiaValida() throws LimiteReservaExcedidoException{
        Bateria bateria = new Bateria("BAT-01", 1000);
        bateria.modificarEnergia(500); 
        assertEquals(1500, bateria.getEnergiaActual());
        bateria.modificarEnergia(-1000); 
        assertEquals(500, bateria.getEnergiaActual());
    }
    @Test
    public void testSuperarLimiteDeReservaLanzaException(){
        Bateria bateria = new Bateria("BAT-01", 0);
        assertThrows(LimiteReservaExcedidoException.class, () -> {
            bateria.modificarEnergia(-5001);
        });
    }
}

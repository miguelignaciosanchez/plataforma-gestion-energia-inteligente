package ar.edu.unahur.obj2.energia;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class RutinaYControladorTest {
    @Test
    public void testRutinaEjecutaTodasLasOperacionesYSeVacia() throws LimiteReservaExcedidoException{
        Bateria bateria = new Bateria("BAT-1", 1000);
        Rutina rutina = new Rutina();
        rutina.agregarOperacion(new Carga(bateria, 500));
        rutina.agregarOperacion(new Consumo(bateria, 300));
        rutina.ejecutar();
        assertEquals(1200, bateria.getEnergiaActual());
        assertEquals(0, rutina.getOperaciones().size());
    }
    @Test
    public void testRutinaTransaccionalAplicaRollbackSiUnaFalla(){
        Bateria bateria = new Bateria("BAT-2", -4800); 
        Rutina rutina = new Rutina();
        rutina.agregarOperacion(new Carga(bateria, 300));
        rutina.agregarOperacion(new Consumo(bateria, 600));
        assertThrows(LimiteReservaExcedidoException.class, () -> {rutina.ejecutar();});
        assertEquals(-4800, bateria.getEnergiaActual());
    }
}
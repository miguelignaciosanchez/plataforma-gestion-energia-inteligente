package ar.edu.unahur.obj2.energia;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OperacionTest{
    @Test
    public void testOperacionCargaExitosa() throws LimiteReservaExcedidoException{
        Bateria bateria = new Bateria("BAT-TEST", 1000);
        Operacion carga = new Carga(bateria, 500);
        carga.ejecutar();
        assertEquals(1500, bateria.getEnergiaActual());
        carga.deshacer();
        assertEquals(1000, bateria.getEnergiaActual());
    }
    @Test
    public void testOperacionConsumoExitoso() throws LimiteReservaExcedidoException{
        Bateria bateria = new Bateria("BAT-TEST", 1000);
        Operacion consumo = new Consumo(bateria, 300);
        consumo.ejecutar();
        assertEquals(700, bateria.getEnergiaActual());
        consumo.deshacer();
        assertEquals(1000, bateria.getEnergiaActual());
    }
    @Test
    public void testValoresMenoresOIgualesACeroLanzanException(){
        Bateria bateria = new Bateria("BAT-TEST", 1000);
        assertThrows(IllegalArgumentException.class, () -> {new Carga(bateria, 0);});
        assertThrows(IllegalArgumentException.class, () -> {new Consumo(bateria, -50);});
    }
}
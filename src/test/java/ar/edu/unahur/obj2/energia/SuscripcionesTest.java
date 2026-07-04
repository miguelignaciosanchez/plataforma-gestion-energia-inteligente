package ar.edu.unahur.obj2.energia;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SuscripcionesTest{
    @Test
    public void testNotificacionesYAuditoriaAlAlterarEnergia() throws LimiteReservaExcedidoException{
        Bateria bateria = new Bateria("BAT-OBS", 1000);
        RegistroAuditoria auditoria = new RegistroAuditoria();
        NotificacionAdministrador notificador = new NotificacionAdministrador();
        bateria.registrarInteresado(auditoria);
        bateria.registrarInteresado(notificador);
        bateria.modificarEnergia(500);
        assertEquals(1, auditoria.getCantidadRegistros());
        bateria.modificarEnergia(-200);
    }
    @Test
    public void testAlarmaReservaCriticaSeDisparaAbajoDeCero() throws LimiteReservaExcedidoException{
        Bateria bateria = new Bateria("BAT-CRITICA", 200);
        AlarmaReservaCritica alarma = new AlarmaReservaCritica();
        bateria.registrarInteresado(alarma);
        bateria.modificarEnergia(-300);
        assertTrue(alarma.estaEncendida());
    }
}
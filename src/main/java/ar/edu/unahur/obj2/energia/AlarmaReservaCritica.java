package ar.edu.unahur.obj2.energia;

public class AlarmaReservaCritica implements InteresadoEnergia{
    private boolean encendida = false;
    @Override
    public void reaccionar(Bateria bateria, int variacion){
        if (bateria.getEnergiaActual() < 0){
            this.encendida = true;
            System.out.println("[⚠️ ALARMA CRÍTICA] Batería " + bateria.getId() + " operando bajo reserva! Nivel actual: " + bateria.getEnergiaActual() + " kWh.");
        }else{
            this.encendida = false;
        }
    }
    public boolean estaEncendida(){return encendida;}
}
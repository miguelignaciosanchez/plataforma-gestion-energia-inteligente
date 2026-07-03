package ar.edu.unahur.obj2.energia;

public class NotificacionAdministrador implements InteresadoEnergia{
    @Override
    public void reaccionar(Bateria bateria, int variacion){
        if (variacion > 0){
            System.out.println("Se han cargado " + variacion + " kWh en su bateria " + bateria.getId());
        }else{
            System.out.println("Se han consumido " + Math.abs(variacion) + " kWh en su bateria " + bateria.getId());
        }
    }
}
package ar.edu.unahur.obj2.energia;

import java.util.ArrayList;
import java.util.List;

public class Bateria {
    private String id;
    private int energiaActual;
    private List<InteresadoEnergia> interesados = new ArrayList<>();
    public Bateria(String id, int energiaActual){
        this.id = id;
        this.energiaActual = energiaActual;
    }
    public String getId(){
        return id;
    }
    public int getEnergiaActual(){
        return energiaActual;
    }
    public void registrarInteresado(InteresadoEnergia interesado){
        this.interesados.add(interesado);
    }
    public void eliminarInteresado(InteresadoEnergia interesado){
        this.interesados.remove(interesado);
    }
    private void notificarInteresados(int variacion){
        for (InteresadoEnergia interesado : interesados){
            interesado.reaccionar(this, variacion);
        }
    }
    public void modificarEnergia(int cantidad) throws LimiteReservaExcedidoException{
        int nuevoNivel = this.energiaActual + cantidad;
        if (nuevoNivel < -5000){
            throw new LimiteReservaExcedidoException("No se puede superar el limite de reserva absoluto de -5000 kWh.");
        }
        this.energiaActual = nuevoNivel;
        notificarInteresados(cantidad);
    }
}

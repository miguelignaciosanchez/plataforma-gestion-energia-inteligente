package ar.edu.unahur.obj2.energia;

import java.util.ArrayList;
import java.util.List;

public class Bateria{
    private String id;
    private int energiaActual;
    public Bateria(String id, int energiaInicial){
        this.id = id;
        this.energiaActual = energiaInicial;
    }
    public int getEnergiaActual(){
        return this.energiaActual;
    }
    public String getId(){
        return this.id;
    }
    public void modificarEnergia(int valor) throws LimiteReservaExcedidoException{
        int nuevaEnergia = this.energiaActual + valor;   
        if (nuevaEnergia < -5000){
            throw new LimiteReservaExcedidoException("Supera el límite de reserva física de -5000 kWh.");
        }
        this.energiaActual = nuevaEnergia;
    }
}

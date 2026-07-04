package ar.edu.unahur.obj2.energia;

public class Carga implements Operacion{
    private Bateria bateria;
    private int valor;
    public Carga(Bateria bateria, int valor){
        if (valor <= 0){
            throw new IllegalArgumentException("El valor de carga debe ser mayor a cero.");
        }
        this.bateria = bateria;
        this.valor = valor;
    }
    @Override
    public void ejecutar() throws LimiteReservaExcedidoException{
        bateria.modificarEnergia(valor);
    }
    @Override
    public void deshacer(){
        try{
            bateria.modificarEnergia(-valor);
        }catch(LimiteReservaExcedidoException e){
            System.err.println("Error al deshacer carga: " + e.getMessage());
        }
    }
}
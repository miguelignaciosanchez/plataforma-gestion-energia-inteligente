package ar.edu.unahur.obj2.energia;

public interface Operacion{
    void ejecutar() throws LimiteReservaExcedidoException;
    void deshacer();
}
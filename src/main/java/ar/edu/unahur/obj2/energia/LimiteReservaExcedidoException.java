package ar.edu.unahur.obj2.energia;

public class LimiteReservaExcedidoException extends Exception{
    public LimiteReservaExcedidoException(){
        super();
    }
    public LimiteReservaExcedidoException(String mensaje){
        super(mensaje);
    }
}
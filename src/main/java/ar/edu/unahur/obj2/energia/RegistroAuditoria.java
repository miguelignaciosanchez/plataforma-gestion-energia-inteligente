package ar.edu.unahur.obj2.energia;

public class RegistroAuditoria implements InteresadoEnergia{
    private int cantidadRegistros = 0;
    @Override
    public void reaccionar(Bateria bateria, int variacion){
        cantidadRegistros++;
        System.out.println("[AUDITORÍA] Batería " + bateria.getId() + " alterada en " + variacion + " kWh.");
    }
    public int getCantidadRegistros(){return cantidadRegistros;}
}
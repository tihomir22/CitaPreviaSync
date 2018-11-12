/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citapreciasync;

import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class Enfermera {

    private Hashtable<String, String> citas = new Hashtable<String, String>();
    private boolean pacienteDentro;

    public Enfermera() {
        darDeAltaHorasPosibles();
        this.pacienteDentro = false;
    }

    public Hashtable<String, String> getCitas() {
        return citas;
    }

    public void setCitas(Hashtable<String, String> citas) {
        this.citas = citas;
    }

    public synchronized boolean isPacienteDentro() {
        return pacienteDentro;
    }

    public synchronized void setPacienteDentro(boolean pacienteDentro) {
        this.pacienteDentro = pacienteDentro;
    }

    public void darDeAltaHorasPosibles() {
        this.citas.put("10:00", "libre");
        this.citas.put("10:15", "libre");
        this.citas.put("10:30", "libre");
        this.citas.put("10:45", "libre");
        this.citas.put("11:00", "libre");
        this.citas.put("11:15", "libre");
        this.citas.put("11:30", "libre");
        this.citas.put("11:45", "libre");
        this.citas.put("12:00", "libre");

    }

    public synchronized void asignarCita(String nombrePaciente) throws InterruptedException {
        System.out.println("Paciente numero " + nombrePaciente + " entrando en el ambulatorio");
        Thread.sleep(1000);
        System.out.println("Paciente solicitando la cita");
        Thread.sleep(1000);
        if (comprobarLibre()==true) {
            System.out.println("Hay sitio para cita");
            String valorRetornado = this.devolverKeyLibre();
            if (valorRetornado != null) {
                this.citas.replace(valorRetornado, "ocupado");
                System.out.println("Cita asignada asignada a las "+valorRetornado);
            }
        } else {
            System.out.println("NO HAY SITIO PARA MÁS CITAS");
        }
        System.out.println("Saliendo del ambulatorio");
        Thread.sleep(1000);

    }

    public synchronized String devolverKeyLibre() {
        String[] listaHoras = {"10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00"};
        for (int i = 0; i < this.citas.size(); i++) {
            if (this.citas.get(listaHoras[i]).equalsIgnoreCase("libre")) {
                return listaHoras[i].toString();
            }
        }
        return null;
    }
    public synchronized boolean comprobarLibre(){
        if(this.citas.contains("libre")){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Enfermera{" + "capitales=" + citas + '}';
    }

}

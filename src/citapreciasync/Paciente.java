/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citapreciasync;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class Paciente extends Thread {

    private Enfermera enf;
    private int numeroPaciente;

    @Override
    public void run() {
        while (true) {
            if (enf.isPacienteDentro() == false) {
                enf.setPacienteDentro(true);
                try {
                    enf.asignarCita(this.getName());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
                }

                enf.setPacienteDentro(false);
                break;
            }
        }
    }

    public Paciente(Enfermera enf, int numeroPaciente) {
        this.enf = enf;
        this.numeroPaciente = numeroPaciente;
        this.setName(this.numeroPaciente + "");
    }

    public Paciente() {
    }

    public Enfermera getEnf() {
        return enf;
    }

    public void setEnf(Enfermera enf) {
        this.enf = enf;
    }

    public int getNumeroPaciente() {
        return numeroPaciente;
    }

    public void setNumeroPaciente(int numeroPaciente) {
        this.numeroPaciente = numeroPaciente;
    }

    @Override
    public String toString() {
        return "Paciente{" + "enf=" + enf + ", numeroPaciente=" + numeroPaciente + '}';
    }

}

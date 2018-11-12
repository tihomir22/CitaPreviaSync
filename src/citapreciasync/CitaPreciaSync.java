/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citapreciasync;

/**
 *
 * @author mati
 */
public class CitaPreciaSync {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
       Enfermera enfer=new Enfermera();
       Paciente pac1=new Paciente(enfer,1);
       Paciente pac2=new Paciente(enfer,2);
       Paciente pac3=new Paciente(enfer,3);
       Paciente pac4=new Paciente(enfer,4);
       Paciente pac5=new Paciente(enfer,5);
       Paciente pac6=new Paciente(enfer,6);
       Paciente pac7=new Paciente(enfer,7);
       Paciente pac8=new Paciente(enfer,8);
       Paciente pac9=new Paciente(enfer,9);
       Paciente pac10=new Paciente(enfer,10);
       Paciente pac11=new Paciente(enfer,11);
      
       
       pac1.start();
       pac2.start();
       pac3.start();
       pac4.start();
       pac5.start();
       pac6.start();
       pac7.start();
       pac8.start();
       pac9.start();
       pac10.start();
       pac11.start();
       
       pac1.join();
       pac2.join();
       pac3.join();
       pac4.join();
       pac5.join();
       pac6.join();
       pac7.join();
       pac8.join();
       pac9.join();
       pac10.join();
       pac11.join();
        System.out.println("Todos los turnos \n"+enfer.toString());
       
    }
    
}

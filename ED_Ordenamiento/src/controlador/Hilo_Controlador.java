/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import vista.Mezcla_Vista;

public class Hilo_Controlador extends Thread{

    private JButton btn;
    private JButton btn2;
    private JButton btn3;
    private Mezcla_Vista mv;

    public Hilo_Controlador(JButton btn, JButton btn2, JButton btn3, Mezcla_Vista mv) {
        this.btn = btn;
        this.btn2 = btn2;
        this.btn3 = btn3;
        this.mv = mv;
    }

    @Override
    public void run() {
        
        int pos = 0;
        int pos2 = 0;
        int pos3 = 0;
        
        while (true) {
            try {
                sleep(30);

                pos = Mezcla_Vista.getBtnInicio().getLocation().x;
                pos2 = Mezcla_Vista.getBtnTorneo().getLocation().x;
                pos3 = Mezcla_Vista.getBtnInformacion().getLocation().x;
                
                if(pos < 0 && pos2 < 0){
                    btn.setLocation(btn.getLocation().x + 5, btn.getLocation().y);
                    btn2.setLocation(btn2.getLocation().x + 5, btn2.getLocation().y);
                    btn3.setLocation(btn3.getLocation().x + 5, btn3.getLocation().y);
                    mv.repaint();
                } else{
                    break;
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}

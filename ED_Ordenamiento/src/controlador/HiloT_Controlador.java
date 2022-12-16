/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import static java.lang.Thread.sleep;
import javax.swing.JButton;
import vista.Torneo_Vista;

public class HiloT_Controlador extends Thread{
    private JButton btn;
    private JButton btn2;
    private Torneo_Vista mv;

    public HiloT_Controlador(JButton btn, JButton btn2, Torneo_Vista mv) {
        this.btn = btn;
        this.btn2 = btn2;
        this.mv = mv;
    }

    @Override
    public void run() {
        
        int pos = 0;
        int pos2 = 0;
        
        while (true) {
            try {
                sleep(30);

                pos = Torneo_Vista.getBtnInicio().getLocation().x;
                pos2 = Torneo_Vista.getBtnMezcla().getLocation().x;
                
                if(pos < 0 && pos2 < 0){
                    btn.setLocation(btn.getLocation().x + 5, btn.getLocation().y);
                    btn2.setLocation(btn2.getLocation().x + 5, btn2.getLocation().y);
                    mv.repaint();
                } else{
                    break;
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}

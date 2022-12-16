/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import modelo.OrdenamientoTorneo;
import vista.Menu_Vista;
import vista.Mezcla_Vista;
import vista.Torneo_Vista;

public class Torneo_Controlador {

    public void acciones() {

        Torneo_Vista.getBtnCerrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        Torneo_Vista.getAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrdenamientoTorneo.valores.add(Integer.parseInt(Torneo_Vista.getTxtAgregar().getText()));
                
                String valor = "";
                for (Integer i : OrdenamientoTorneo.valores) {
                    valor += "[" + i + "] ";
                }
                
                Torneo_Vista.getDatosArrOrig().setText(valor);
                Torneo_Vista.getTxtAgregar().setText("");
            }
        });
        
        OrdenamientoTorneo ot = new OrdenamientoTorneo();
        
        Torneo_Vista.getBtnOrdenar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ot.mostrarDatos(OrdenamientoTorneo.valores);
                
                ot.eliminarDato();

                String valor = "";
                
                for (Integer x : ot.listaF) {
                    valor += "[" + x + "] ";
                }
                Torneo_Vista.getDatosArrOrd().setText(valor);
                Torneo_Vista.getTxtPane().setText(ot.texto);
                
            }
        });
    }

}

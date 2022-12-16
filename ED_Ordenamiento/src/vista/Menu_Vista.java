/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.Mezcla_Controlador;
import controlador.Torneo_Controlador;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu_Vista extends JFrame{
    
    Diseno d = new Diseno();
    JLabel fondo;
    
    public static JButton btnMezcla;
    public static JButton btnTorneo;
    
    public Menu_Vista(){
        setSize(316, 339);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        add(d);
        initComponent();
    }
    
    public void initComponent() {
        Menu_Vista.btnMezcla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mezcla_Vista mv = new Mezcla_Vista();
                mv.setVisible(true);
                mv.menu();
                Mezcla_Controlador mc = new Mezcla_Controlador();
                mc.acciones();
                dispose();
            }
        });
        
        Menu_Vista.btnTorneo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Torneo_Vista mv = new Torneo_Vista();
                mv.setVisible(true);
                mv.menu();
                Torneo_Controlador mc = new Torneo_Controlador();
                mc.acciones();
                dispose();
            }
        });
    }
    
    private class Diseno extends JPanel{
        
        public Diseno(){
            setLayout(null);
            fondo = new JLabel();
            fondo.setBounds(0, 0, 300, 120);
            fondo.setBackground(new Color(49,18,240));
            fondo.setOpaque(true);
            fondo.setHorizontalAlignment((int)CENTER_ALIGNMENT);
            fondo.setIcon(new ImageIcon("src/img/EstructuraDatos.png"));
            add(fondo);
            
            btnMezcla = new JButton();
            btnMezcla.setBounds(16, 143, 125, 125);
            btnMezcla.setIcon(new ImageIcon("src/img/Metodo Mezcla.png"));
            btnMezcla.setBackground(new Color(49,129,250));
            btnMezcla.setHorizontalAlignment((int)CENTER_ALIGNMENT);
            btnMezcla.setFocusable(false);
            btnMezcla.setBorder(null);
            add(btnMezcla);
            
            btnTorneo = new JButton();
            btnTorneo.setBounds(159, 143, 125, 125);
            btnTorneo.setIcon(new ImageIcon("src/img/Metodo Torneo.png"));
            btnTorneo.setBackground(new Color(49,129,250));
            btnTorneo.setHorizontalAlignment((int)CENTER_ALIGNMENT);
            btnTorneo.setFocusable(false);
            btnTorneo.setBorder(null);
            add(btnTorneo);
        }
        
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(new Color(154, 211, 252));
            g.fillRect(0, 0, 300, 300);
        }
    }
}

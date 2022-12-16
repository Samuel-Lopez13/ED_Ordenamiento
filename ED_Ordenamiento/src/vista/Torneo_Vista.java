package vista;

import controlador.HiloT_Controlador;
import controlador.Hilo_Controlador;
import controlador.Mezcla_Controlador;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class Torneo_Vista extends JFrame {

    int valor = 0;

    private Diseno d = new Diseno();

    public static SimpleAttributeSet attrs = new SimpleAttributeSet(); 
    
    private static JButton btnCerrar;
    private static JButton btnMenu;
    private static JButton agregar;
    private static JButton btnReset;
    private static JButton btnOrdenar;
    private static JButton btnInicio;
    private static JButton btnTorneo;

    private JLabel titulo;
    private JLabel arrOrig;
    private JLabel arrOrd;
    private static JLabel datosArrOrig;
    private static JLabel datosArrOrd;

    private static JTextField txtAgregar;

    public static JTextPane txtPane;
    private JScrollPane scroll;

    public Torneo_Vista() {
        setSize(350, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        add(d);
        initComponent();
    }
    
    public void initComponent(){
        Torneo_Vista.getBtnInicio().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Menu_Vista ms = new Menu_Vista();
                ms.setVisible(true);
                dispose();
            }
        });
        
        Torneo_Vista.getBtnMezcla().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Mezcla_Vista ms = new Mezcla_Vista();
                ms.setVisible(true);
                ms.menu();
                Mezcla_Controlador mc = new Mezcla_Controlador();
                mc.acciones();
                dispose();
            }
        });
    }

    public void menu() {
        Torneo_Vista.btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecucion();
            }
        });
    }

    public void ejecucion() {
        if (valor == 0) {
            Torneo_Vista.btnInicio.setLocation(Torneo_Vista.btnInicio.getLocation().x, Torneo_Vista.btnInicio.getLocation().y);
            Torneo_Vista.btnTorneo.setLocation(Torneo_Vista.btnTorneo.getLocation().x, Torneo_Vista.btnTorneo.getLocation().y);
            HiloT_Controlador mc = new HiloT_Controlador(btnInicio, btnTorneo, this);
            mc.start();
            valor = 1; 
           
        } else if (valor == 1) {
            btnInicio.setBounds(-175, 40, 175, 35);
            btnTorneo.setBounds(-175, 75, 175, 35);
            valor = 0;
        }
    }

    public static JButton getBtnCerrar() {
        return btnCerrar;
    }

    public static JButton getBtnMenu() {
        return btnMenu;
    }

    public static JButton getAgregar() {
        return agregar;
    }

    public static JLabel getDatosArrOrd() {
        return datosArrOrd;
    }

    public static JLabel getDatosArrOrig() {
        return datosArrOrig;
    }

    public static JTextField getTxtAgregar() {
        return txtAgregar;
    }

    public static JButton getBtnOrdenar() {
        return btnOrdenar;
    }

    public static JButton getBtnReset() {
        return btnReset;
    }

    public static JButton getBtnInicio() {
        return btnInicio;
    }

    public static JButton getBtnMezcla() {
        return btnTorneo;
    }

    public static JTextPane getTxtPane() {
        return txtPane;
    }
    
    public static void nuevaLinea(JTextPane text) {
            try {
                text.getStyledDocument().insertString(
                        text.getStyledDocument().getLength(),
                        System.getProperty("line.separator"), null);
            } catch (BadLocationException ex) {
            }
    }

    private class Diseno extends JPanel {

        public Diseno() {
            setLayout(null);

            btnInicio = new JButton("Inicio");
            btnInicio.setBounds(-175, 40, 175, 35);
            btnInicio.setBorder(null);
            btnInicio.setIcon(new ImageIcon("src/img/Inicio.png"));
            btnInicio.setFocusable(false);
            btnInicio.setBackground(new Color(217, 217, 217));
            add(btnInicio);

            btnTorneo = new JButton("Ordenamiento Mezcla");
            btnTorneo.setBounds(-175, 75, 175, 35);
            btnTorneo.setBorder(null);
            btnTorneo.setIcon(new ImageIcon("src/img/Ordenamiento.png"));
            btnTorneo.setFocusable(false);
            btnTorneo.setBackground(new Color(217, 217, 217));
            add(btnTorneo);

            btnCerrar = new JButton();
            btnCerrar.setBounds(310, 5, 30, 30);
            btnCerrar.setIcon(new ImageIcon("src/img/Cerrar.png"));
            add(btnCerrar);

            btnMenu = new JButton();
            btnMenu.setBounds(10, 5, 30, 30);
            btnMenu.setBorder(null);
            btnMenu.setIcon(new ImageIcon("src/img/Menu.png"));
            add(btnMenu);

            btnReset = new JButton();
            btnReset.setBounds(181, 146, 105, 28);
            btnReset.setBorder(null);
            btnReset.setBackground(new Color(90, 227, 94));
            btnReset.setFocusable(false);
            btnReset.setIcon(new ImageIcon("src/img/Reset.png"));
            add(btnReset);

            btnOrdenar = new JButton();
            btnOrdenar.setBounds(65, 146, 105, 28);
            btnOrdenar.setBorder(null);
            btnOrdenar.setBackground(new Color(90, 227, 94));
            btnOrdenar.setFocusable(false);
            btnOrdenar.setIcon(new ImageIcon("src/img/Ordenar.png"));
            add(btnOrdenar);

            titulo = new JLabel();
            titulo.setBounds(85, 5, 350, 30);
            titulo.setIcon(new ImageIcon("src/img/Titulo2.png"));
            add(titulo);

            txtAgregar = new JTextField();
            txtAgregar.setBounds(30, 55, 200, 30);
            add(txtAgregar);

            agregar = new JButton();
            agregar.setBounds(241, 61, 78, 24);
            agregar.setBackground(new Color(90, 227, 94));
            agregar.setFocusable(false);
            agregar.setBorder(null);
            agregar.setIcon(new ImageIcon("src/img/Agregar.png"));
            add(agregar);

            arrOrd = new JLabel();
            arrOrd.setBounds(18, 195, 112, 20);
            arrOrd.setIcon(new ImageIcon("src/img/ArrOrd.png"));
            add(arrOrd);

            arrOrig = new JLabel();
            arrOrig.setBounds(18, 105, 105, 20);
            arrOrig.setIcon(new ImageIcon("src/img/ArrOrig.png"));
            add(arrOrig);

            datosArrOrd = new JLabel();
            datosArrOrd.setBounds(133, 189, 200, 30);
            datosArrOrd.setBackground(Color.WHITE);
            datosArrOrd.setOpaque(true);
            add(datosArrOrd);

            datosArrOrig = new JLabel();
            datosArrOrig.setBounds(133, 100, 200, 30);
            datosArrOrig.setBackground(Color.WHITE);
            datosArrOrig.setOpaque(true);
            add(datosArrOrig);

            txtPane = new JTextPane();
            scroll = new JScrollPane(txtPane);
            scroll.setBounds(26, 228, 300, 255);
            txtPane.setBackground(new Color(217, 217, 217));
            txtPane.setEnabled(false);
            txtPane.setDisabledTextColor(Color.BLACK);
            scroll.setBorder(null);
            add(scroll);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(154, 211, 252));
            g.fillRect(0, 40, 350, 460);

            g.setColor(new Color(217, 217, 217));
            g.fillRect(0, 0, 350, 40);
        }

    }
}

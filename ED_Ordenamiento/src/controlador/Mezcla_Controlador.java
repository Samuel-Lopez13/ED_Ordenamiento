/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import ejecucion.Ejecucion;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import modelo.OrdenamientoMezcla;
import vista.Menu_Vista;
import vista.Mezcla_Vista;

public class Mezcla_Controlador {

    OrdenamientoMezcla mergeSort = new OrdenamientoMezcla();
    Map<Integer, Color> map = new HashMap<Integer, Color>();
    private int contador = 0;
    private int arreglo[] = new int[contador];
    private int aux[];

    public void acciones() {
        Mezcla_Vista.getBtnCerrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        Mezcla_Vista.getAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador++;
                aux = arreglo;
                arreglo = new int[contador];
                for (int i = 0; i < contador - 1; i++) {
                    arreglo[i] = aux[i];
                }
                arreglo[contador - 1] = Integer.parseInt(Mezcla_Vista.getTxtAgregar().getText());

                String valor = "";
                for (int i : arreglo) {
                    valor += "[" + i + "] ";
                }
                Mezcla_Vista.getDatosArrOrig().setText(valor);
                Mezcla_Vista.getTxtAgregar().setText("");
            }
        });

        Mezcla_Vista.getBtnOrdenar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mergeSort.sort(arreglo, 0, arreglo.length - 1);
                String valores = "";
                for (int i : arreglo) {
                    valores += "[" + i + "] ";
                }
                Mezcla_Vista.getDatosArrOrd().setText(valores);

                Mezcla_Vista.getTxtAgregar().setText("");

                Mezcla_Vista.getTxtAgregar().setEnabled(false);
                Mezcla_Vista.getAgregar().setEnabled(false);
                Mezcla_Vista.getAgregar().setBackground(Color.red);
                Mezcla_Vista.getAgregar().setDisabledIcon(new ImageIcon("src/img/AgregarB.png"));

                //aqui quiero pintar dibujos
                dibujarPane();
                
                System.out.println(OrdenamientoMezcla.cPermutaciones);

//                Esta linea sirve si quiero colocar Texto
//                Mezcla_Vista.getTxtPane().setText(OrdenamientoMezcla.texto);
//                OrdenamientoMezcla.texto = "";
//                OrdenamientoMezcla.cont = 0;
            }
        });

        Mezcla_Vista.getBtnReset().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador = 0;
                arreglo = new int[contador];

                Mezcla_Vista.getTxtAgregar().setText("");
                Mezcla_Vista.getDatosArrOrd().setText("");
                Mezcla_Vista.getDatosArrOrig().setText("");
                Mezcla_Vista.txtPane.setText("");

                Mezcla_Vista.getTxtAgregar().setEnabled(true);
                Mezcla_Vista.getAgregar().setEnabled(true);
                Mezcla_Vista.getAgregar().setBackground(new Color(90, 227, 94));
                Mezcla_Vista.getAgregar().setDisabledIcon(new ImageIcon("src/img/Agregar.png"));
            }
        });
    }

    public int numerosAleatorios() {
        return (int) (Math.random() * (255 - 0) + 0);
    }

    public void dibujarPane() {
        //-------------------------------------------------------------
//        JButton btn = new JButton("xd");
//        Mezcla_Vista.getTxtPane().setCaretPosition(Mezcla_Vista.getTxtPane().getStyledDocument().getLength());
//        StyleConstants.setAlignment(Mezcla_Vista.attrs, StyleConstants.ALIGN_CENTER);
//        StyledDocument doc = Mezcla_Vista.getTxtPane().getStyledDocument();
//        doc.setParagraphAttributes(0, doc.getLength(), Mezcla_Vista.attrs, true);
//        Mezcla_Vista.getTxtPane().insertComponent(btn);
//        
//        Mezcla_Vista.nuevaLinea(Mezcla_Vista.getTxtPane());
        //-------------------------------------------------------------

        for (int i : arreglo) {
//            System.out.println(i);
            map.put(i, new Color(numerosAleatorios(), numerosAleatorios(), numerosAleatorios()));
        }

        for (int i = 0; i < OrdenamientoMezcla.info.size(); i++) {
            Mezcla_Vista.getTxtPane().setCaretPosition(Mezcla_Vista.getTxtPane().getStyledDocument().getLength());
            StyleConstants.setAlignment(Mezcla_Vista.attrs, StyleConstants.ALIGN_CENTER);
            StyledDocument doc = Mezcla_Vista.getTxtPane().getStyledDocument();
            doc.setParagraphAttributes(0, doc.getLength(), Mezcla_Vista.attrs, false);
            JButton btn;
            JButton btn2;
            if (!OrdenamientoMezcla.info.get(i).equals("break") && !OrdenamientoMezcla.info.get(i).equals("igual")) {
                btn = new JButton(OrdenamientoMezcla.info.get(i));
                btn2 = new JButton("  ");
                btn.setBackground(map.get(Integer.parseInt(OrdenamientoMezcla.info.get(i))));
                Mezcla_Vista.getTxtPane().insertComponent(btn);
                btn2.setBackground(new Color(217, 217, 217));
                btn2.setFocusable(false);
                btn2.setBorder(null);
                Mezcla_Vista.getTxtPane().insertComponent(btn2);
            } else if (OrdenamientoMezcla.info.get(i).equals("igual")) {
                btn = new JButton("   =   ");
                btn.setBackground(new Color(217, 217, 217));
                btn.setFocusable(false);
                btn.setFont(new Font("Arial", Font.BOLD, 18));
                btn.setBorder(null);
                Mezcla_Vista.getTxtPane().insertComponent(btn);
            } else {
                Mezcla_Vista.nuevaLinea(Mezcla_Vista.getTxtPane());
                Mezcla_Vista.nuevaLinea(Mezcla_Vista.getTxtPane());
            }
        }

    }

}

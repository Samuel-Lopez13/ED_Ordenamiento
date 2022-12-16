/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author ferna
 */
public class OrdenamientoTorneo {

    //Datos principales
    public static ArrayList<Integer> valores = new ArrayList();
    //primer auxiliar
    public ArrayList<Integer> vAux = new ArrayList();
    //segundo auxiliar
    public ArrayList<Integer> vAux2 = new ArrayList();
    //resultado final
    public ArrayList<Integer> listaF = new ArrayList();
    //se puso para que no se incrementen los datos
    int contador = 1;

    int numVuelta = 0;

    public String texto = "";
    int con = 0;

    int dato = 0;
    int dato2 = 0;
    int ganador = 0;

    //pedir lista con valores
    public int mostrarDatos(ArrayList<Integer> d) {
        //para que se vean mis valores
//        datosArreglo();

        con = 0;

        vAux = d;

//        int dato = 0;
//        int dato2 = 0;
//        int ganador = 0;
        //vAux = 1 ya no entrara ya que se encontro el valor mas pequeño
        while (vAux.size() > 1) {
            //inicializo para reiniciarlo
            vAux2 = new ArrayList();

            //donde se guardara el ultimo valor si mi tamaño es impar
            int vA = 0;
            //para saber la cantidad de vueltas que dara
            int total = vAux.size() / 2;
            //una bandera para saber si el numero de mis datos en impar o par
            boolean bandera = false;
            //se saca el modulo para saber si es impar o par
            if (vAux.size() % 2 != 0) {
                //si es impar se guardara el ultimo valor
                vA = vAux.get(vAux.size() - 1);
                bandera = true;
            } else {
                //si no es impar pues no se guardara nada
                vA = 0;
                bandera = false;
            }

            //el total se multiplica por 2 ya que se va haciendo la suma de 2 en 2
            for (int i = 0; i < total * 2; i += 2) {
                texto += "Competencia " + ++con + "\n";
                //Se toman de 2 en 2 datos
                dato = vAux.get(i);
                texto += "dato " + (i) + ": " + dato + "\n";
                dato2 = vAux.get(i + 1);
                texto += "dato " + (i + 1) + ": " + dato2 + "\n";

                //Se comparan y se va guardando entre esos el menor
                if (dato < dato2) {
                    vAux2.add(dato);
                    texto += "Ganador: " + dato + "\n";
                    ganador = dato;
                } else {
                    vAux2.add(dato2);
                    texto += "Ganador: " + dato2 + "\n";
                    ganador = dato2;
                }
            }

            //los datos del auxiliar se guardan en el auxiliar 1 por si se necesita
            //otra vuelta y se ejecutara el mismo procedimiento
            vAux = vAux2;
            //si el valor de bandera fue verdadera osea que la cantidad de datos fue
            //impar se agregara el ultimo dato. ya que este no se tomo en cuenta en
            //las comparaciones
            if (bandera) {
                vAux.add(vA);
            }
            
            texto += "\n";
        }

        //me retornara el valor ganador
        
        return vAux.get(0);
    }

    public void eliminarDato() {
        
//        texto += "Competencia " + ++con + "\n";
//        texto += "dato: " + dato + "\n";
//        texto += "dato: " + dato2 + "\n";
//        texto += "Ganador: " + ganador + "\n\n";
        
//        datosArreglo();
        //guardo la cantidad de datos que tiene mi valor
        int c = valores.size();
        for (int i = 0; i < c; i++) {
            //en esta lista se guardara el valor ganador
            listaF.add(mostrarDatos(valores));
            //el valor ganador obtengo su index
            int eliminar = valores.indexOf(mostrarDatos(valores));
            //lo elimino
            valores.remove(eliminar);
        }
//        //imprimo la lista final
//        for (Integer valore : listaF) {
//            System.out.println(valore);
//        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

public class OrdenamientoMezcla {
    
    public static String texto = "";
    public static ArrayList<String> info = new ArrayList<>();
    
    public static int cont = 0;
    
    public static int cPermutaciones = 0;
    
    public static int cCompaciones = 0;

    //se encargará de dividir en dos mitades el vector recursivamente
    //ésta función tiene la tarea de dividir en dos mitades el vector que 
    //se pasa por parametro hasta que el vector se quede de tamaño 1.
    public void sort(int arreglo[], int left, int right) {
        if (left < right) {
            //Encuentra el punto medio del vector.
            int middle = (left + right) / 2;
            //Divide la primera y segunda mitad (llamada recursiva).
            sort(arreglo, left, middle);
            sort(arreglo, middle + 1, right);

            //Une las mitades.
            merge(arreglo, left, middle, right);
        }
    }

    //se encargará de unir los sub-vectores
    //el cuál recibirá por parámetro el vector, la posición de 
    //la izquierda, la posición del medio y la posición final(right).
    public void merge(int arreglo[], int left, int middle, int right) {
        //Encuentra el tamaño de los sub-vectores para unirlos.
        int n1 = middle - left + 1;
        int n2 = right - middle;
        
        int con = 0;
        
        texto += "Ordenamiento: " + ++cont + "\n";
        
//        System.out.println("Ordenamiento: " + ++cont);

        //Vectores temporales.
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        //Copia los datos a los arreglos temporales.
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arreglo[left + i];
            texto += "dato " + ++con + ": " + leftArray[i] + "\n";
            info.add("" + leftArray[i]);
//            System.out.println("dato " + ++con + ": " + leftArray[i]);
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arreglo[middle + j + 1];
            texto += "dato " + ++con + ": " + rightArray[j] + "\n";
            info.add("" + rightArray[j]);
//            System.out.println("dato " + ++con + ": " +rightArray[j]);
        }
        
        info.add("igual");
        
        /* Une los vectorestemporales. */

        //Índices inicial del primer y segundo sub-vector.
        int i = 0, j = 0;

        //Índice inicial del sub-vector arreglo[].
        int k = left;

        texto += "Datos ordenados: ";
        
        //Ordenamiento.
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arreglo[k] = leftArray[i];
                texto += leftArray[i] + " ";
                info.add("" + leftArray[i]);
//                System.out.print(leftArray[i] + " ");
                i++;
            } else {
                arreglo[k] = rightArray[j];
                texto += rightArray[j] + " ";
                info.add("" + rightArray[j]);
//                System.out.print(rightArray[j] + " ");
                j++;
            }
            k++;
        }//Fin del while.

        /* Si quedan elementos por ordenar */
        //Copiar los elementos restantes de leftArray[].
        while (i < n1) {
            arreglo[k] = leftArray[i];
            texto += leftArray[i] + " " + "\n";
            info.add("" + leftArray[i]);
//            System.out.print(leftArray[i] + " ");
            i++;
            k++;
        }
        //Copiar los elementos restantes de rightArray[].
        while (j < n2) {
            arreglo[k] = rightArray[j];
            texto += rightArray[j] + " " + "\n";
            info.add("" + rightArray[j]);
//            System.out.print(rightArray[j] + " ");
            j++;
            k++;
        }
        
        info.add("break");
        
        texto += "Datos: ";
        
        for (int l : arreglo) {
            texto += l + " ";
            info.add("" + l);
//            System.out.print(l + " ");
        }
        
        info.add("break");
        
        texto += "\n\n\n";
//        System.out.println("");
//        System.out.println("");
//        System.out.println("");

    }
}

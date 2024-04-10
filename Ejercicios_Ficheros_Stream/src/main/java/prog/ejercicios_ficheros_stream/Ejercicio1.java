/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package prog.ejercicios_ficheros_stream;

import java.io.*;

/**
 *
 * @author larapresa
 */
public class Ejercicio1 {

    public static void main(String[] a) {

        FileInputStream origen = null;
        FileOutputStream destino = null;

        try {
            File f1 = new File("AdaLovelace.txt");
            File f2 = new File("CopiaAda.txt");

            f2.createNewFile(); // Creamos el fichero si no existe
            origen = new FileInputStream(f1); // Instanciamos un objeto de tipo flujo de entrada asociado al fichero 1
            destino = new FileOutputStream(f2); // Instanciamos un objeto de tipo flujo de salida asociado al fichero 2
            int c;
            // Leemos hasta llegar a final de fichero (el byte leído será -1)
            while ((c = origen.read()) != -1) { 
                destino.write((byte) c); // escribimos byte a byte en el fichero de salida
            }
        } catch (IOException er) {  
            System.out.println("Excepción en los flujos "
                    + er.getMessage());
        } 
        finally {
            try {       
                origen.close();
                destino.close();
            } catch (IOException er) {
                er.printStackTrace();
            }
        }
    }
}

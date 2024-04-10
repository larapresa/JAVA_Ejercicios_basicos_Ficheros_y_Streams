/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ejercicios_ficheros_stream;

/**
 *
 * @author larapresa
 *
 *
 *
 *
 *
 * GENERAR UN FICHERO DE DATOS BINARIOS
 *
 * Crea un fichero de datos binarios “datosClientes.dat” que almacene registros
 * de datos personales con la siguiente estructura:  *
 * 1. Número entero. Será el índice del registro. Comienza por el número 1. (Int = 4 bytes) 
 * 2. Nombre persona. Tamaño 30 caracteres. 2 bytes por caracter
 * 3. Edad de la persona. Número entero (Int = 4 bytes) 
 * 4. Número de teléfono. Tamaño 9 caracteres. 2 bytes por caracter
 *
 * Para ello debes emplear las FileOutputStream y DataOutputStream.  *
 * Se pedirán desde teclado los datos de los nuevos clientes a dar de alta hasta
 * que el usuario/a pulse la tecla 0 para salir.  *
 * El programa, cuando dé de alta nuevos usuarios/as deberá asegurarse que se
 * coloca al final del fichero para no sobreescribir los registros anteriores.
 *
 */
import java.io.*;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("datosClientes.dat", false); // Abrir el fichero en modo de escritura desde el principio (append == false )
            DataOutputStream dos = new DataOutputStream(fos);
            Scanner scanner = new Scanner(System.in);

            int indice = 1;

           
            while (true) {
                System.out.println("Ingrese los datos del cliente a dar de alta (0 para salir):");
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                if (nombre.equals("0")) {
                    break;
                }

                System.out.print("Edad: ");
                int edad = Integer.parseInt(scanner.nextLine());

                System.out.print("Número de teléfono: ");
                String telefono = scanner.nextLine();

                // Escribir los datos en el fichero
                dos.writeInt(indice);
                dos.writeChars(padString(nombre, 30)); 
                dos.writeInt(edad);
                dos.writeChars(padString(telefono, 9));

                indice++;
            }

            // Cerrar recursos
            dos.close();
            fos.close();
            scanner.close();

            System.out.println("Fichero datosClientes.dat creado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al operar con el fichero: " + e.getMessage());
        }
    }

    // Método para asegurar que el string tenga una longitud específica
    // genera una cadena de caracteres con un tamaño específico length, 
    // alineando el contenido a la izquierda (%-) y truncando o rellenando 
    // con espacios según sea necesario. 
    // Esto es útil para formatear cadenas de manera que tengan una longitud predefinida.
    public static String padString(String str, int length) {
        return String.format("%-" + length + "s", str).substring(0, length);
    }
}

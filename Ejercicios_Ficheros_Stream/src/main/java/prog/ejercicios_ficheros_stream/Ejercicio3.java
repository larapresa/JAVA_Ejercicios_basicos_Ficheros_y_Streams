/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ejercicios_ficheros_stream;

/**
 *
 * @author larapresa
 *
 * Realiza un programa que lea de manera secuencial el fichero de datos binarios
 * creado en en el ejercicio anterior y muestre los datos por pantalla. Debemos
 * de conocer qué información está escrita (tamaño y formato del registro) para
 * poder leerla correctamente
 *
 * 1. Número entero. Será el índice del registro. Comienza por el número 1. (Int = 4 bytes) 
 * 2. Nombre persona. Tamaño 30 caracteres. 2 bytes por caracter
 * 3. Edad de la persona. Número entero (Int = 4 bytes) 
 * 4. Número de teléfono. Tamaño 9 caracteres. 2 bytes por caracter
 */

import java.io.*;

public class Ejercicio3 {

    public static void main(String[] args) {

        char[] cadena1 = new char[30];
        char[] cadena2 = new char[9];
        String nombre;
        String telefono;

        try {
            FileInputStream fis = new FileInputStream("datosClientes.dat");
            DataInputStream dis = new DataInputStream(fis);

            while (true) {
                try {
                    // Leer los datos en el orden en que fueron escritos
                    int entero = dis.readInt();
                    for (int i = 0; i < 30; i++) {
                        cadena1[i] = dis.readChar();
                    }
                    nombre = new String(cadena1);
                    int edad = dis.readInt();
                    for (int i = 0; i < 9; i++) {
                        cadena2[i] = dis.readChar();
                    }
                    telefono = new String(cadena2);

                    // Mostrar los datos de cada cliente
                    System.out.println("------------------------------------");
                    System.out.println("Cliente número: " + entero);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Edad: " + edad);
                    System.out.println("Teléfono: " + telefono);
                    System.out.println("------------------------------------");
                } catch (EOFException e) {
                    break; // Se alcanzó el final del archivo
                }
            }

            // Cerrar los flujos de entrada
            dis.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

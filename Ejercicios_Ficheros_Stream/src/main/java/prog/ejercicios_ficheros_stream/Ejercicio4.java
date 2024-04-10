/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ejercicios_ficheros_stream;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author larapresa
 *
 * Debemos de conocer qué información está escrita (tamaño y formato del
 * registro) para poder leerla correctamente
 *
 * 1. Número entero (índice del registro): 4 bytes (int). 
 * 2. Nombre de la persona (30 caracteres): 60 bytes 
 * 3. Edad de la persona: 4 bytes (int). 
 * 4. Número de teléfono (9 caracteres) : 18 bytes
 *
 * TOTAL = 4 + 60 + 4 + 18 = 86 bytes
 *
 * 1º registro: del byte 0 al 85 2º registro: del byte 86 al 177
 *
 * registro N = 86*N
 */
public class Ejercicio4 {

    public static void main(String[] args) {

        char[] cadena1 = new char[30];
        char[] cadena2 = new char[9];
        String nombre;
        String telefono;
        int numCliente;

        Scanner teclado = new Scanner(System.in);

        try {
            // Abrir el fichero en modo lectura/escritura
            RandomAccessFile raf = new RandomAccessFile("datosClientes.dat", "rw");
            System.out.println("El fichero contiene " + raf.length() / 85 + " clientes.");
            System.out.println("Indica el número de cliente que quieres consultar:");
            numCliente = teclado.nextInt();
            while (numCliente > raf.length() / 85) {
                System.out.println("El cliente no existe");
                System.out.println("El fichero contiene " + raf.length() / 85 + " clientes.");
                System.out.println("Indica el número de cliente que quieres consultar:");
                numCliente = teclado.nextInt();
            }

            // Ir a la posición de inicio del cliente indicado
            raf.seek((numCliente - 1) * 86);
            // Leer el registro
            // Leer los datos en el orden en que fueron escritos
            int entero = raf.readInt();
            for (int i = 0; i < 30; i++) {
                cadena1[i] = raf.readChar();
            }
            nombre = new String(cadena1);
            int edad = raf.readInt();
            for (int i = 0; i < 9; i++) {
                cadena2[i] = raf.readChar();
            }
            telefono = new String(cadena2);
            // Mostrar los datos de cada cliente
            System.out.println("------------------------------------");
            System.out.println("Cliente número: " + entero);
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Teléfono: " + telefono);
            System.out.println("------------------------------------");

            // Cerrar el RandomAccessFile
            raf.close();

        } catch (IOException e) {
            System.out.println("Error al operar con el fichero: " + e.getMessage());
        }
    }
}

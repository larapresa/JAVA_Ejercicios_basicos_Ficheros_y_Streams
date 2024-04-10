/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5_SerializacionObjetos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author larapresa
 */
public class Ejercicio5 {
    
    public static void main(String[] args) {
        // Crear un objeto Vehiculo y un objeto Persona
        Vehiculo vehiculo = new Vehiculo("Coche", 10000, "1234ABC");
        Persona persona = new Persona("12345678A", "Juan", 30, vehiculo);

        // Serializar el objeto Persona a un archivo
        try {
            FileOutputStream fileOut = new FileOutputStream("personas.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(persona);
            objectOut.close();
            fileOut.close();
            System.out.println("Objeto Persona serializado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserializar el objeto Persona desde el archivo
        try {
            FileInputStream fileIn = new FileInputStream("personas.dat");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Persona personaDeserializada = (Persona) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            System.out.println("Objeto Persona deserializado correctamente:");
            System.out.println(personaDeserializada);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
   
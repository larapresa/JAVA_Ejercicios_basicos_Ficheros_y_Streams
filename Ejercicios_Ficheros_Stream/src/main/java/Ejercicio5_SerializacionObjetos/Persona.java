/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5_SerializacionObjetos;

import java.io.Serializable;

/**
 *
 * @author larapresa
 */
public class Persona implements Serializable {

    private String DNI;
    private String nombre;
    private int edad;
    private Vehiculo vehiculo;

    public Persona(String DNI, String nombre, int edad, Vehiculo vehiculo) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.edad = edad;
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Persona [DNI=" + DNI + ", nombre=" + nombre + ", edad=" + edad + ", vehiculo=" + vehiculo + "]";
    }
}

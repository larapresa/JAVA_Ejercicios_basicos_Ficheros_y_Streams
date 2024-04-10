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
// Clase Vehiculo
public class Vehiculo implements Serializable {
    private String tipo;
    private double kilometros;
    private String matricula;

    public Vehiculo(String tipo, double kilometros, String matricula) {
        this.tipo = tipo;
        this.kilometros = kilometros;
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Vehiculo [tipo=" + tipo + ", kilometros=" + kilometros + ", matricula=" + matricula + "]";
    }
}
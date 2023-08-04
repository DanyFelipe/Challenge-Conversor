/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conversor;

import java.text.DecimalFormat;
import java.util.List;

public class Temperatura extends Unidad{
    
    public Temperatura(String nombre, String simbolo) {
        super(nombre, simbolo);
        unidadesRegistradas.add(this);
    }
    
    public static List<Unidad> getUnidadesRegistradas() {
        return unidadesRegistradas;
    }

    @Override
    public String convertir(Unidad unidadDestino, double cantidad) {
        
        double resultado;
        DecimalFormat df = new DecimalFormat("#.##");
        
        if (this.getNombre().equals("Celsius") && unidadDestino.getNombre().equals("Fahrenheit")) {
            System.out.println("hola");
            resultado = (cantidad * 9 / 5) + 32;
        } else if (this.getNombre().equals("Fahrenheit") && unidadDestino.getNombre().equals("Celsius")) {
            resultado = (cantidad - 32) * 5 / 9;
        } else if (this.getNombre().equals("Celsius") && unidadDestino.getNombre().equals("Kelvin")) {
            resultado = cantidad + 273.15;
        } else if (this.getNombre().equals("Kelvin") && unidadDestino.getNombre().equals("Celsius")) {
            resultado = cantidad - 273.15;
        } else if (this.getNombre().equals("Fahrenheit") && unidadDestino.getNombre().equals("Kelvin")) {
            resultado = (cantidad + 459.67) * 5 / 9;
        } else if (this.getNombre().equals("Kelvin") && unidadDestino.getNombre().equals("Fahrenheit")) {
            resultado = cantidad * 9 / 5 - 459.67;
        } else {
            resultado = 0;
        }

        return ""+df.format(resultado)+unidadDestino.getSimbolo();
    }
}

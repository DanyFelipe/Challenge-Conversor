/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conversor;

import java.util.ArrayList;
import java.util.List;


public abstract class Unidad {
    
    private String nombre, simbolo;
    protected static List<Unidad> unidadesRegistradas = new ArrayList<>();

    public Unidad(String nombre, String simbolo) {
        this.nombre = nombre;
        this.simbolo = simbolo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }
    
    public static List<Unidad> getUnidadesRegistradas() {
        return unidadesRegistradas;
    }
    
    public abstract String convertir(Unidad unidadDestino, double cantidad);
}

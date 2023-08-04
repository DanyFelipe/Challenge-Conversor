/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conversor;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class Moneda extends Unidad{
    
    private String pais;
    private double valor;

    public Moneda(String nombre, String pais, String simbolo, double valor) {
        super(nombre, simbolo);
        this.pais = pais;
        this.valor = valor;
        unidadesRegistradas.add(this);
    }

    public String getPais() {
        return pais;
    }

    public double getValor() {
        return valor;
    }
    
    public static List<Unidad> getUnidadesRegistradas() {
        return unidadesRegistradas;
    }
    
    public String formatear(double resul, String symbolDestino){
        
        Currency monedaEspecifica = Currency.getInstance(symbolDestino); 
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
        formatoMoneda.setCurrency(monedaEspecifica);

        // Formatea el número como la moneda específica
        String precioFormateado = formatoMoneda.format(resul);

        System.out.println("Precio formateado como moneda específica: " + precioFormateado);
        
        return precioFormateado;
    }
    
    @Override
    public String convertir(Unidad unidadDestino, double cantidad) {
        
        double resul = 0;
        Moneda monedaDestino = (Moneda) unidadDestino;
        
        if (!this.equals(unidadDestino) && monedaDestino.getValor() != 0) {
            
            System.out.println("Moneda local: "+this.valor+" Moneda destino: "+monedaDestino.getValor());
            resul = cantidad * (monedaDestino.getValor() / this.valor);
            return formatear(resul, monedaDestino.getSimbolo());
        } else {
            
            return String.valueOf(resul);
        }
    }
}

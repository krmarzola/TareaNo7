/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conceptosavanzados.pspprogram7.utilitarios;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Kevin Ray Marzola Otero
 */
public class CalcularCoeficientes 
{
    private double B1;
    private double r;
    private double r2;
    private double Yk;
    private LinkedList<Double> valoresX;     
    private LinkedList<Double> valoresY;
    private double Xk;      
    private double B0;
    
    /**
     * Obetener parametro B0
     * @return numero tipo double 
     */
    public double getB0()
    {
        return B0;
    }
    
    /**
     * Obetener parametro B1
     * @return numero tipo double 
     */
    public double getB1()
    {
        return B1;
    }
    
    /**
     * Obetener parametro R
     * @return numero tipo double 
     */
    public double getR()
    {
        return r;
    }
    
    /**
     * Obetener parametro R2
     * @return numero tipo double 
     */
    public double getR2()
    {
        return r2;
    }
    
    /**
     * Obetener parametro Yk
     * @return numero tipo double 
     */
    public double getYk()
    {
        return Yk;
    }
    
    /**
     * Setter para el valor estimado
     * @param valor valor estimado
     */
    public void setXk(double valor)
    {
        Xk = valor;             
    }
    
    /**
     * Setter para el la lista enlazada con los valores X
     * @param valoresXdouble Objetito de Tipo LinkedList double 
     */
    public void setValoresX(LinkedList<Double> valoresXdouble)
    {
        valoresX = valoresXdouble;         
    }
    
    /**
     * Setter para el la lista enlazada con los valores Y
     * @param valoresYdouble Objetito de Tipo LinkedList double 
     */
    public void setValoresY(LinkedList<Double> valoresYdouble)
    {
        valoresY = valoresYdouble;         
    }
    
    /**
     * Metodo Coordina el calculo de todos lo coeficientes
     */
    public void Calcular()
    {        
        calcularB1();
        calcularB0();
        calcularYk();
        calcularR();
    }
    
    /**
    *  Metodo que calcula el coeficientes B1
    */
    private void calcularB1()
    {
        double cantidadDatos = valoresX.size();
        double parteA =  OperacionesNumericas.calcularProductoria(valoresX, valoresY);
        double parteB = cantidadDatos*   OperacionesNumericas.calcularMedia(valoresX) *   OperacionesNumericas.calcularMedia(valoresY);
        double parteC =   OperacionesNumericas.calcularProductoria(valoresX);
        double parteD = cantidadDatos *   OperacionesNumericas.calcularMedia(valoresX)*  OperacionesNumericas.calcularMedia(valoresX);
        
        B1 = (parteA-parteB)/(parteC-parteD);
    }
    
    /**
     * Metodo que calcula el coeficientes B0
     */
    private void calcularB0()
    {
        B0 =  OperacionesNumericas.calcularMedia(valoresY) - (B1 *  OperacionesNumericas.calcularMedia(valoresX));
    }

    /**
     * Metodo que calcula el coeficientes Yk
     */
    private void calcularYk()
    {
        Yk = B0 + (B1*Xk); 
    }
    
    /**
    * Metodo que calcula el coeficientes r
    */
    private void calcularR()
    {   
        double cantidadDatos = valoresX.size();
        double parteA = cantidadDatos *  OperacionesNumericas.calcularProductoria(valoresX, valoresY);
        double parteB =  OperacionesNumericas.calcularSumatoria(valoresX) *  OperacionesNumericas.calcularSumatoria(valoresY);
        double parteC = (cantidadDatos *  OperacionesNumericas.calcularProductoria(valoresX))- ( OperacionesNumericas.calcularSumatoria(valoresX)*  OperacionesNumericas.calcularSumatoria(valoresX));
        double parteD = (cantidadDatos *  OperacionesNumericas.calcularProductoria(valoresY))- ( OperacionesNumericas.calcularSumatoria(valoresY)*  OperacionesNumericas.calcularSumatoria(valoresY));
        r = (parteA-parteB)/(Math.sqrt(parteC*parteD));
        r2 = r*r;
    }
    
    /**
     * Metodo que imprime los resultados de los calculos realizados
     * @return retorna String con los resultados de los coeficientes obtenidos
     */
    @Override
    public String toString() 
    {
        return "- B0: " + B0 + "\n" + "- B1: " + B1 + "\n" + "- r: " + r + "\n" + "- r^2: " + r2 + " \n" + "- Xk: " + Xk +  "\n" +  "- Yk: " + Yk;        
    };
}

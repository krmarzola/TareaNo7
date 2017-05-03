/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conceptosavanzados.pspprogram7.utilitarios;

import java.util.LinkedList;

/**
 *
 * @author Kevin Ray Marzola Otero
 */
public class CalcularIndicadores 
{
    private double B0;
    private double B1;
    private double r2;
    private double r;
    private double xPrima;
    private double xk;
    private double significancia;
    private double numeroDatos;
    private double UPI;
    private double LPI;
    private double yk;
    private double p;
    private double rango;
    private LinkedList<Double> xi;
    private LinkedList<Double> yi;
    private final double ERROR_ACEPTABLE = 0.00000001D;

    public double getSignificancia() 
    {
        return significancia;
    }

    public double getB0() 
    {
        return B0;
    }

    public double getR2() 
    {
        return r2;
    }

    public double getR() 
    {
        return r;
    }

    public double getB1() 
    {
        return B1;
    }

    public double getUPI() 
    {
        return UPI;
    }

    public double getLPI() 
    {
        return LPI;
    }

    public double getYk() 
    {
        return yk;
    }

    public void setP(double p) 
    {
        this.p = p;
    }

    public double getRango() 
    {
        return rango;
    }

    public void setXk(double xk) 
    {
        this.xk = xk;
    }
       
    public void setValoresX(LinkedList<Double> valoresXint)
    {
        xi = valoresXint;		
    }

    public void setValoresY(LinkedList<Double> valoresYint)
    {
        yi = valoresYint;		
    }

    /**
    * Metodo que calcula los indicadores
    */
    public void calcularIndicadores()
    {
        CalcularCoeficientes objetoCoeficientes = new CalcularCoeficientes();
        CalcularIntegral objetoIntegral = new CalcularIntegral();
        CalcularIntegralError objectoIntegralError = new CalcularIntegralError();
        numeroDatos = xi.size();

        objetoCoeficientes.setValoresX(xi); 
        objetoCoeficientes.setValoresY(yi);
        objetoCoeficientes.setXk(xk);
        objetoCoeficientes.Calcular();

        B0 = objetoCoeficientes.getB0();
        B1 = objetoCoeficientes.getB1();
        yk = objetoCoeficientes.getYk();
        r2 = objetoCoeficientes.getR2();
        r = objetoCoeficientes.getR();
        xPrima = OperacionesNumericas.calcularXSignificancia((int)numeroDatos,objetoCoeficientes.getR());

        objetoIntegral.setDof((int)numeroDatos-2);
        objetoIntegral.setNumSeg(28);
        objetoIntegral.setX(xPrima);
        objetoIntegral.calculaRp();
		
    	significancia= 1-(2*objetoIntegral.getP());
    				
	objectoIntegralError.setErrorAceptable(ERROR_ACEPTABLE);
    	objectoIntegralError.setGradosLibertdad((int)numeroDatos - 2);
    	objectoIntegralError.setP(p);
    	objectoIntegralError.calcularX();
    	
    	rango = OperacionesNumericas.calcularRango(objectoIntegralError.getX(), numeroDatos, xk, yi, xi, B0, B1);
        UPI = yk + rango;
        LPI = yk - rango;
    }
}

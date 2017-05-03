/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conceptosavanzados.pspprogram7.utilitarios;

/**
 * Clase que calcula la Integral con un margen de error aceptable
 * @author Kevin Ray Marzola Otero
 * @version V 1.0
 * @since 17/04/2017.
 */
public class CalcularIntegralError 
{
    private double errorAceptable;
    private double errorActual;
    private double errorAnterior;
    private double valorIncrenental = 0.5D;
    private int numeroCiclo = 2;
    private int dof;
    private double p;
    private double x = 1;

    public double getX() 
    {
        return x;
    }

    public void setP(double p) 
    {
        this.p = p;
    }

    public void setErrorAceptable(double errorAceptable) 
    {
        this.errorAceptable = errorAceptable;
    }

    public void setGradosLibertdad(int dof) 
    {
        this.dof = dof;
    }

    /**
    * Metodo que calcula la variable X
    */
    public void calcularX()
    {
        CalcularIntegral integral = new CalcularIntegral();

        integral.setDof(dof);
        integral.setNumSeg(10);
        double resultadoIntegral = 0D;
        do
        {	
            integral.setX(x);
            integral.calculaRp();
            resultadoIntegral = integral.getP();
            errorActual = p - resultadoIntegral;

            if(numeroCiclo == 2)
            {
                errorAnterior = errorActual;
            }

            if(OperacionesNumericas.validarSigno(errorActual, errorAnterior))
            {
                valorIncrenental = valorIncrenental/2;
            }

            if(p > resultadoIntegral)
            {
                x += valorIncrenental;
            }
            else
            {
                x -= valorIncrenental;
            }

            errorAnterior = errorActual;
            numeroCiclo += 2;
        }
        while(Math.abs(errorActual) > errorAceptable);
    }
	
}

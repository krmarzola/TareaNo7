/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conceptosavanzados.pspprogram7.utilitarios;
/**
 * Clase que realiza el calculo de la integral de 0 a X mediante el metodo Simpson
 * @author Kevin Ray Marzola Otero
 * @version V 1.0
 * @since 17/04/2017.
 */
public class CalcularIntegral 
{
    private int numSeg;
    private double W;
    private double X;
    private int dof;
    private double p;
          
    
    /**
     * Metodo Coordina el calculo de la integral por el metodo de Simpson
     * @param X valor de X (las interacciones empiezan de 0 a X)
     * @param dof parametro que tiene los grados de libertad que tiene los grados de libertad
     * @param numSeg numero inicial de segmentos de la integral
     * @return String con el valor de la integral
     */
    public String calcular(double X, int dof, int numSeg)
    {        
        setX(X);
        setDof(dof);
        setNumSeg(numSeg);
        calculaRp();
        return toString();
    }

    /**
    * Metodo que calcula la variable P
    */
    public void calculaRp() 
    {
        int multiplicador;
        double xi = 0;
        p=0;
        calcularW();

        for(int indice = 0; indice <= numSeg ;indice++)
        {

            if(indice == 0 || indice == numSeg)
            {
                    multiplicador = 1;				
            }
            else if(indice % 2 == 0)
            {
                    multiplicador = 2;	
            }
            else
            {
                    multiplicador = 4;	
            }
            p += OperacionesNumericas.calcularFx(dof,xi) * multiplicador * (W/3);
            xi += W;
        }
    }


    /**
     * Metodo que calcula la variable W
     */
    public void calcularW() 
    {
        W=X/numSeg;
    }
    
    /**
     * Metodo que setea el valor de num_seg y valida que el parametro sea par
     * @param numSeg parametro num_seg
     */
    public void setNumSeg(int numSeg) 
    {
        if(numSeg % 2 ==0)
        {
                this.numSeg = numSeg;
        }
        else
        {
                System.out.println("el numero de segundos debe ser par");
                System.exit(0);
        }
    }

    /**
     *  Setter para el parametro X
     * @param X valor a setear
     */
    public void setX(double X) 
    {
        this.X = X;
    }

    /**
     * Setter para el parametro dof
     * @param dof valor a setear
     */
    public void setDof(int dof) 
    {
        this.dof = dof;
    }

    /**
     * Getter para el parametro P
     * @return retorna el valor P
     */
    public double getP() 
    {
        return p;
    }
    
    /**
     * Getter para el parametro W
     * @return retorna el valor W
     */
    public double getW() 
    {
        return W;
    }
        
}

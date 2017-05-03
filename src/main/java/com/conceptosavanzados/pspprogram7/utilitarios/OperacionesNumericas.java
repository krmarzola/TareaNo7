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
public class OperacionesNumericas 
{
    /**
    * Método calcula la media de un LinkedList tipo double
    * @param listaDeNumeros listado de numeros
    * @return retorna la media calcula de variable tipo double
    */
    public static double calcularMedia(LinkedList<Double> listaDeNumeros)
    { 
        double sumatoria = 0;
        for(double valor : listaDeNumeros)
        {
            sumatoria += valor;
        }
        return ((double)sumatoria/(double)listaDeNumeros.size());    
    }
    
    /**
    * Metodo calcula la productoria de dos LinkedList tipo double
    * @param valoresX es un LinkedList tipo double
    * @param valoresY es un LinkedList tipo dobule
    * @return variable de tipo double
    */    
    public static double calcularProductoria(LinkedList<Double> valoresX, LinkedList<Double> valoresY)
    {
        if(valoresX.size() != valoresY.size())
        {
            System.out.println("los arreglos no tienen el mismo tamaño");
            System.exit(2);
        }
        
        int totalNumeros = valoresX.size();
        double acumulador = 0D;
        for(int indiceMultiplicacion = 0; indiceMultiplicacion< totalNumeros; indiceMultiplicacion++)
        {
            acumulador += valoresX.get(indiceMultiplicacion)*valoresY.get(indiceMultiplicacion);
        }
        
        return acumulador;
    }
    
    /**
    * Metodo calcula la sumatoria de un LinkedList tipo double
    * @param valoresX es un LinkedList tipo double
    * @return variable de tipo double 
    */     
    public static double calcularSumatoria(LinkedList<Double> valoresX)
    {
        double acumulador = 0;
        for(Double valor : valoresX)
        {
            acumulador +=valor;             
        }
        return acumulador;
    }
    
    /**
    * Metodo que calcula la productoria de un Arraylist tipo double
    * @param valoresX es un ArrayList tipo double
    * @return variable de tipo double
    */      
    public static double calcularProductoria(LinkedList<Double> valoresX)
    {
        if(valoresX.size() != valoresX.size())
        {
            System.out.println("los arreglos no tienen el mismo tamaño");
            System.exit(2);
        }
        int totalNumeros = valoresX.size();
        double acumulador = 0D;
        for(int indiceMultiplicacion = 0; indiceMultiplicacion< totalNumeros; indiceMultiplicacion++)
        {
            acumulador += valoresX.get(indiceMultiplicacion)*valoresX.get(indiceMultiplicacion);
        }
        return acumulador;
    }
    /**
     * Método que calcula la sumatoria de logaritmo natural de un listado de valores
     * @param valores lista de valores tipo double
     * @return Valor tipo double
     */
    public static double calcularLn(LinkedList<Double> valores)
    {	
        double acumulador = 0;
        for(double valor : valores)
        {
            acumulador += Math.log(valor);
        }
        return acumulador;
    }
    /**
     * Metodo que calcula la sumatoria de logaritmo natural sobre el promedio
     * @param valores listado de valores 
     * @param AVG parametro AVG
     * @return variable de tipo double
     */
    public static double calcularLnAVG(LinkedList<Double> valores, double AVG)
    {	
        double acumulador = 0;
        for(double valor : valores)
        {
            acumulador += Math.pow((Math.log(valor) - AVG),2);
        }
        return acumulador;
    }
    
    /**
     * Metodo que calcula el valor Gamma a partir de los dof
     * @param dof grados de libertad
     * @return parametro Gamma de tipo double
     */
    public static double calcularGama(double dof)
    {	
        int parteEntera= (int)dof;
        double resultado = 1;		 
        double ParteDecimal = dof - parteEntera;

        if(ParteDecimal == 0)
        {
            parteEntera -=1;
            for(int indice = parteEntera; indice > 1; indice--)
            {
                resultado *= indice;
            }
            return resultado;
        }
        else
        {
            return gamma(dof);
        }
    }
    
    /**
     * Metodo que calcula el valor gamma realizando un despeje de la ecuación de F(X = 0)
     * @param dof parametros de grados de libertad
     * @return  variable tipo double
     */
    private static double gamma(double dof) 
    { 
        return Math.exp(logGamma(dof)); 
    }

    /**
     * Metodo que calcula el valor de Gamma continuando el despeje de la ecuación de F(X = 0)
     * @param dof parametros de grados de libertad
     * @return variable tipo double
     */
    private static double logGamma(double dof) 
    {
        double tmp = (dof - 0.5) * Math.log(dof + 4.5) - (dof + 4.5);
        double ser = 1.0 + 76.18009173 / (dof + 0) - 86.50532033 / (dof + 1) + 24.01409822 / (dof + 2) - 1.231739516 / (dof + 3) + 0.00120858003 / (dof + 4) - 0.00000536382 / (dof + 5);
        return tmp + Math.log(ser * Math.sqrt(2 * Math.PI));
    }
    
    /**
     * Metodo que calcula el valor de F(x) para una interacción
     * @param dofexterno grados de libertad (dof)
     * @param xi valor de la interaccion 
     * @return variable de tipo double con el valor de F(x) para esta interacción
     */
    public static double calcularFx(int dofexterno, double xi)
    {	
        double dof = dofexterno;
        double parteA = calcularGama((dof+1)/2);
        double parteB = (Math.pow(dof*Math.PI,0.5))*(calcularGama(dof/2));
        double parteC = Math.pow((1+(Math.pow(xi,2)/dof)),(-(dof+1)/2));
        return (parteA/parteB)*parteC;
    }
    
    /**
     *  Metodo que valida que el error no sean valores menores que cero de las iteracciones realizadas
     * @param errorActual errorActual ingresado
     * @param errorAnterior errorAnterior ingresado
     * @return booleano
     */
    public static boolean validarSigno(double errorActual, double errorAnterior)
    {
        boolean SignoAcutal = enmascararSigno(errorActual);
        boolean SignoAnterior = enmascararSigno(errorAnterior);
        if(SignoAcutal != SignoAnterior)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     *  Metodo que valida que el error no tenga un valor negativo
     * @param valorError valor del error ingresado
     * @return booleano 
     */
    private static boolean enmascararSigno(double valorError)
    {
        if(valorError > 0)
        {
            return true;
        }
        else if(valorError < 0)
        {
            return false;	
        }
        System.out.print("Error el valor 0 no pose signo");
        System.exit(0);

        return false;
    }
    
    /**
     *  Metodo que realiza el calculo de la operacion aritmetica definida
     * @param numeroDatos cantidad de datos ingresados
     * @param yi valor yi
     * @param xi valor xi
     * @param B0 valor B0
     * @param B1 valor B1
     * @return numero tipo double
     */
    private static double calcularo(double numeroDatos, LinkedList<Double> yi, LinkedList<Double> xi, double B0, double B1) 
    {
        return Math.sqrt((1/(numeroDatos-2))*calcularsumatoria(numeroDatos, yi, xi, B0, B1));
    }
    
    /**
     * Metodo que calcula la sumatoria de valores de un conjunto de datos X y Y con un Bo y B1
     * @param numeroDatos numero de datos ingresados
     * @param yi valor yi
     * @param xi valor xi
     * @param B0 valor B0
     * @param B1 valor B1
     * @return numero tipo double
     */
    private static double calcularsumatoria(double numeroDatos, LinkedList<Double> yi, LinkedList<Double> xi, double B0, double B1)
    {
        double acumulador = 0D;
        for(int indiceMultiplicacion = 0; indiceMultiplicacion< numeroDatos; indiceMultiplicacion++)
        {
            acumulador += Math.pow((yi.get(indiceMultiplicacion) - B0 - (B1*xi.get(indiceMultiplicacion))),2);
        }
        return acumulador;
    }
	
    /**
     * Metodo que calcula los intervalos 
     * @param xPrima valor xprima
     * @param numeroDatos cantidad de datos ingresados xi, yi
     * @param xk valor estimado Xk
     * @param yi valor yi
     * @param xi valor xi
     * @param B0 valor B0
     * @param B1 valor B1
     * @return numero tipo double
     */
    public static double calcularRango(double xPrima, double numeroDatos, double xk, LinkedList<Double> yi, LinkedList<Double> xi, double B0, double B1)
    {    	
        double parteA = Math.pow((xk - OperacionesNumericas.calcularMedia(xi)),2);
        double parteB = parteA/(calcularAVG2(xi,OperacionesNumericas.calcularMedia(xi))); 
        double parteC = Math.sqrt(1+(1/numeroDatos)+parteB);
        return xPrima * calcularo(numeroDatos, yi, xi, B0, B1) * parteC;   
    }	

    /**
     * Metodo que calcula el grado de significancia de un numero
     * @param numeroDatos numero de datos ingresados
     * @param r valor de R
     * @return numero tipo double
     */
    public static double calcularXSignificancia(int numeroDatos, double r)
    {
        return (Math.abs(r)*Math.sqrt(numeroDatos-2))/(Math.sqrt(1-Math.pow(r,2)));
    }
    
    /**
     * Metodo que calcula el valor promedio al cuadrado de un listado de valores
     * @param valores listado de numeros ingresados 
     * @param AVG valor promedio
     * @return numero tipo double
     */
    public static double calcularAVG2(LinkedList<Double> valores, double AVG)
    {	
        double acumulador = 0;
        for(double valor : valores)
        {
            acumulador += Math.pow((valor - AVG),2);
        }
        return acumulador;
    }
    
}

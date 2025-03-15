/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ValorMedio;

import org.nfunk.jep.JEP;

/**
 *
 * @author jhosu
 */
public class LogicaFuncion {

    int firstNumber;
    private String funcion = "";
    private double resultado = 0.0;
    private double valorX = 0.0;
    private String error = "";

    JEP jep;

    public LogicaFuncion() {
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public void setValorx(double valorX) {
        this.valorX = valorX;
    }

    public double getResultadoFuncion() {
        return this.resultado;
    }

    public String getError() {
        return this.error;
    }

    public void evaluar() {
        jep = new JEP();

        this.jep.addStandardFunctions();
        this.jep.addStandardConstants();
        this.jep.addVariable("x", this.valorX);

        this.jep.parseExpression(this.funcion);

        this.resultado = this.jep.getValue();

        this.error = (this.jep.hasError()) ? "EXISTE UN ERROR " : "NO HAY ERROR";

    }

    public LogicaFuncion(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double ecuacionVMedio(double a, double b, double fb, double fa) {

        double thirdNum = (fb - fa) / (b - a);
        System.out.println(thirdNum);

        return thirdNum;
    }
    
    
    
    public String recorrerDerivada(String derivadaexpresion){
        
        
        String expresionLimpia = derivadaexpresion.replaceAll("[^\\d.+-]", "");
        
        String[] terminos = expresionLimpia.split("(?=[+-])");
        
        double coeficienteCons = 0.0;
        double coeficiente2 = 0.0;
        
        for(String termino : terminos){
            try{
                double coeficiente = Double.parseDouble(termino);
                if(termino.contains("x")){
                    coeficiente2 = coeficiente;
                }else{
                    coeficienteCons = coeficiente;
                    
                }
            }catch (NumberFormatException e){
                
            }
            
        }
        
        System.out.println("recorrer " + coeficienteCons);
        System.out.println("recorrer2" + coeficiente2 );
        
        
//        for (int i = 0; i < derivadaC.length(); i++) {
//            char elemento = derivadaC.charAt(i);
//            System.out.println("Elemento " + i + ": " + elemento);
//        }
        return "1";
    }
    
    
    public double valorDeC(double a, double b, double c){
        
        double valorC = (c - b) / a;
        
        return valorC;
    }

//        public double ecuacionLineal(int firstNumber, int secondNumber){
//        String operador = "+";
//        double constantC = 0.0;
//       
//        double thirdNumber = ecuacionVMedio(1,3,36,4);
//            
//        if(operador == "+"){
//            constantC = (thirdNumber - secondNumber) / firstNumber;
//            System.out.println(constantC); 
//        }else {
//            constantC = (thirdNumber + secondNumber) / firstNumber;
//        System.out.println(constantC);
//        }
//        return constantC;  
//    }
//    String num = intervalo1.getText();
//        String interva2 = intervalo2.getText();
//        int numpar1 = Integer.parseInt(num);
//        int numpar2 = Integer.parseInt(interva2);
//        
//        double result = fun.ecuacionLineal(numpar1, numpar2);
//        String show = String.valueOf(result);
//        showResult.setText(show);
//    
}

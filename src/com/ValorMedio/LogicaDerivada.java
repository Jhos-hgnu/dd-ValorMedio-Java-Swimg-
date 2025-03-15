/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ValorMedio;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;
/**
 *
 * @author jhosu
 */
public class LogicaDerivada {
    
    private String function = "";
    
    DJep djep;
    Node nodoFuntion;
    Node nodoDerivada;
    
    public LogicaDerivada(){  
    }
    
    public void setFuncionDerivar(String function){
        this.function = function;
        
    }
    
    public String getFuncionDerivada(){
        return this.function;
    }
    
    public void derivar(){
        
        try {
            
            this.djep = new DJep();
            
            this.djep.addStandardFunctions();
            
            this.djep.addStandardConstants();
            
            this.djep.addComplex();
            
            this.djep.setAllowUndeclared(true);
            
            this.djep.setAllowAssignment(true);
            
            this.djep.setImplicitMul(true);
            
            this.djep.addStandardDiffRules();
            
            this.nodoFuntion = this.djep.parse(this.function);
            
            Node diff = this.djep.differentiate(nodoFuntion, "x");
            
            this.nodoDerivada = this.djep.simplify(diff);
            
            this.function = this.djep.toString(this.nodoDerivada);
            
        } catch (ParseException e) {
            System.out.println("ERROR" + e.getErrorInfo());
        }
        
            
        }
    
}

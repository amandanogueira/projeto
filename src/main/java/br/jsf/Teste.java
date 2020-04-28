/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PC
 */
public class Teste {

    public static void main(String args[]) {

        /**
         * String string = "{codigo=12, cidade=Assis}";
         *
         * String[] separadorVirgula = string.split(","); String parte1 =
         * separadorVirgula[0];//split the string to creat key-value pairs
         * String[] separadorIgual = parte1.split("="); String codigo =
         * separadorIgual[1]; System.out.println("codigo: " + codigo);
         */
        String string = "{codigo=1, cidade='Assis'}";
        /*value = value.substring(1, value.length() - 1);           
        String[] keyValuePairs = value.split(",");              
        Map<String, String> map = new HashMap<>();

        for (String pair : keyValuePairs) 
        {
            String[] entry = pair.split("=");                   
            map.put(entry[0].trim(), entry[1].trim());          
        }*/
        
        
        
        String[] separadorVirgula = string.split(",");
            String parte2 = separadorVirgula[0];
            String[] separadorIgual = parte2.split("=");
            String codigo = separadorIgual[1];
            System.out.println("Código: " + codigo);
    }
}

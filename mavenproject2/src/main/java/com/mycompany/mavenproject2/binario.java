/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stida
 */
public class binario {
    static List<Integer>listEnteros;
    
    static int numeroRandom=(int)
            (Math.random()*10+1);
    
    public static void main(String[]args){
        listEnteros=new ArrayList<>();
        listEnteros.add(1);
        listEnteros.add(2);
        listEnteros.add(3);
        listEnteros.add(4);
        listEnteros.add(5);
        listEnteros.add(6);
        listEnteros.add(7);
        listEnteros.add(8);
        listEnteros.add(9);
        listEnteros.add(10);
        
        System.out.println("el numero aleatorio es"+numeroRandom);
        System.out.println("---------------------------------");
        
        System.out.println("Metodo de busqueda Lineal");
        metodoLineal();
        System.out.println("---------------------------------");
        
        System.out.println("metodo de busqueda binaria");
        metodoBinario();
    }
    
    public static void metodoLineal(){
    System.nanoTime();
    
    for(int numeroLista:listEnteros){
    if(numeroLista==numeroRandom){
    System.out.println("el numero seleccionado es:"+numeroLista);
    
    }
    }
    //long star
    
    }
    public static void metodoBinario(){
    int primero,centro,ultimo,valorCentral;
    
    primero=0;
    ultimo=listEnteros.size()-1;
    while(true){
        centro=(primero+ultimo)/2;
    valorCentral=listEnteros.get(centro);
    //
    //System.out.printl(valorCentro);
    
    System.out.println("comparando "+numeroRandom+" y "+valorCentral);
    if(numeroRandom==valorCentral){
    System.out.println("el numero selleccionado es: "+valorCentral);
    break;
    }
    else if(numeroRandom<valorCentral){
    ultimo=centro-1;
    }
    else{
    primero=centro+1;
    }
    }
    }
}

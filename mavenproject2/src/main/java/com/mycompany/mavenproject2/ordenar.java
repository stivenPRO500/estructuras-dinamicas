/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author stida-
 */
public class ordenar {

    public static void main(String[] args) {
         List<Integer> lista = new ArrayList<>();
        lista.add(68);
        lista.add(5);
        lista.add(100);
        
        Collections.sort(lista);
        System.out.println("Ordenado "+lista);
    }
}

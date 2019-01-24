/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.ejercicio2;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *http://www.google.com/
 * @author 2092692
 */
public class main {
    public static void main( String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        String text = scan.next();
        URL url=new URL(text);
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String inputLine = null;
            BufferedWriter p = null;
            p= new BufferedWriter(new FileWriter("resultado.html"));
            while ((inputLine = reader.readLine()) != null) {
                p.write(inputLine);
                p.close();
            }
        }catch (IOException x) {
            System.err.println(x);
        }
    }
}
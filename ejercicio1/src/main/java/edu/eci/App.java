package edu.eci;

import java.io.*;
import java.net.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception {
        
    URL google = new URL("http://www.google.com/");
    
    
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(google.openStream()))) {
        String inputLine = null;
        while ((inputLine = reader.readLine()) != null) {
            System.out.println(inputLine);
            System.out.println("getProtocol->" + google.getProtocol());
            System.out.println("getAuthority->" + google.getAuthority());
            System.out.println("getHost->" + google.getHost());
            System.out.println("getPort->" + google.getPort());
            System.out.println("getPath->" + google.getPath());
            System.out.println("getQuery->" + google.getQuery());
            System.out.println("getFile->" + google.getFile());
            System.out.println("getRef->" + google.getRef());
        }
    }catch (IOException x) {
        System.err.println(x);
    }

    
    
    }
}

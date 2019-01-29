/*
 * Escriba un servidor que reciba un número y responda el cuadrado de este número.
 */
package ejercicio431;

import java.net.*;
 import java.io.*;
/**
 *
 * @author karen
 */
 public class EchoServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 5000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        String inputLine, outputLine;
        
        while ((inputLine = in.readLine()) != null) {
            long conv= Integer.parseInt(inputLine);
            long sol=conv*conv;
            outputLine = Long.toString(sol);
            out.println(outputLine);
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
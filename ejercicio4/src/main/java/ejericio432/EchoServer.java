/**
 * Escriba un servidor que pueda recibir un número y responda con un operación
 * sobre este número. Este servidor puede recibir un mensaje que empiece 
 * por “fun:”, si recibe este mensaje cambia la operación a las especiﬁcada. 
 * 
 * El servidor debe responder las funciones seno, coseno y tangente. Por 
 * defecto debe empezar calculando el coseno. Por ejemplo, si el primer número
 * que recibe es 0, debe responder 1, si después recibe ⇡/2 debe responder 0,
 * si luego recibe “fun:sin” debe cambiar la operación actual a seno, es decir
 * a a partir de ese momento debe calcular senos. Si enseguida recibe 0 debe
 * responder 0.
 */
package ejericio432;

import java.net.*;
 import java.io.*;
import static jdk.nashorn.internal.runtime.JSType.isNumber;

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
        String inputLine,outputLine,otro;
        String let="nada";
        while ((inputLine = in.readLine()) != null) {
            
            //double num=Double.parseDouble((in.readLine()));
            double opcion=0;
            double num = 0;
            if (isNumber(inputLine) ){
                num=Double.parseDouble(inputLine);
            }else if(inputLine.equals("fun:sin")){
                let = "seno";
            }else if(inputLine.equals("fun:cos")){
                let = "coseno";
            }else if(inputLine.equals("fun:tan")){
                let = "tangente";
            }else if (let.equals("seno")){
                num = Double.parseDouble(inputLine);
                opcion = Sen(num);
            }else if (let.equals("coseno")) {
                num = Double.parseDouble(inputLine);
                opcion = Cos(num);
            } else if (let.equals("tangente")) {
                num = Double.parseDouble(inputLine);
                opcion = Tang(num);
            } else if (let.equals("nada")) {
                num = Double.parseDouble(inputLine);
                opcion = Cos(num);
            }
            
            outputLine = Double.toString(opcion);
            out.println(outputLine);
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

    private static double Sen(double i) {
        double num=Math.toRadians(i);
        double sol=Math.sin(num);
        return sol;
    }
    private static double Cos(double i) {
        double num=Math.toRadians(i);
        double sol=Math.cos(num);
        return sol;
    }
    private static double Tang(double i) {
        double num=Math.toRadians(i);
        double sol=Math.tan(num);
        return sol;
    }
}
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
 * 
 */
package ejericio432;

import java.io.*;
import java.net.*;
/**
 *
 * @author karen
 */

public class EchoClient {

    public static void main(String[] args) throws IOException {
        Socket echoSocket = null;
        
        PrintWriter out = null;
        BufferedReader in = null;
        
        try {
            echoSocket = new Socket("127.0.0.1", 5000);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don’t know about host!.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn’t get I/O for " + "the connection to: localhost.");
            System.exit(1);
        }
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("echo: " + in.readLine());
        }
        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}
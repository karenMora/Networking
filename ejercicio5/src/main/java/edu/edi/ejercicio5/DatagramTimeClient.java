/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.edi.ejercicio5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatagramTimeClient extends Thread{

     
public static void main(String[] args) {
        byte[] sendBuf = new byte[256];
        try {
            DatagramSocket socket = new DatagramSocket();
            byte[] buf = new byte[256];
            InetAddress address = InetAddress.getByName("127.0.0.1");
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
            socket.send(packet);
            
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Date: " + received);
            
            socket.setSoTimeout(5000);
        } catch (SocketException ex) {
            Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

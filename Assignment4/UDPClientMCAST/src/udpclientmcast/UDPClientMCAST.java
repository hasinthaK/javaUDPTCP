/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpclientmcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author 174001C
 */
public class UDPClientMCAST {
    
    private static final int MCAST_PORT = 50010;
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
            
//            create datagram obj
            DatagramSocket clientSocket = new DatagramSocket();
            
//            get ipaddr of server by name
            InetAddress IPAddr = null;
            
            try{
                IPAddr = InetAddress.getByName("localhost");
            }catch(UnknownHostException e) {
                e.printStackTrace();
            }
            
//            create buffers
            byte[] buffRecData = new byte[1024];
            byte[] buffSenData = new byte[1024];
            
//            send data to server
            System.out.println("Enter numbers: ");
            Scanner input = new Scanner(System.in);
            String inputData = input.nextLine();
            
//            String data = "Hello from UDP client";
            buffSenData = inputData.getBytes();
            
//            create datgram packet for sending the buff data
            DatagramPacket packetSend = new DatagramPacket(buffSenData, buffSenData.length, IPAddr, MCAST_PORT);
            
            
//            try to send to the client
            try{
                clientSocket.send(packetSend);
            }catch(IOException e) {
                e.printStackTrace();
            }
            
//            Datgram packet to get incoming data
            DatagramPacket packetReceive = new DatagramPacket(buffRecData, buffRecData.length);
            
//            try to get the data from incoming res from UDP server
            try{
                clientSocket.receive(packetReceive);
            }catch(IOException e) {
                e.printStackTrace();
            }
            
//            print the rec data
            String recData = new String(packetReceive.getData());
            System.out.println("Client Received from server: " + recData);
            
            clientSocket.close();
            
            
        }catch(SocketException e) {
            e.printStackTrace();
        }
        
        
    }
    
}

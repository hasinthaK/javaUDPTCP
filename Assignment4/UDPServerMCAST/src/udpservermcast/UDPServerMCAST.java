/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpservermcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author 174001C
 */
public class UDPServerMCAST {

    private static final int MCAST_PORT = 50010;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
            
//            Datagram socket obj
            DatagramSocket serverSocket = new DatagramSocket(MCAST_PORT);
            
//            Create buffers for data
            byte[] buffRecData = new byte[1024];
            byte[] buffSenData = new byte[1024];
            
//            datagram packet to get data
            DatagramPacket packetIn = new DatagramPacket(buffRecData, buffRecData.length);
            
//            Recieve incoming data to the packet
            try{
                System.out.println("Waiting for UDP Client..");
                serverSocket.receive(packetIn);
                
            }catch(IOException e){
                e.printStackTrace();
            }
            
            
//            Get data from received packet
            String receivedData = new String(packetIn.getData());
            System.out.println("Server Received data: " + receivedData);
            
//           create an int array to store incoming numbers for calculation
            String[] no = receivedData.split(",");
//            System.out.println("no: " + no);
            
//            int[] intNo = new int[no.length];
            int total = 0;
            int avg = 0;
            
            for(String strNo : no) {
               total += Integer.parseInt(strNo.trim());
      
            }
            
//            get avg
            avg = total/no.length;
            
//            
//            buffSenData = receivedData.toUpperCase().getBytes();
           
//            Find client data from the received packet
            InetAddress inAddr = packetIn.getAddress();
            int inPort = packetIn.getPort();
            
            String outData = "Server Output to client: Total: " + total + ", Avg: " + avg + ", Port: " + inPort + ", Address: " + inAddr;
            
            System.out.println(outData);
            buffSenData = outData.getBytes();
//            create datagram sto be sent
            DatagramPacket packetOut = new DatagramPacket(buffSenData, buffSenData.length, inAddr, inPort);
            
//            try to send to client
            try{
                serverSocket.send(packetOut);
                
            }catch(IOException e) {
                e.printStackTrace();
            }
        serverSocket.close();
        
        }
        catch(SocketException e) {
            e.printStackTrace();
        }
        
    }
    
}

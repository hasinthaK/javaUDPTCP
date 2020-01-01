package khk.interview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


// Practice
public class testServer{

    public static final int SERVICE_PORT = 10020;

    public static void testServer() throws IOException {

        try {
            DatagramSocket serverSocket = new DatagramSocket(SERVICE_PORT);
            System.out.println("Datagram socket created on Port: " + SERVICE_PORT);


            byte[] recieve = new byte[1024];
            byte[] send = new byte[1024];

            while(true) {

                DatagramPacket packetIn = new DatagramPacket(recieve, recieve.length);
                System.out.println("Waiting for a packet..");


                try {
                    serverSocket.receive(packetIn);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String dataIn = new String(packetIn.getData());
                System.out.println("Recieved data: " + dataIn);

                send = dataIn.toUpperCase().getBytes();

//                Extract data from the received packet
                InetAddress clientAddr = packetIn.getAddress();
                int clientPort = packetIn.getPort();

                DatagramPacket packetOut = new DatagramPacket(send, send.length, clientAddr, clientPort);

                try {
                    serverSocket.send(packetOut);
                    System.out.println("Packet sent");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        catch(IOException e) {
            e.printStackTrace();
        }




    }


}

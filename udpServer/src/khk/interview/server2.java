package khk.interview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class server2 {
    public static final int servicePort = 50001;

    public static void  server2() throws IOException{

        try{
            DatagramSocket socket = new DatagramSocket(servicePort);
            System.out.println("Server Socket created");

            //reciev buff
            byte[] recieve = new byte[1024];
            //send buff
            byte[] send = new byte[1024];

            String connection = "on";

            while(connection.equals("on")){
                DatagramPacket packetIn = new DatagramPacket(recieve, recieve.length);
                System.out.println("Waiting for a packet..");

                try{
                    socket.receive(packetIn);
                }catch (IOException e){
                    e.printStackTrace();
                }

                String inData = new String(packetIn.getData());
                System.out.println("Received packet data: " + inData);

                if(inData.equals("off")){
                    System.out.println("off - Closing server connection..");
                    connection = "off";
                }
                send = inData.toUpperCase().getBytes();

//            Extract destination data from received packet
                InetAddress clientAddr = packetIn.getAddress();
                int clientPort = packetIn.getPort();

                DatagramPacket out = new DatagramPacket(send, send.length, clientAddr, clientPort);

                try{
                    socket.send(out);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            socket.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

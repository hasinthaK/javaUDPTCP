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

            //reciev buff
            byte[] recieve = new byte[1024];
            //send buff
            byte[] send = new byte[1024];

            DatagramPacket packetIn = new DatagramPacket(recieve, recieve.length);

            try{
                socket.receive(packetIn);
            }catch (IOException e){
                e.printStackTrace();
            }

            String inData = new String(packetIn.getData());
            System.out.println("Recieved packet data: "+inData);

            send = inData.toUpperCase().getBytes();

            InetAddress clientAddr = packetIn.getAddress();
            int clientPort = packetIn.getPort();

            DatagramPacket out = new DatagramPacket(send, send.length, clientAddr, clientPort);

            try{
                socket.send(out);
            }catch (IOException e){
                e.printStackTrace();
            }

            socket.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

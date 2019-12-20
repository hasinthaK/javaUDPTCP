package khk.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpClient {

    public static final int serverPort = 50001;

    public static void udpclient() throws IOException {

        try{
            DatagramSocket clientSocket = new DatagramSocket();
            System.out.println("Client socket created");

            byte[] receive = new byte[1024];
            byte[] send = new byte[1024];

            String dataToSend = "off";
            send = dataToSend.getBytes();

            InetAddress serverAddr = InetAddress.getByName("localhost");

            DatagramPacket packetOut = new DatagramPacket(send, send.length, serverAddr, serverPort);
            DatagramPacket packetIn = new DatagramPacket(receive, receive.length);

            try{
                clientSocket.send(packetOut);
            }catch (IOException e){
                e.printStackTrace();
            }
            System.out.println("Packet sent");

            try{
                clientSocket.receive(packetIn);
            }catch (IOException e){
                e.printStackTrace();
            }

            String receivedData = new String(packetIn.getData());
            System.out.println("Received data: " + receivedData);

            clientSocket.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}

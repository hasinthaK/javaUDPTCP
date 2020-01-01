package khk.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// practice
public class testUdpClient {

    public static final int SERVER_PORT = 10020;

    public static void testUdpClient() throws Exception {

        try{

            DatagramSocket clientSocket = new DatagramSocket();
            System.out.println("Client socket created");

            byte[] send = new byte[1024];
            byte[] receive = new byte[1024];

            String dataToSend = "hasintha Abeykoon";
            send = dataToSend.getBytes();

            InetAddress serverAddr = InetAddress.getByName("localhost");
            DatagramPacket out = new DatagramPacket(send, send.length, serverAddr ,SERVER_PORT);
            DatagramPacket in = new DatagramPacket(receive, receive.length);

            try{
                clientSocket.send(out);
                System.out.println("Data sent");
            }catch (Exception e) {
                e.printStackTrace();
            }

            try{
                clientSocket.receive(in);
            }catch (Exception e) {
                e.printStackTrace();
            }

            String dataIn = new String(in.getData());
            System.out.println("Recieved data: " + dataIn);

            clientSocket.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}

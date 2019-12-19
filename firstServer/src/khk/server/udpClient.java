package khk.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpClient {
    public static final int ClientPort = 10006;

    public static void udpSocket() throws IOException {

        try{
            DatagramSocket clientSOcket = new DatagramSocket(ClientPort);
            System.out.printf("Datagram Socket created");

            try{
                InetAddress ipAddr = InetAddress.getByName("localhost");
            }catch (Exception e){
                e.printStackTrace();
            }

            byte[] buffReceieved = new byte[1024];

            DatagramPacket recPacket = new DatagramPacket(buffReceieved, buffReceieved.length);

            try{
                clientSOcket.receive(recPacket);
                // blocking call
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            String strRec = new String(recPacket.getData());
            System.out.printf("Client rec data"+ strRec);
            clientSOcket.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

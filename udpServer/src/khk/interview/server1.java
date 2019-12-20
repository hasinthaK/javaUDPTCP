package khk.interview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class server1 {
    public static final int servicePort = 10005;

    public static void server1() throws IOException{
        try{
//            create Datagram socket same as UDP client
            DatagramSocket socket = new DatagramSocket(servicePort);

            InetAddress clientAddr = InetAddress.getByName("localhost");
            int iCounter = 0;

            while(true){
                Date now = new Date();
                String dataToSend = "Seq: " + iCounter + ", Data: " + now.toString();

                DatagramPacket out = new DatagramPacket(dataToSend.getBytes(), dataToSend.length(), clientAddr, 10006);

                try{
                    socket.send(out);
                    String outData = new String(out.getData());
                    System.out.println("Send UDP data: "+ outData);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                Thread.sleep(1000);
                iCounter++;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

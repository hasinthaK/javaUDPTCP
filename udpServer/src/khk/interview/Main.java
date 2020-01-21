package khk.interview;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
	// write your code here

//        server2.server2();

//        testServer.testServer();
        for (int i = 0 ; i<100 ; i++){

            ThreadImplemented thread = new ThreadImplemented("thred "+i);
            Thread t = new Thread(thread);
            t.start();

        }
    }
    }

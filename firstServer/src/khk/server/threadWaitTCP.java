package khk.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class threadWaitTCP {

    public static final int SERVICE_PORT = 13;

    public static void threadWait() throws Exception {
        ServerSocket tcpServer = null;
        Socket socket = null;

        try {
            tcpServer = new ServerSocket(SERVICE_PORT);

            while (true) {

                socket = tcpServer.accept();
                ThreadImplemented thread = new ThreadImplemented(socket);

                System.out.println("Thread created, Connection handed over..");

                Thread t = new Thread(thread);
                t.start();

            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

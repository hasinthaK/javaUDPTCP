package khk.server;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ThreadImplemented implements Runnable{
   private Socket client;

    public ThreadImplemented(Socket soc) {
        this.client = soc;
    }

    @Override
    public void run(){

        System.out.println(this.toString() + "Thread started client: " + client);

        try{
            Date today = new Date();
            PrintWriter out;

            out = new PrintWriter(client.getOutputStream(), true);
            out.println(today);

//        wait for client
            InputStream in = client.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String received = br.readLine();

            System.out.println("Received data: " + received);

            client.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Thread exiting!");

    }
}

package khk.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class server {
    public static void server1() throws IOException{

        ServerSocket server = new ServerSocket(10005);
        System.out.println("Server socket created!");
//            listen
        while(true){
            try{
                Socket client = server.accept();
                System.out.println("Accepting");
//          accepts connections - waiting for a client

                DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
                System.out.println("Writing to the client socket");

//                    Format date
                Date now = new Date();

                Locale locale = new Locale("en", "US");
                DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
                String date = dateFormat.format(now);
                System.out.print(date);

                PrintWriter out = new PrintWriter(client.getOutputStream());
                out.println("Server connected time :"+ date);
//            clears the buffer
                System.out.println("Connection time - " + date);
                out.flush();

//          Writes to the connected client socket
                outputStream.writeBytes("HelloSockets\nconnection time - " + now);
                client.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

package khk.server;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class testTCPServer {

    public static void testTCPServer() throws Exception {

            ServerSocket tcpServer = new ServerSocket(10010);
            System.out.println("TCP Server created, Listening..");


                while(true){

                    try{
                        Socket socket = tcpServer.accept();

                        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                        System.out.println("Writing to client..");

                        Date now = new Date();
                        Locale locale = new Locale("en", "US");
                        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
                        String date = dateFormat.format(now);
                        System.out.print(date);

                        outputStream.writeBytes("Server: " + date);
                        socket.close();
                    }catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }

        }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawwwclient;

import com.sun.org.apache.xerces.internal.impl.io.MalformedByteSequenceException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.util.Scanner;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

/**
 *
 * @author 174001C
 */
public class JavawwwClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        ServerSocket tcpServer = new ServerSocket(10000);
        System.out.println("TCP Server created, Listening..");
        Socket client = tcpServer.accept();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        
        while(true) {
            try {
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("Enter web address: ");
            String url = reader.readLine();

              // Read user input
            URI uri= new URI(url);

            java.awt.Desktop.getDesktop().browse(uri);
            System.out.println(url +" opened in browser");
 
        } catch (Exception e) {
 
            e.printStackTrace();
            }
        }
        }
    
     public static void DownloadWebPage(String webpage) throws Exception 
    { 
        try { 
  
            // Create URL object 
            URI url = new URI(webpage); 
            BufferedReader readr =  
              new BufferedReader(new InputStreamReader(url.OpenStream())); 
  
            // Enter filename in which you want to download 
            BufferedWriter writer =  
              new BufferedWriter(new FileWriter("Download.html")); 
              
            // read each line from stream till end 
            String line; 
            while ((line = readr.readLine()) != null) { 
                writer.write(line); 
            } 
  
            readr.close(); 
            writer.close(); 
            System.out.println("Successfully Downloaded: " + webpage); 
        } 
  
        // Exceptions 
        catch (MalformedByteSequenceException mue) { 
            System.out.println("Malformed URL Exception raised"); 
        } 
        catch (IOException ie) { 
            System.out.println("IOException raised"); 
        } 
    } 
     
     public static void urlParser(String url) throws Exception {

     final String URL_TO_PARSE  = url;
//     final String LINK          = "t=60";
     
    System.setProperty("http.proxyHost", "my.proxy.server");
    System.setProperty("http.proxyPort", "8080");
     
    
    URI uri = new URI(URL_TO_PARSE);
    Document doc = Parser(url, 30000);
    
    Elements links = doc.select("a[href$=""]");
    int linksSize = links.size();
    
    }
     
     
     
}


   

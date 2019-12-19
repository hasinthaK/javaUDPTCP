package khk.server;

import javax.swing.*;
import java.io.IOException;

public class html {
    public static void jEditorPane(){
        JEditorPane jep = new JEditorPane();
        jep.setEditable(false);

        try{
            jep.setPage("http://www.google.com");
        }
        catch (IOException e){
            jep.setContentType("text/html");
            jep.setText("<html><b>Could not load</b></html>");
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(jep);

        JFrame fram = new JFrame("JEditor paen");

        fram.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        fram.setContentPane(scrollPane);
        fram.setSize(512,342);
        fram.show();
    }
}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class webcrawler {

    private static final int MAX_DEPTH = 4;
    private HashSet<String> links;

    public webcrawler(){
        links = new HashSet<>();
    }

    public void getPageLinks(String URL, int depth) {
        if ((!links.contains(URL) && (depth < MAX_DEPTH))) {
            System.out.println(">> Depth: " + depth + " [" + URL + "]");
            try {
                links.add(URL);

                Document document =
Jsoup.connect(URL).proxy("cache.mrt.ac.lk", 3128).get();
                File f = new File(".\\download\\" + URL.replace(":",
"--").replace("/", "-").replace(".", "-") + ".html"); //

                FileWriter fe = new FileWriter(f);
                fe.write(document.outerHtml());
                Elements linksOnPage = document.select("a[href]");

                depth++;
                for (Element page : linksOnPage) {
                    getPageLinks(page.attr("abs:href"), depth);
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public java.security.cert.X509Certificate[]
getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] certs,
String authType) {
                }

                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] certs,
String authType) {
                }
            }
        };


        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("link : ");
        String url = scanner.nextLine();
        System.out.println("depth : ");
        int depth = scanner.nextInt();
        new webcrawler().getPageLinks(url, depth);
    }
}
package network;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlDemo {
    private void demo1() throws MalformedURLException {
        URL url = new URL("https://edition.cnn.com/election/2020");
        System.out.println("Protocol: " + url.getProtocol());
        System.out.println("Port: " + url.getPort());
        System.out.println("Host: " + url.getHost());
        System.out.println("File: " + url.getFile());
        System.out.println("Ext: " + url.toExternalForm());
    }

    public static void main(String[] args) throws MalformedURLException {
        var demo = new UrlDemo();
        demo.demo1();
    }
}

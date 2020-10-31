package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class InetAddressTest {
    private void test1() throws UnknownHostException {
        var localHost = InetAddress.getLocalHost();
        System.out.println("Local Host: " + localHost);
        var leetCode = InetAddress.getByName("leetcode.com");
        System.out.println("Leet Code: " + leetCode);
    }

    private void testWhoIs() throws IOException {
        try(Socket socket = new Socket("whois.internic.net", 43)) {
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            String url = "leetcode.com\n";
            out.write(url.getBytes());

            int c;
            while((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        }
    }

    public static void main(String[] args) throws UnknownHostException, IOException {
        var test = new InetAddressTest();
        test.testWhoIs();
    }
}

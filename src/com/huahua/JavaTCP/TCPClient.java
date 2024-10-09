package src.com.huahua.JavaTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/7/27
 */
public class TCPClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("Hello Server!");

            String response = in.readLine();
            System.out.println("Server response:" + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

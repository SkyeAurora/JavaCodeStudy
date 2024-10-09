package src.com.huahua.JavaTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: TCP服务器
 * @author：张佳伟
 * @date: 2024/7/27
 */
public class TCPServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080...");

            while (true) {
                Socket socket = serverSocket.accept();
                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Client connected!");
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String message = in.readLine();
            System.out.println("Received: " + message);

            out.println("Hello Client!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package lk.ijse.chatApplication.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static ArrayList<ClientHandle> client = new ArrayList<ClientHandle>();

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(3000);

        Socket accept;


        while (true) {

            System.out.println("Waiting for Client ....");
            accept = serverSocket.accept();
            System.out.println("Client Connected");
            ClientHandle clientThread = new ClientHandle(accept, client);
            client.add(clientThread);
            clientThread.start();
        }
    }
}

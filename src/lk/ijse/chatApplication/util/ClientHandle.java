package lk.ijse.chatApplication.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandle extends Thread{
    private ArrayList<ClientHandle>client;
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public ClientHandle(Socket socket, ArrayList<ClientHandle> clients) {
        try {
            this.socket = socket;
            this.client = clients;
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run() {
        try {
            String msg;
            while ((msg = reader.readLine()) != null) {
                if (msg.equalsIgnoreCase( "exit")) {
                    break;
                }
                for (ClientHandle cl : client) {
                    cl.writer.println(msg);
                }
            }
        } catch (Exception e) {

        }
        finally {
            try {
                reader.close();
                writer.close();
                socket.close();
            } catch (IOException e) {

            }
        }

    }
}

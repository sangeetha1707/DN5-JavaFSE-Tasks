import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(5000);

        System.out.println("Server Waiting...");

        Socket s = ss.accept();

        DataInputStream dis =
                new DataInputStream(s.getInputStream());

        String msg = dis.readUTF();

        System.out.println("Client: " + msg);

        ss.close();
    }
}

/*
Server Waiting...
Client: Hello Server
*/
package L3_IOstreams;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static ServerSocket server;
    private static Socket clientSocket; //сокет для общения

    public Server () {
        try {
            server = new ServerSocket(8189);
            clientSocket = server.accept();
            System.out.println("Клиент подключился!");

            Student student = new Student(1, "Bob");
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stud.ser"));
//            oos.writeObject(student);
//            oos.close();
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            out.writeObject(student);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

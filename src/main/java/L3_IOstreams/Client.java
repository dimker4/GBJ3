package L3_IOstreams;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8189);
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Student student = (Student) in.readObject();
            student.info();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

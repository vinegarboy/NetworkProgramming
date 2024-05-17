import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Calc_Client {
    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("localhost", 12345);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            ITask task = new MaxPrimeCalculator();
            out.writeObject(task);
            out.flush();

            System.out.println("Response from server:");
            int result = (Integer) in.readObject();
            System.out.println("Max prime number <= 100: " + result);
        }
    }
}
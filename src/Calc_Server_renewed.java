import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Calc_Server_renewed {
    public static void main(String[] args) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Waiting for connection...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connected");

                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                while (true) {
                    ITask task = (ITask) in.readObject();
                    if (task instanceof MaxPrimeCalculator && ((MaxPrimeCalculator) task).getX() > 1) {
                        ((MaxPrimeCalculator) task).exec();
                        int result = ((MaxPrimeCalculator) task).getResult();
                        out.writeObject(result);
                        out.flush();
                    } else {
                        System.out.println("Invalid request or number <= 1.");
                        break;
                    }
                }
            }
        }
    }
}
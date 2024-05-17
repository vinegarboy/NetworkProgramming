import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Calc_Client_renewed {
    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("localhost", 12345);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            while (true) {
                System.out.print("Enter a number: ");
                int num = Integer.parseInt(System.console().readLine());

                if (num <= 1) {
                    System.out.println("Exiting...");
                    break;
                }

                ITask task = new MaxPrimeCalculator();
                task.setExecNumber(num);
                out.writeObject(task);
                out.flush();

                System.out.println("Response from server:");
                int result = (Integer) in.readObject();
                System.out.println("Max prime number <= " + num + ": " + result);
            }
        }
    }
}
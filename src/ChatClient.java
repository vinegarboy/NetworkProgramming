import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            System.out.println("メッセージを入力してください(例:こんにちは) ↓");
            String message = scanner.next();
            System.out.println("送信者の名前を入力してください(例:ユーザー1) ↓");
            String author = scanner.next();
            scanner.close();

            ChatObject chatObject = new ChatObject(new Date(), message, author);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            oos.writeObject(chatObject);
            oos.flush();

            // サーバーから返された List<ChatObject> を受け取る
            List<ChatObject> chatLog = (List<ChatObject>) ois.readObject();

            // サーバーから受け取ったチャットログを表示
            for (ChatObject receivedObject : chatLog) {
                System.out.println("サーバからのメッセージは" + receivedObject.getMessage());
                System.out.println(receivedObject.getAuthor() + "からのメッセージをもらいました！");
            }

            ois.close();
            oos.close();
            socket.close();

        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            e.printStackTrace();
        }
    }
}
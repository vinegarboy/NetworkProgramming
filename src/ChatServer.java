import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class ChatServer {

    public static List<ChatObject> chatLog = new ArrayList<ChatObject>();
    public static void main(String[] args) {
        try {
            /* 通信の準備をする */
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            scanner.close();
            // サーバーを起動
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("サーバーがポート" + port + "で起動しました。");

            while (true) {
                // クライアントからの接続を待つ
                Socket clientSocket = serverSocket.accept();
                System.out.println("クライアントから接続が入りました。");

                // 入力と出力ストリームを作成
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

                // クライアントから ChatObject を読み取る
                ChatObject receivedObject = (ChatObject) in.readObject();
                System.out.println("Received ChatObject=?{" + receivedObject.Author + ":" + receivedObject.message+"}");

                // chatLog に追加
                chatLog.add(receivedObject);

                // クライアントに chatLog を送信
                out.writeObject(chatLog);
                // ストリームとソケットを閉じる
                in.close();
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println("サーバーがエラーで終了しました。");
            e.printStackTrace();
        } catch (Exception e){
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
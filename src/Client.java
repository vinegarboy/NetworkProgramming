import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            
            // 1. サーバーに接続するためのSocketを作成
            Socket socket = new Socket("", 5050);

            for (int i = 0; i < 100; i++) {
            // 2. サーバーにデータを送信するためのOutputStreamを取得
            OutputStream outputStream = socket.getOutputStream();
            // データを送信するためのラッパーを作成
            PrintWriter writer = new PrintWriter(outputStream, true);

            // 3. サーバーからデータを受信するためのInputStreamを取得
            InputStream inputStream = socket.getInputStream();
            // データを受信するためのラッパーを作成
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // 4. サーバーにデータを送信するループ
            
            writer.println("Message " + (i + 1));
            

            // 5. サーバーからの応答を受信して表示
            String response = reader.readLine();
            System.out.println("Server response: " + response);
            
        }
            // 6. 接続を閉じる
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.io.*;
public class XmasTreeKadai {
    public static void main(String[] args) {
        try {
            PrintWriter writer = new PrintWriter("XmasTreeKadai_Result.txt");
            writer.print(drawXmasTree(10)); // ツリーの高さを10に設定
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String drawXmasTree(int height) {
        String ret = "";
        // 雪の結晶を描く
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i; j++) {
                if(i%2 == 0){
                    if(j % 2 == 0 && j != height-i-1) {
                        System.out.print("+"); // 左側のスペース
                        ret += "+";
                    } else {
                        System.out.print(" "); // 左側のスペース
                        ret += " ";
                    }
                }else{
                    if(j % 2 == 0 || j == height-i-1) {
                        System.out.print(" "); // 左側のスペース
                        ret += " ";
                    } else {
                        System.out.print("+"); // 左側のスペース
                        ret += "+";
                    }
                }
                
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*"); // 木の本体
                ret += "*";
            }
            System.out.println(); // 改行
            ret += "\n";
        }

        // ツリーの下部を描く
        for (int i = 0; i < height/2; i++) {
            for (int j = 0; j < height-1; j++) {
                System.out.print(" "); // 左側のスペース
                ret += " ";
            }
            System.out.println("***"); // ツリーの下部
            ret += "***\n";
        }
        return ret;
    }
}

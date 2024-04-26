public class XmasTreeKadai {
    public static void main(String[] args) {
        drawXmasTree(10); // ツリーの高さを10に設定
    }

    public static void drawXmasTree(int height) {

        // 雪の結晶を描く
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i; j++) {
                if(i%2 == 0){
                    if(j % 2 == 0 && j != height-i-1) {
                        System.out.print("+"); // 左側のスペース
                    } else {
                        System.out.print(" "); // 左側のスペース
                    }
                }else{
                    if(j % 2 == 0 || j == height-i-1) {
                        System.out.print(" "); // 左側のスペース
                    } else {
                        System.out.print("+"); // 左側のスペース
                    }
                }
                
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*"); // 木の本体
            }
            System.out.println(); // 改行
        }

        // ツリーの下部を描く
        for (int i = 0; i < height/2; i++) {
            for (int j = 0; j < height-1; j++) {
                System.out.print(" "); // 左側のスペース
            }
            System.out.println("***"); // ツリーの下部
        }
    }
}

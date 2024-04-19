import java.io.*;    // C言語では、#include に相当する

public class HowOldAreYou {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        do {
            try {
                System.out.println("何歳ですか？(qまたはeで終了)");
                input = reader.readLine();
                if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("e")) {
                    break;
                }
                int age = Integer.parseInt(input);
                if (age < 0 || age >= 120) {
                    System.out.println("無効な入力です。再度入力してください。");
                    continue;
                }
                int futureAge = age + (2030 - 2023); // 2030年の年齢を計算
                System.out.println("2030年のあなたの年齢は" + futureAge + "歳です。");
                System.out.println("元号は" + getEra(age) + "年です。");
            } catch (NumberFormatException e) {
                System.out.println("数値を入力してください。");
            } catch (IOException e) {
                System.out.println(e);
            }
        } while (true);
    }

    private static String getEra(int age) {
        int year = 2023 - age; // 誕生年を計算
        if (year < 1868) {
            return "明治";
        } else if (year < 1912) {
            return "大正";
        } else if (year < 1926) {
            return "昭和";
        } else if (year < 1989) {
            return "平成";
        } else if (year < 2019) {
            return "令和";
        } else {
            return "令和"; // 2019年以降は令和を優先
        }
    }
}

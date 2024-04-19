import java.util.StringJoiner;

public class StringBufferTest {
	
	public static void main(String[] args) {
		
		int n = 20000; //試行回数
		String word = "a"; //つなげる言葉
		
		/*------------------------------
		+結合による文字連結の処理
		------------------------------*/
		long start = System.nanoTime();
		String sentence = "";
		for(int i = 0; i < n; i++) {
			sentence += word;
		}
		long end = System.nanoTime();
		long total = end - start;
		System.out.println("+の文字連結処理にかかった時間：" + total + " ナノ秒");
		
		/*------------------------------
		StringBufferによる文字連結の処理
		------------------------------*/
		start = System.nanoTime();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < n; i++) {
			sb.append(word);
		}
		sentence = new String(sb);
		end = System.nanoTime();
		total = end - start;
		System.out.println("StringBufferの文字連結処理にかかった時間：" + total + " ナノ秒");
		
		/*------------------------------
		/*------------------------------
		Java8からの機能
		String.joinによる文字連結の処理
		------------------------------*/
		start = System.nanoTime();
		String[] words = new String[n];
		for(int i = 0; i < n; i++) {
			words[i] = word;
        }
		end = System.nanoTime();
		total = end - start;
		end = System.nanoTime();
		total = end - start;
		System.out.println("String.joinの文字連結処理にかかった時間：" + total + " ナノ秒");
		
		start = System.nanoTime();
		StringJoiner joiner = new StringJoiner("");
		for(int i = 0; i < n; i++) {
			joiner.add(word);
		}
		end = System.nanoTime();
		total = end - start;
		System.out.println("StringJoinerの文字連結処理にかかった時間：" + total + " ナノ秒");
		
	}

}

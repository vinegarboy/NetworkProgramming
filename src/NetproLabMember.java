import java.util.Random;

public class NetproLabMember {
	public static final int years = 15;

	public static void main(String[] args) {
		Random random = new Random();
		double noFemaleRatio = 1;
		for (int i = 0; i < years; i++) {
			// 学生の総数
			int totalStudents = 110 + (random.nextInt(20) - 10);
			// 女性の割合(%), 毎年1%上昇
			double femaleRatio = 0.2 + (i * 0.01);
			// 岩井研の人数
			int cpsMembers = 10 + (random.nextInt(6) - 3);
	  		// 岩井研の人数
			// 女性の学生が来ない確率を計算
			double noFemaleProbability = 1 - femaleRatio;
			// 岩井研の人数に女性しか入らない確率を計算
			double cpsAllFemaleProbability = Math.pow(noFemaleProbability, cpsMembers);
			// 総数に女性しか入らない確率を計算
			double totalAllFemaleProbability = Math.pow(noFemaleProbability, totalStudents);
			// 岩井研の人数に女性しか入らない確率を総数に女性しか入らない確率で割る
			double cpsNoFemaleRatio = cpsAllFemaleProbability / totalAllFemaleProbability;

			// 確率を累積
			noFemaleRatio *= cpsNoFemaleRatio;
		}
		System.out.println("女性の学生が来ない確率: " + noFemaleRatio);
	}

	// Combination 計算
	public static final long combination(final int n, int r) {
		if (r > n) {
			return 0;
		}
		if (r == n || r == 0) {
			return 1;
		}
		return combination(n - 1, r - 1) + combination(n - 1, r);
	}
}

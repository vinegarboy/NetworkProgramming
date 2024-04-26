import java.util.*;

public class HeikinCKadai {

    public static void main(String[] args) {
        Random random = new Random();
        List<Kamoku> students = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            int score = random.nextInt(101);
            Kamoku student = new Kamoku(score);
            student.setName("学生" + (i + 1));
            students.add(student);
        }


        double average = students.stream().mapToInt(Kamoku::getScore).average().orElse(0.0);
        System.out.println("全員の平均点は " + average + " です。");

        List<Kamoku> passedStudents = new ArrayList<>();
        for (Kamoku student : students) {
            if (student.getScore() >= 80) {
                passedStudents.add(student);
            }
        }
        /*一覧の表示、今回はソートするため非表示
        System.out.println("合格者一覧:");
        for (Kamoku student : passedStudents) {
            System.out.println("名前: " + student.getName() + ", 点数: " + student.getScore());
        }
        */
        Collections.sort(passedStudents, Comparator.comparing(Kamoku::getScore));
        System.out.println("合格者の点数で昇順ソート:");
        for (Kamoku student : passedStudents) {
            System.out.println("名前: " + student.getName() + ", 点数: " + student.getScore());
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MayExceptionTest {

	public static void main(String[] args) {

		MayExceptionTest myE = new MayExceptionTest();

	}

	MayExceptionTest() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println("何日ですか? (5月の日付を入力してください。終了するには 'exit' を入力してください。)");
				String line = reader.readLine();
				if ("exit".equalsIgnoreCase(line)) {
					break;
				}
				int theday = Integer.parseInt(line);
				LocalDate date = LocalDate.of(2023, 5, theday);
				if (!date.getDayOfWeek().equals(DayOfWeek.SATURDAY) && !date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
					System.out.println("日付" + theday + "日ですね。");
				} else {
					throw new NoHolidayException();
				}
			} catch(IOException e) {
				System.out.println(e);
			} catch (NumberFormatException e) {
				System.out.println("無効な入力です。数値を入力してください。");
			} catch (NoHolidayException e) {
				e.printStackTrace();
			}

        }
	}
}

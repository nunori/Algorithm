import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int student = 30;
		int[] arr = new int[31];

		// 각 학생별 출석번호 할당
		for (int i = 1; i < 29; i++) {
			int success = Integer.parseInt(br.readLine());
			arr[success] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != 1) {
				System.out.println(i);
				br.close();
			}

		}
	}
}
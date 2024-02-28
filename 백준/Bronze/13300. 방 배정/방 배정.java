import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 참가 학생 수
		int K = Integer.parseInt(st.nextToken()); // 한 방 최대 인원 수

		int[] gender_total = new int[N];

		int[] grade_total = new int[N];
		int grade_1f = 0;
		int grade_1m = 0;

		int grade_2f = 0;
		int grade_2m = 0;

		int grade_3f = 0;
		int grade_3m = 0;

		int grade_4f = 0;
		int grade_4m = 0;

		int grade_5f = 0;
		int grade_5m = 0;

		int grade_6f = 0;
		int grade_6m = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			gender_total[i] = Integer.parseInt(st.nextToken());
			grade_total[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			if (gender_total[i] == 0) {
				int tmp = grade_total[i];

				switch (tmp) {

				case 1:
					grade_1f += 1;
					break;

				case 2:
					grade_2f += 1;
					break;

				case 3:
					grade_3f += 1;
					break;

				case 4:
					grade_4f += 1;
					break;

				case 5:
					grade_5f += 1;
					break;

				case 6:
					grade_6f += 1;
					break;

				}

			} else {
				int tmp = grade_total[i];

				switch (tmp) {

				case 1:
					grade_1m += 1;
					break;

				case 2:
					grade_2m += 1;
					break;

				case 3:
					grade_3m += 1;
					break;

				case 4:
					grade_4m += 1;
					break;

				case 5:
					grade_5m += 1;
					break;

				case 6:
					grade_6m += 1;
					break;

				}
			}
		}

		int[] arr = { grade_1f, grade_2f, grade_3f, grade_4f, grade_5f, grade_6f, grade_1m, grade_2m, grade_3m,
				grade_4m, grade_5m, grade_6m };

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[i] = (arr[i] - 1) / K + 1;
			} else if (arr[i] == 0) {
				arr[i] = 0;
			}
		}

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		System.out.println(sum);

	}
}

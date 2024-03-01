import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr2 = new int[7];
    static int cnt = 0;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 9;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
//        searchAll(cnt, sum);

        // 모든 난쟁이 키 더하기
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }

        // 진짜 난쟁이의 키만 담을 배열
        int[] real = new int[7];

        // 임의로 2명씩 뺄 배열
        int[] select = new int[2];

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                select[0] = arr[i];
                select[1] = arr[j];
                int sum_tmp = 0;
                for (int k = 0; k < 2; k++) {
                    sum_tmp += select[k];
                }
                if (sum - sum_tmp == 100) {
                    // select에 해당하는 값들 빼고 나머지 오름차순 정렬
                    int tmp_idx = 0;
                    for (int k = 0; k < 9; k++) {
//                        if (arr[k] != select[0] || arr[k] != select[1]) {
//                            real[tmp_idx] = arr[tmp_idx];
//                            tmp_idx++;
//                        }
                        if(arr[k] == select[0]) continue;
                        if(arr[k] == select[1]) continue;
                        if(arr[k] != select[0] && arr[k] != select[1]) {
                            real[tmp_idx] = arr[k];
                            tmp_idx++;
                        }
                    }
                }
            }
        }

        Arrays.sort(real);

        for (int i = 0; i < 7; i++) {
            System.out.println(real[i]);
        }
        ;

    }


}
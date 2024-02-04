import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 카드 배열 선언
        int[] cards = new int[N];

        // 카드 배열에 값 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int result = search(cards, N, M);

        System.out.println(result);

    }

        // 가까운 3개 찾기
        static int search(int[] cards, int N, int M) {
            int result = 0;
            for(int i = 0; i < N - 2; i++) {
                for(int j = i + 1; j < N - 1; j++) {
                    for(int k = j + 1; k < N; k++) {
                        int tmp = cards[i] + cards[j] + cards[k];

                        if(M == tmp) {
                            return tmp;
                        }

                        if(result < tmp && tmp < M) {
                            result = tmp;
                    }
                }
            }
        }
            return result;
    }
}
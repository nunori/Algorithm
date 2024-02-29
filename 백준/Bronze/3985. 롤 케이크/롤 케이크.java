import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        // L : 길이 L미터인 롤 케이크
        // N : 방청객 수
        // P : P번 조각
        // K : K번 조각

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int[] arrL = new int[L + 1]; // 케이크
        int[] arrP = new int[N + 1]; // 원하는 케이크 시작 번호
        int[] arrK = new int[N + 1]; // 원하는 케이크 끝 번호

        // 시작과 끝을 배열에 담기
        for (int i = 1; i <= N; i++) { // 방청객이 원하는 케이크이기 때문에 N까지
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrP[i] = Integer.parseInt(st.nextToken());
            arrK[i] = Integer.parseInt(st.nextToken());
        }
        // 몇 번 케이크를 가장 많이 원했는지 표현할 count 배열

//        System.out.println();

        // 원하는 케이크 갯수 카운트
//        for(int i = 1; i <= N; i++) {
//            int start = arrP[i];
//            int end = arrK[i];
//            for(int j = start; j <= end; j++) {
//                cnt[j]++;
//            }
//        }
//
//        System.out.println("원하는 케이크: " + Arrays.toString(cnt));


        // 가장 많은 조각을 받을 것으로 기대하고 있던 방청객의 번호 찾기
        int max = -1;
        int idx = -1;
        for(int i = 1; i <= N; i++) { // 방청객이기 때문에 N까지
            int tmp = arrK[i] - arrP[i];
            if(tmp > max) {
                max = tmp;
                idx = i;
            }
        }

//        System.out.println("가장 많은 케이크 받는 방청객: " + idx);
        // 원하는 케이크에 번호 표시
        for(int i = 1; i <= N; i++) {
            for(int j = arrP[i]; j <= arrK[i]; j++) {
                if(arrL[j] == 0) {
                arrL[j] = i;
                }
            }
        }

//        System.out.println("실제 번호 표시 케이크 arrL: " + Arrays.toString(arrL));

//        System.out.println("arrP: " + Arrays.toString(arrP));
//        System.out.println("arrK: " + Arrays.toString(arrK));
        // 케이크에 붙여진 번호 갯수 카운트
        int[] cnt2 = new int[N + 1]; // 인덱스에 해당하는 방청객이 몇개 케이크 받는지 카운트
        for(int i = 1; i <= L; i++) {
            cnt2[arrL[i]]++;
        }

//        System.out.println("해당 인덱스의 방청객이 받는 케이크 갯수 cnt2: " + Arrays.toString(cnt2));
        // 가장 많이 받은 방청객 번호
        int max2 = -1;
        int maxidx = -1;
        for(int i = 1; i <= N; i++) {
            if(cnt2[i] > max2) {
                max2 = cnt2[i];
                maxidx = i;
            }
        }



//        System.out.println("예상으로 가장 많은 케이크 받는 방청객: " + idx);
//        System.out.println("실제로 가장 많은 케이크 받는 방청객: " + maxidx);
        System.out.println(idx);
        System.out.println(maxidx);
    }
}
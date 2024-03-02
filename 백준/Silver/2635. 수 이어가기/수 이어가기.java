import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>(); // 계산결과값 담을 ArrayList
        List<Integer> result = new ArrayList<>(); // 최종결과값 담을 ArrayList

        

        int nextNum = 0; // 앞의 두 수의 차를 담을 변수
        int MAX_cnt = 0; // 몇 번 계산할 지 카운트
        for(int i = N / 2; i <= N; i++) {
            int idx = 0;
            list.add(N); // 첫 입력값 삽입
            list.add(i); // 절반에 해당하는 값 삽입

            while(true) { // 앞 두 수의 차가 음수면 탈출
                nextNum = list.get(idx) - list.get(idx + 1); // 앞 두 수의 차
                if(nextNum < 0) break; // 차가 음수면 탈출
                else {
                    list.add(nextNum); // list에 담고 계속 진행
                    idx++; // 다음 인덱스로 넘어가기 위함
                }
            }

            if(list.size() > MAX_cnt) { // 계산 결과 횟수와 MAX_cnt와 비교
                result.clear();
                MAX_cnt = list.size();
                result.addAll(list);

            }

            list.clear();
        }

        System.out.println(MAX_cnt);
        for(int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }

    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int sum;
    static int time;
    static int distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // N, L 입력 받기
        int N = Integer.parseInt(st.nextToken()); // 신호등의 갯수
        int L = Integer.parseInt(st.nextToken()); // 도로의 길이

        distance = 0; // 총 가는 거리
        time = 0; // 총 시간

        int end_light = -1; // 마지막 신호등 위치


        // tc개만큼 반복
        for (int tc = 1; tc <= N; tc++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken()); // 신호등 위치
            int R_duration = Integer.parseInt(st.nextToken()); // 빨간색 지속 시간
            int G_duration = Integer.parseInt(st.nextToken()); // 초록색 지속 시간
            int total_dura = R_duration + G_duration;

            char[] traffic = new char[R_duration + G_duration];
            for (int i = 0; i < R_duration; i++) {
                traffic[i] = 'R';
            }
            for (int i = R_duration; i < R_duration + G_duration; i++) {
                traffic[i] = 'G';
            }

            // 초당 1미터 이동
            // 신호등이 빨간색 => 초록불 될 때까지 정지
            // 도로 끝까지 이동하는데 걸리는 시간 구하는 프로그램
            // 시간 돌리는 변수 time

            boolean stop = true;

            while (stop) {
//                System.out.println("time: " + time + " distance: " + distance);
                time++;
                distance++;
                if (distance == D) {
                    if (traffic[time % total_dura] == 'R') {
                        time += R_duration - (time % total_dura);
//                        System.out.println(tc + "번 째 신호등에서 대기시간: " + (R_duration - (time % total_dura)));
                        stop = false;
//                        System.out.println(tc + "번 쩨 신호등에서 출발시간: " + time);
                    } else {
                        stop = false;
//                        System.out.println(tc + "번 쩨 신호등에서 출발시간: " + time);
                    }
                }
            }


            // distance == 10 일 떄의 time 출력


            if (tc == N) {
                end_light = D; // 신호등 위치 변수에 담아서 뺴기
//                System.out.println("마지막 신호등 위치: " + end_light);
            }


        }

        time += L - end_light;


        System.out.println(time);
    }
}
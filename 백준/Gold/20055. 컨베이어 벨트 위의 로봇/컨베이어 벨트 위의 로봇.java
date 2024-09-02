import java.util.*;
import java.io.*;
public class Main {
    //    static int broke;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] line = new int[2 * N];
        for(int i = 0; i < line.length; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }

        int on = 0;
        int off = N - 1;

        boolean[] isRobotsOn = new boolean[N * 2];
        boolean[] isBroken = new boolean[N * 2];
        int grade = 0;
        int broke;

        while(true) {
            grade++;
            // 1. line 한 칸 오른쪽으로
            //      on, off를 한 칸 왼쪽으로

            // 컨베이어 벨트 회전

            on--;
            off--;
            if(on < 0) on += N * 2;
            if(off < 0) off += N * 2;

            // 2. 로봇 한 칸 오른쪽 이동
            //      이동할 수 있는지 검증
            //      이동 시 도착할 위치 내구도 --

            // off 위치에서 로봇 내리기
            if(isRobotsOn[off]) isRobotsOn[off] = false;

            if(on < off) {
                // on이 off보다 앞에 있을 때
                for(int i = off - 1; i >= on; i--) {
                    int nextPos = i + 1;
                    // 로봇 이동 조건 확인 및 이동 처리
                    if(isRobotsOn[i] && !isRobotsOn[nextPos] && line[nextPos] > 0) {
                        isRobotsOn[i] = false;
                        isRobotsOn[nextPos] = true;
                        line[nextPos]--;
                    }
                }
            } else {
                // on이 off보다 뒤에 있을 때
                for(int i = off - 1; i >= 0; i--) {
                    int nextPos = i + 1;
                    if(isRobotsOn[i] && !isRobotsOn[nextPos] && line[nextPos] > 0) {
                        isRobotsOn[i] = false;
                        isRobotsOn[nextPos] = true;
                        line[nextPos]--;
                    }
            }
                for(int i = N * 2 - 1; i >= on; i--) {
                    int nextPos = (i + 1) % (N * 2);
                    if(isRobotsOn[i] && !isRobotsOn[nextPos] && line[nextPos] > 0) {
                        isRobotsOn[i] = false;
                        isRobotsOn[nextPos] = true;
                        line[nextPos]--;
                    }
                }
            }

            // off 위치에서 로봇 내리기
            if(isRobotsOn[off]) isRobotsOn[off] = false;

            // 3. 로봇 on에 올리기
            //      올리기 가능한지 검증
            //      올렸을 때 해당 위치 내구도 --

            if(!isRobotsOn[on] && line[on] > 0) {
                isRobotsOn[on] = true;
                line[on]--;
            }

            broke = 0;
            for(int i = 0; i < line.length; i++) {
                if(line[i] <= 0) isBroken[i] = true;
            }

            for(int i = 0; i < isBroken.length; i++) {
                if(isBroken[i]) broke++;
            }

            if(broke >= K) break;

        } // while 끝

        System.out.println(grade);

    }
}
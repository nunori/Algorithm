import java.util.*;
import java.io.*;
public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int min, N;
    static int[] people, arr;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        people = new int[N];
        min = Integer.MAX_VALUE;
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < people.length; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for(int j = 0; j < cnt; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        back(1);
        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    static void back(int depth) {
        if(depth == N + 1) {
            check = new boolean[depth];

            int cnt = 0;

            for(int i = 1; i <= N; i++) {
                if(!check[i]) {
                    link(i, arr[i]);
                    cnt++;
                }
            }

            if(cnt == 2) {
                int a = 0;
                int b = 0;
                for(int i = 0; i < N; i++) {
                    if(arr[i + 1] == 1) a += people[i];
                    else b += people[i];
                }
                min = Math.min(min, Math.abs(a - b));
            }
            return;
        }

        arr[depth] = 1;
        back(depth + 1);

        arr[depth] = 0;
        back(depth + 1);
    }

    static void link(int depth, int local) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(depth);
        check[depth] = true;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int next : graph.get(curr)) {
                if(arr[next] == local && !check[next]) {
                    check[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
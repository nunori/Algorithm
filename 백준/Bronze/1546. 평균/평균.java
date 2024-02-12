import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] score = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Double.parseDouble(st.nextToken());
        }

        double M = 0;
        for (int i = 0; i < N; i++) {
            if (M < score[i]) {
                M = score[i];
            }
        }

        double[] nsc = new double[N];
        for (int i = 0; i < N; i++) {
            nsc[i] = (score[i] * 100) / M;
        }

        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nsc[i];
        }

        System.out.println(sum / N);

    }
}
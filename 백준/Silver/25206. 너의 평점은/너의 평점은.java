import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 20;
        double sum_grade = 0.0;
        double sum_credit = 0.0;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String trash = st.nextToken();

            double credit = Double.parseDouble(st.nextToken());
            String credit_str = st.nextToken();
            double score = -1;

            switch(credit_str) {
                case "A+":
                    score = 4.5;
                    break;
                case "A0":
                    score = 4.0;
                    break;
                case "B+":
                    score = 3.5;
                    break;
                case "B0":
                    score = 3.0;
                    break;
                case "C+":
                    score = 2.5;
                    break;
                case "C0":
                    score = 2.0;
                    break;
                case "D+":
                    score = 1.5;
                    break;
                case "D0":
                    score = 1.0;
                    break;
                case "F":
                    score = 0;
                    break;
                case "P":
                    continue;
            }
            sum_grade += credit * score;
            sum_credit += credit;
        }
        double result = sum_grade / sum_credit;
        System.out.printf("%.6f", result);
    }
}
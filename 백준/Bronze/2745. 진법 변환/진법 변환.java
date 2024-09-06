import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int tmp = 1;
        int sum = 0;

        for(int i = N.length() - 1; i >= 0; i--) {
            char ch = N.charAt(i);

            if('A' <= ch && ch <= 'Z') sum += (ch - 'A' + 10) * tmp;
            else sum += (ch - '0') * tmp;
            tmp *= B;
        }
        System.out.println(sum);
    }
}
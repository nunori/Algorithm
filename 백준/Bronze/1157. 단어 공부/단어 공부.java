import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String S = s.toUpperCase();
        int[] arr = new int[26];

        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            arr[ch - 'A']++;
        }
        int max = -1;
        char result = '?';

        for(int i = 0; i < 26; i++) {
            if(arr[i] > max) {
                max = arr[i];
                result = (char) (i + 'A');
            } else if(arr[i] == max) {
                result = '?';
            }
        }
        System.out.println(result);
    }
}
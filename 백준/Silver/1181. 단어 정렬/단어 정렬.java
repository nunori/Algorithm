import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        // HashSet으로 중복을 제거함
        Set<String> uniqueList = new HashSet<>(list);

        List<String> sortedList = new ArrayList<>(uniqueList);
        sortedList.sort((s1, s2) -> {
            int lengthCompare = Integer.compare(s1.length(), s2.length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return s1.compareTo(s2);
        });

        for (String s : sortedList) {
            System.out.println(s);
        }

    }
}
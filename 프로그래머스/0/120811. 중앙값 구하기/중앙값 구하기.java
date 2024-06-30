import java.util.*;

class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        
        int answer = array[array.length / 2];
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        return answer;
    }
}
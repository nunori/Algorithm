import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Arrays.sort(works);
        int len = works.length;
        
        while (n > 0) {
            int max = works[len - 1];
            
            if (max == 0) {
                return 0;
            }
            
            for (int i = len - 1; i >= 0; i--) {
                if (works[i] == max && n > 0) {
                    works[i]--;
                    n--;
                } else {
                    break;
                }
            }
            
            Arrays.sort(works);
        }
        
        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum += (long) works[i] * works[i];
        }
        
        return sum;
    }
}

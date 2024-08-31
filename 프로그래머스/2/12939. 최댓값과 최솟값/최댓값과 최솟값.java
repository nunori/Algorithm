import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        while (st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());
            if (value > max) max = value;
            if (value < min) min = value;
        }
        
        return min + " " + max;
    }
}
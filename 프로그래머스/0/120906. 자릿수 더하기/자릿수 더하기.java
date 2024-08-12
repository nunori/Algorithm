import java.util.*;
class Solution {
    public int solution(int n) {
        
        String s = n + "";
        int sum = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sum += c - '0';
        }
        return sum;
        
    }
}
import java.util.*;
class Solution {
    public int solution(int n) {
        int sqrt = (int) Math.sqrt(n);
        if(Math.pow(sqrt, 2) == n) return 1;
        return 2;
    }
}
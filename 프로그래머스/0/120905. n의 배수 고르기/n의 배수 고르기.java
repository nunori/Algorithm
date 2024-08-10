import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i : numlist) {
            if(i % n == 0) list.add(i);
       }
        
        int[] result = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
        
    }
}
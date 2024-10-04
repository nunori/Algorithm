import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        List<Integer> res = new ArrayList<>();
        
        for(int r = 0; r < commands.length; r++) {
            List<Integer> list = new ArrayList<>();
            
            int i = commands[r][0];
            int j = commands[r][1];
            int k = commands[r][2];
            
            for(int rr = i - 1; rr < j; rr++) {
                list.add(array[rr]);
            }
            
            Collections.sort(list);
            
            res.add(list.get(k - 1));
            
        }
        
        int[] result = new int[res.size()];
        
        for(int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        
        return result;
    }
}
import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        int[] cntX = new int[10];
        int[] cntY = new int[10];
        
        for(char c : X.toCharArray()) {
            cntX[c - '0']++;
        }
        
        for(char c : Y.toCharArray()) {
            cntY[c - '0']++;
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            int minNum = Math.min(cntX[i], cntY[i]);
            for(int j = 0; j < minNum; j++) {
                list.add(i);
            }
        }
        
        if(list.isEmpty()) return "-1";
        
         if (list.size() == Collections.frequency(list, 0)) {
            return "0";
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num);
        }
        
        return sb.toString();
        
    }
}
import java.util.*;
class Solution {
    public int[] solution(int n) {
        int div = 2;
        int num = n;
        List<Integer> list = new ArrayList<>();
        
        while (num > 1) {
            if (num % div == 0) {
                if (!list.contains(div)) {
                    list.add(div);
                }
                num /= div;
            } else {
                div++;
            }
        }
        
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int preNum = Integer.MAX_VALUE;
        for(int num : arr) {
            if(preNum != num) {
                arrayList.add(num);
                preNum = num;
            }
        }
        
        int[] res = new int[arrayList.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = arrayList.get(i);
        }
        
        return res;
    }
}
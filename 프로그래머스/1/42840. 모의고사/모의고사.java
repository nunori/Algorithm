import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        int[] ans1 = {1, 2, 3, 4, 5};
        int[] ans2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] ans3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i = 0; i < answers.length; i++) {
            int idx1 = i % 5;
            int idx2 = i % 8;
            int idx3 = i % 10;
            if(answers[i] == ans1[idx1]) cnt1++;
            if(answers[i] == ans2[idx2]) cnt2++;
            if(answers[i] == ans3[idx3]) cnt3++;
        }
        int[] arr = new int[3];
        arr[0] = cnt1;
        arr[1] = cnt2;
        arr[2] = cnt3;
        int max = 0;
        for(int i = 0; i < 3; i++) {
            if(max < arr[i]) max = arr[i];
        }
        
        List<Integer> lst = new ArrayList<>();
        
        for(int i = 0; i < 3; i++) {
            if(arr[i] == max) {
                lst.add(i + 1);
            }
        }
        
        int[] res = new int[lst.size()];
        for(int i = 0; i < lst.size(); i++) {
            res[i] = lst.get(i);
        }
        return res;
    }
}
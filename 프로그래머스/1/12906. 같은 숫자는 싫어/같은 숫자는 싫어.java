import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < arr.length; i++) {
            if(deque.isEmpty()) {
                deque.offerLast(arr[i]);
            } else {
                if(deque.peekLast() != arr[i]) {
                    deque.offerLast(arr[i]);
                }
            }
        }
        int[] res = new int[deque.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = deque.pollFirst();
        }
        return res;
    }
}
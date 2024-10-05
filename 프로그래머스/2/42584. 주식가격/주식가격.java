import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] res = new int[prices.length];
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < prices.length; i++) {
            while (!deque.isEmpty() && prices[i] < prices[deque.peekLast()]) {
                int j = deque.pollLast();
                res[j] = i - j;
            }
            deque.offerLast(i);
        }
        while (!deque.isEmpty()) {
            int j = deque.pollLast();
            res[j] = prices.length - 1 - j;
        }
        return res;
    }
}
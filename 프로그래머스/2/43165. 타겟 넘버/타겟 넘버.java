import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        Deque<Integer> deque = new ArrayDeque<>();
        int ans = 0;
        deque.offerLast(ans);
        for(int i = 0; i < numbers.length; i++) {
            int size = deque.size();
            for(int j = 0; j < size; j++) {
                int sum = deque.pollFirst();
                deque.offerLast(sum + numbers[i]);
                deque.offerLast(sum - numbers[i]);
            }
        }
        while(!deque.isEmpty()) {
            if(deque.pollFirst() == target) {
                ans++;
            }
        }
        return ans;
    }
}
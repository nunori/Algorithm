import java.util.*;
class Solution {
    public int solution(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        String[] sArr = s.split(" ");
        
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i].equals("Z")) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else {
                deque.addLast(Integer.parseInt(sArr[i]));
            }
        }
        
        int result = 0;
        while (!deque.isEmpty()) {
            result += deque.poll();
        }
        
        return result;
    }
}
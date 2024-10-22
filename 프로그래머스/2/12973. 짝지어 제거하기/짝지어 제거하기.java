import java.util.*;
class Solution {
    public int solution(String s) {
        char[] carr = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for(int i = 0; i < carr.length; i++) {
            char c = carr[i];
            if(deque.isEmpty()) {
                deque.addFirst(c);
            } else {
                if(deque.peekLast() == c) {
                    deque.pollLast();
                } else {
                    deque.addLast(c);
                }
            }
        }
        return deque.isEmpty() ? 1 : 0;
        
    }
}
import java.util.*;
class Solution {
    public int solution(String my_string) {
        int sum = 0;
        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            deque.addLast(ch);
        }
        int size = deque.size();
        for(int i  = 0; i < size; i++) {
            char ch = deque.pollFirst();
            if(ch - '0' >= 0 && ch - '0' <= 9) {
                sb.append(ch);
                Character cc = deque.peekFirst();
                if(cc == null || cc - '0' < 0 || cc - '0' > 9) { // 다음 원소가 int가 아닐 때
                    int tmp = Integer.parseInt(sb.toString());
                    sum += tmp;
                    sb.setLength(0);
                    continue;
                }
            }
        }
        return sum;
    }
}
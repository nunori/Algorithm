import java.util.*;
class Solution {
    public String solution(String my_string) {
        String s = my_string.toLowerCase();
        char[] c = new char[s.length()];
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            c[i] = ch;
        }
        
        Arrays.sort(c);
        String res = "";
        for(char tmp : c) {
            res += tmp;
        }
        return res;
    }
}
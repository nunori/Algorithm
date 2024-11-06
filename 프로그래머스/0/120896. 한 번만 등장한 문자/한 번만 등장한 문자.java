import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int[] charArr = new int[27];
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charArr[ch - 'a']++;
        }
        for(int i = 0; i < charArr.length; i++) {
            if(charArr[i] == 1) {
                char ch = (char)(i + 'a');
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
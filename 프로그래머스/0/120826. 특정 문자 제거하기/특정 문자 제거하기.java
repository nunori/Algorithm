import java.util.*;

class Solution {
    public String solution(String my_string, String letter) {
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < my_string.length(); i++) {
            String s = String.valueOf(my_string.charAt(i));
            
            if(!s.equals(letter)) sb.append(s);
        }
        
        String result = String.valueOf(sb);
        
        return result;
        
    }
}
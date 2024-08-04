import java.util.*;
class Solution {
    boolean solution(String s) {
        
        String S = s.toUpperCase();
        
        int pCnt = 0;
        int yCnt = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(S.charAt(i) == 'P') pCnt++;
            else if(S.charAt(i) == 'Y') yCnt++;
            System.out.println(s.charAt(i));
        }
        
        boolean result = false;
        
        if(pCnt == yCnt) result = true;
        else result = false;
        
        if(pCnt == 0 && yCnt == 0) result = true;
        
        return result;
        
    }
}
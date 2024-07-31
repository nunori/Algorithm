import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder sb = new StringBuilder();
        
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            
            if (token.equals(" ")) {
                sb.append(token);
            } else {
                char firstChar = token.charAt(0);
                if (Character.isLowerCase(firstChar)) {
                    firstChar = Character.toUpperCase(firstChar);
                }
                sb.append(firstChar).append(token.substring(1).toLowerCase());
            }
        }
        
        return sb.toString();
    }
}
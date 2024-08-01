class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            
            switch(ch) {
                case 'a':
                    continue;
                case 'e':
                    continue;
                case 'i':
                    continue;
                case 'o':
                    continue;
                case 'u':
                    continue;
                default:
                    sb.append(ch);
            }
        }
        
        return sb.toString();
        
    }
}
class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        if(s.charAt(0) == '+') {
            for(int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
            }
        } else {
            for(int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
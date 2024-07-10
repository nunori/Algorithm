class Solution {
    public String solution(String my_string) {
        String s = "";
        for(int i = my_string.length() - 1; i >= 0; i--) {
            char c = my_string.charAt(i);
            s += c;
            
        }
        return s;
    }
}
class Solution {
    public int solution(int num, int k) {
        String s = Integer.toString(num);
        char ch = Character.forDigit(k, 10);
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ch) return i + 1;
        }
        return -1;
    }
}
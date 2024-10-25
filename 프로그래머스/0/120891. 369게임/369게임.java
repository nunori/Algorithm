class Solution {
    public int solution(int order) {
        String s = Integer.toString(order);
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '3' || s.charAt(i) == '6' || s.charAt(i) == '9') cnt++;
        }
        return cnt;
    }
}
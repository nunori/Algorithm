class Solution {
    public int solution(int i, int j, int k) {
        int cnt = 0;
        for(int a = i; a <= j; a++) {
            String s = Integer.toString(a);
            for(int b = 0; b < s.length(); b++) {
                if(s.charAt(b) == k + '0') cnt++;
            }
        }
        return cnt;
    }
}
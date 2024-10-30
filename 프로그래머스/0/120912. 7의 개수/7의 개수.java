class Solution {
    public int solution(int[] array) {
        int cnt = 0;
        for(int i : array) {
            String s = Integer.toString(i);
            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '7') cnt++;
            }
        }
        return cnt;
    }
}
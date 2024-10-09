class Solution {
    public int solution(String[] s1, String[] s2) {
        int res = 0;
        for(String s : s1) {
            for(String c : s2) {
                if(s.equals(c)) {
                    res++;
                }
            }
        }
        return res;
    }
}
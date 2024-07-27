class Solution {
    public int solution(int n, int t) {
        
        int total = 1;
        for(int i = 0; i < t; i++) {
            total *= 2;
        }
        
        return n * total;
    }
}
class Solution {
    static int[] memo;
    public int solution(int n) {
        memo = new int[n + 1];
        return fibo(n);
    }
    
    static int fibo(int n) {
        if(n <= 1) return n;
        else {
            if(memo[n] == 0) {
                memo[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
            }
            return memo[n];
        }
    }
}

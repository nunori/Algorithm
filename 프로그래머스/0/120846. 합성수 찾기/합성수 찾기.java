class Solution {
    public int solution(int n) {
        int cnt = 0;

        for (int num = 2; num <= n; num++) {
            int divisorCount = 0;
            
            for (int i = 1; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    divisorCount++;
                    
                    if (i != num / i) divisorCount++;
                }

                if (divisorCount >= 3) {
                    cnt++;
                    break;
                }
            }
        }

        return cnt;
    }
}
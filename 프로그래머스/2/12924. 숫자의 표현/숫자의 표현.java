class Solution {
    public int solution(int n) {
        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            int idx = i;
            int sum = 0;
            boolean flag = false;
            while(!flag) {
                sum += idx;
                idx++;
                if(sum >= n) flag = true;
            }
            if(sum == n) cnt++;
        }
        return cnt;
        
    }
}
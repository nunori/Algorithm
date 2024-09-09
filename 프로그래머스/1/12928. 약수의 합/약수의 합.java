class Solution {
    public int solution(int n) {
        int[] arr = new int[n];
        int idx = 0;
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                arr[idx] = i;
                idx++;
            }
        }
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
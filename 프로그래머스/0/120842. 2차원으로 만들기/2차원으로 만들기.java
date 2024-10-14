class Solution {
    public int[][] solution(int[] num_list, int n) {
        int len = num_list.length / n;
        int[][] arr = new int[len][n];
        int idx = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                arr[i][j] = num_list[idx];
                idx++;
            }
        }
        return arr;
    }
}
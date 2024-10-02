import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int[][] arr = new int[sizes.length][2];
        for(int i = 0; i < sizes.length; i++) {
            int a = sizes[i][0];
            int b = sizes[i][1];
            arr[i][0] = Math.max(a, b);
            arr[i][1] = Math.min(a, b);
        }
        int row = -1;
        int col = -1;
        
        for(int i = 0; i < arr.length; i++) {
            if(row < arr[i][0]) {
                row = arr[i][0];
            }
            if(col < arr[i][1]) {
                col = arr[i][1];
            }
        }
        return row * col;
    }
}
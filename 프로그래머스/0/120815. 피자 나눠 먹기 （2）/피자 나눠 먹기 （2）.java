class Solution {
    public int solution(int n) {
        int result = -1;
        for(int i = 1; i <= 6; i++) {
            int totalPiece = i * n;
            
            if(totalPiece % 6 == 0) {
                result = totalPiece / 6;
                break;
            }            
        }
        return result;
    }
}
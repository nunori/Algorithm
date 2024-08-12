class Solution {
    public int solution(int[] box, int n) {
        
        int a = box[0];
        int b = box[1];
        int c = box[2];
        
        int a2 = a / n;
        int b2 = b / n;
        int c2 = c / n;
        
        return a2 * b2 * c2;
        
    }
}
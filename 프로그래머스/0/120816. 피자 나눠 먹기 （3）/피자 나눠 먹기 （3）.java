class Solution {
    public int solution(int slice, int n) {
        double d1 = (double)n / (double)slice;
        int result = -1;
        if(n % slice == 0) result = n / slice;
        else result = (int) d1 + 1;
        return result;
    }
}
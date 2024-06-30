class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int codemon = denom1 * denom2;
        
        numer1 = numer1 * denom2;
        numer2 = numer2 * denom1;
        
        int conumer = numer1 + numer2;
        
        int ansdemon = 0;
        int ansnumer = 0;
        
        for(int i = 1; i <= conumer; i++) {
            if(codemon % i == 0 && conumer % i == 0) {
                ansdemon = codemon / i;
                ansnumer = conumer / i;
            }
        }
        
        int[] answer = {ansnumer, ansdemon};
        
        return answer;
    }
}
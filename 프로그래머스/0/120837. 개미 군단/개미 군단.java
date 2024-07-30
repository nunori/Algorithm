class Solution {
    public int solution(int hp) {
        
        int ant1 = hp / 5;
        int ant2 = (hp % 5) / 3;
        int ant3 = hp - (ant1 * 5 + ant2 * 3);
        
        return ant1 + ant2 + ant3;
        
    }
}
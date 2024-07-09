class Solution {
    public int[] solution(int money) {
        
        int howMany = money / 5500;
        int rest = money - howMany * 5500;
        
        int[] answer = {howMany, rest};
        return answer;
    }
}
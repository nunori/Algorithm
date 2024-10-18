class Solution {
    public int solution(int n) {
        int answer = 0;
        int fact = 1;
        int i = 1;

        while (fact <= n) {
            answer = i;
            i++;
            fact *= i;
        }

        return answer;
    }
}
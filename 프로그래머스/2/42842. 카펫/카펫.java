class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int[] answer = new int[2];
        for(int i  = 3; i <= total/2; i++) {
            answer[0] = Math.max(i, total / i);
            answer[1] = Math.min(i, total / i);
            if((total % i == 0) && ((answer[0] - 2) * (answer[1] - 2) == yellow)) {
                break;
            }
        }
        return answer;
    }
}
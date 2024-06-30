class Solution {
    public int[] solution(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            int tmp = numbers[i];
            numbers[i] = tmp * 2;
        }
        return numbers;
    }
}
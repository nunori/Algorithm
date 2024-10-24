class Solution {
    public int[] solution(int[] numbers, String direction) {
        if(direction.equals("left")) {
            for(int i = 0; i < numbers.length - 1; i++) {
                int tmp = numbers[i];
                numbers[i] = numbers[(i + 1) % numbers.length];
                numbers[(i + 1) % numbers.length] = tmp;
            }
        } else {
            for(int i = numbers.length - 1; i > 0; i--) {
                int tmp = numbers[i];
                numbers[i] = numbers[(i - 1) % numbers.length];
                numbers[(i - 1) % numbers.length] = tmp;
            }
        }
        return numbers;
    }
}
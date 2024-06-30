class Solution {
    public int solution(int[] array) {
        
        int maxNum = -1;
        
        for(int i = 0; i < array.length; i++) {
            if(array[i] > maxNum) {
                maxNum = array[i];
            }
        }
        
        int[] count = new int[maxNum + 1];
        for(int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }
        
        int answer = 0;
        int max = -1;
        int check = 0;
        int index = -1;
        
        for(int i = 0; i < count.length; i++) {
            if(count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        
        for(int i = 0; i < count.length; i++) {
            if(count[i] == max) check++;
        }
        
        if(check > 1) answer = -1;
            else answer = index;
        
        return answer;
    }
}
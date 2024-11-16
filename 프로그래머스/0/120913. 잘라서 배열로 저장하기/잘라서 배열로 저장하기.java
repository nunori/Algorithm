class Solution {
    public String[] solution(String my_str, int n) {
        int size = (my_str.length() + n - 1) / n;
        String[] result = new String[size];
        
        for (int i = 0; i < size; i++) {
            int start = i * n;
            int end = Math.min(start + n, my_str.length());
            result[i] = my_str.substring(start, end);
        }
        
        return result;
    }
}
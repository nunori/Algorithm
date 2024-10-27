import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            if(ch - '0' >= 0 && ch - '0' <= 9) {
                list.add(ch - '0');
            }
        }
        Collections.sort(list);
        int[] arr = new int[list.size()];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
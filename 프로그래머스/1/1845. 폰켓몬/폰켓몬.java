import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            if(!set.contains(i) && set.size() < nums.length / 2) {
                set.add(i);
            }
        }
        return set.size();
    }
}
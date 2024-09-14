import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String s : operations) {
            StringTokenizer st = new StringTokenizer(s);
            char ch = st.nextToken().charAt(0);
            switch(ch) {
                case 'I': {
                    int temp = Integer.parseInt(st.nextToken());
                    minHeap.add(temp);
                    maxHeap.add(temp);
                    break;
                }
                case 'D': {
                    int temp = Integer.parseInt(st.nextToken());
                    if(temp == -1) {
                        maxHeap.remove(minHeap.poll());
                        break;
                    } else {
                        minHeap.remove(maxHeap.poll());
                        break;
                    }
                }
            }
        }
        if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
            return new int[] {maxHeap.poll(), minHeap.poll()};
        }
        else {
            return new int[] {0, 0};
        }
    }
}
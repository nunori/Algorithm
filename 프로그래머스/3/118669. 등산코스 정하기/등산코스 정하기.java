import java.util.*;

class Node implements Comparable<Node> {
    int to;
    int weight;
    Node(int b, int c) {
        to = b;
        weight = c;
    }
    
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

class Solution {
    
    List<Node>[] graph;
    Set<Integer> gatesSet, summitsSet;
    int[] dist;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        graph = new List[n + 1];
        dist = new int[n + 1];
        for(int i = 0; i <= n; ++i) {
            graph[i] = new ArrayList<>();
        }
        gatesSet = new HashSet<>();
        summitsSet = new HashSet<>();
        
        for(int gate : gates) gatesSet.add(gate);
        for(int summit : summits) summitsSet.add(summit);
        
        for(int[] path : paths) {
            int u = path[0];
            int v = path[1];
            int w = path[2];
            if(!gatesSet.contains(v) && !summitsSet.contains(u))
                graph[u].add(new Node(v, w));
            if(!gatesSet.contains(u) && !summitsSet.contains(v))
                graph[v].add(new Node(u, w));
        }
        
        return search(n, gates, summits);
    }
    
    public int[] search(int n, int[] gates, int[] summits) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int gate : gates) {
            pq.add(new Node(gate, 0));
            dist[gate] = 0;
        }
        
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int currentNode = curr.to;
            int currentDist = curr.weight;
            
            if(currentDist > dist[currentNode]) continue;
            
            for(Node neighbor : graph[currentNode]) {
                int nextNode = neighbor.to;
                int pathWeight = neighbor.weight;
                int newDist = Math.max(currentDist, pathWeight);
                
                if(newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.add(new Node(nextNode, newDist));
                }
            }
        }
        
        int minIntensity = Integer.MAX_VALUE;
        int bestSummit = -1;
        
        Arrays.sort(summits);
        for(int summit : summits) {
            if(dist[summit] < minIntensity) {
                minIntensity = dist[summit];
                bestSummit = summit;
            }
        }
        
        return new int[]{bestSummit, minIntensity};
    }
}
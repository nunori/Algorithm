import java.util.*;

class Solution {
    public String[] solution(String[] commands) {
        Matrix matrix = new Matrix();
        return matrix.apply(commands);
    }
}

class Matrix {
    static final int RANGE = 2501;
    
    int[] parent = new int[RANGE];
    String[] values = new String[RANGE];
    
    Matrix() {
        for (int i = 1; i < RANGE; i++) {
            parent[i] = i;
            values[i] = "";
        }
    }
    
    int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
    
    void union(int a, int b) {
        if (a != b) parent[b] = a;
    }
    
    int convertIndex(int row, int col) {
        return 50 * (row - 1) + col;
    }
    
    void update(int r, int c, String value) {
        int idx = convertIndex(r, c);
        values[find(idx)] = value;
    }
    
    void update(String before, String after) {
        for (int i = 1; i < RANGE; i++) {
            if (before.equals(values[i])) values[i] = after;
        }
    }
    
    void merge(int r1, int c1, int r2, int c2) {
        if (r1 == r2 && c1 == c2) return;
        
        int idx1 = convertIndex(r1, c1);
        int idx2 = convertIndex(r2, c2);
        
        int root1 = find(idx1);
        int root2 = find(idx2);
        
        if (root1 == root2) return;
        
        String root = values[root1].isBlank() ? values[root2] : values[root1];
        values[root2] = "";
        
        union(root1, root2);
        values[root1] = root;
    }
    
    void unmerge(int r, int c) {
        int idx = convertIndex(r, c);
        int root = find(idx);
        
        String rootValue = values[root];
        values[root] = "";
        values[idx] = rootValue;
        List<Integer> dels = new ArrayList<>();
        for (int i = 1; i < RANGE; i++) {
            if (find(i) == root) {
                dels.add(i);
            }
        }
        for (Integer i : dels) {
            parent[i] = i;
        }
    }
    
    String print(int r, int c) {
        int idx = convertIndex(r, c);
        int root = find(idx);
        
        if (values[root].isBlank()) {
            return "EMPTY";
        }
        return values[root];
    }
    
    String[] apply(String[] commands) {
        List<String> result = new ArrayList<>();
        
        for (String command : commands) {
            String[] cmds = command.split(" ");
            
            String cmd = cmds[0];
            
            if (cmd.equals("UPDATE")) {
                if (cmds.length == 4) {
                    int r = Integer.parseInt(cmds[1]);
                    int c = Integer.parseInt(cmds[2]);
                    String value = cmds[3];
                    update(r, c, value);
                } else {
                    String value1 = cmds[1];
                    String value2 = cmds[2];
                    update(value1, value2);
                }
            } else if (cmd.equals("MERGE")) {
                int r1 = Integer.parseInt(cmds[1]);
                int c1 = Integer.parseInt(cmds[2]);
                int r2 = Integer.parseInt(cmds[3]);
                int c2 = Integer.parseInt(cmds[4]);
                merge(r1, c1, r2, c2);
            } else if (cmd.equals("UNMERGE")) {
                int r = Integer.parseInt(cmds[1]);
                int c = Integer.parseInt(cmds[2]);
                unmerge(r, c);
            } else if (cmd.equals("PRINT")) {
                int r = Integer.parseInt(cmds[1]);
                int c = Integer.parseInt(cmds[2]);
                result.add(print(r, c));
            }
        }
        
        return result.toArray(new String[0]);
    }
}
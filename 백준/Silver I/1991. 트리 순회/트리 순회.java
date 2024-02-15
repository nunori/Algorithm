import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    char data;
    Node left, right;
    
    public Node(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    static Node[] nodes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nodes = new Node[26]; // A부터 Z까지 가능한 모든 노드에 대해 배열 생성

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parentData = st.nextToken().charAt(0);
            char leftData = st.nextToken().charAt(0);
            char rightData = st.nextToken().charAt(0);

            Node parent = findOrCreateNode(parentData);

            if(leftData != '.') {
                parent.left = findOrCreateNode(leftData);
            }
            if(rightData != '.') {
                parent.right = findOrCreateNode(rightData);
            }
        }

        preorder(nodes['A' - 'A']); // 루트 노드 A부터 전위 순회 시작
        System.out.println();
        inorder(nodes['A' - 'A']); // 루트 노드 A부터 중위 순회 시작
        System.out.println();
        postorder(nodes['A' - 'A']); // 루트 노드 A부터 후위 순회 시작
    }

    static Node findOrCreateNode(char data) {
        if (nodes[data - 'A'] == null) {
            nodes[data - 'A'] = new Node(data);
        }
        return nodes[data - 'A'];
    }

    static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

    static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
    }
}
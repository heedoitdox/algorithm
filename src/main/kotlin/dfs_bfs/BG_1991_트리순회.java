package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1991 트리순회
 * https://www.acmicpc.net/problem/1991
 */
public class BG_1991_트리순회 {
    static int N;
    static Node[] tree;
    static StringBuilder sb = new StringBuilder();

    // 전위 순회
    public static void preorder(Node node) {
        if (node == null) return;
        sb.append(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회
    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        sb.append(node.value);
        inorder(node.right);
    }

    // 후위 순회
    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        sb.append(node.value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new Node[N+1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 띄어쓰기 기준으로 문자열 분리
            char parentValue = st.nextToken().charAt(0); // nextToken() 메서드로 토큰을 하나씩 꺼내오면 StringTokenizer객체에는 해당 토큰이 사라진다
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            // Java에서 char 데이터 타입은 내부적으로 ASCII 코드를 사용
            if (tree[parentValue - 'A'] == null) { // 부모 노드가 아직 생성되지 않은 경우. 'A'는 문자 'A'의 ASCII 값
                tree[parentValue - 'A'] = new Node(parentValue); // 부모 노드를 생성
            }
            if (leftValue != '.') { // 왼쪽 자식이 존재할 경우
                tree[leftValue - 'A'] = new Node(leftValue); // 왼쪽 자식 노드를 생성
                tree[parentValue - 'A'].left = tree[leftValue - 'A']; // 부모 노드와 연결
            }
            if (rightValue != '.') { // 오른쪽 자식이 존재할 경우
                tree[rightValue - 'A'] = new Node(rightValue); // 오른쪽 자식 노드를 생성
                tree[parentValue - 'A'].right = tree[rightValue - 'A']; // 부모 노드와 연결
            }
        }

        // 전위 순회
        preorder(tree[0]);
        sb.append("\n");

        // 중위 순회
        inorder(tree[0]);
        sb.append("\n");

        // 후위 순회
        postorder(tree[0]);
        sb.append("\n");

        System.out.println(sb);
    }
}

class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

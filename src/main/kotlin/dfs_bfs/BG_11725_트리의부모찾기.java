package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 11725 트리의부모찾기
 * https://www.acmicpc.net/problem/11725
 *
 * 인접행렬을 사용해서 풀었는데 최대 크기인 십만 * 십만이 되면 메모리가 초과된다.
 * 미리 모두 할당해놓으면 메모리가 부족하기 때문에 연결리스트로 풀어야한다.
 */
public class BG_11725_트리의부모찾기 {
    static int N;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N+1];
        for (int i=0; i<N+1; i++) adj[i] = new ArrayList <>();

        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            adj[n1].add(n2);
            adj[n2].add(n1);
        }

        visited = new boolean[N+1];
        parent = new int[N+1];
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N; i++){
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int node) {
        visited[node] = true;

        for(int i: adj[node]){
            if(visited[i]) continue;
            parent[i] = node;
            dfs(i);
        }
    }
}

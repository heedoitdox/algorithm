package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 1260 DFS와 BFS
 * https://www.acmicpc.net/problem/1260
 */
public class BG_1260_DFS와BFS {
    static int[][] map;
    static boolean[] visited;
    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        int v = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호

        map = new int[n+1][n+1];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            map[n1][n2] = 1;
            map[n2][n1] = 1;
        }

        sb = new StringBuilder();
        visited = new boolean[n+1];
        dfs(v);
        System.out.println(sb);

        sb = new StringBuilder();
        visited = new boolean[n+1];
        bfs(v);
        System.out.println(sb);
    }

    static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");

        for(int i = 1; i < map.length; i++) {
            if(visited[i]) continue;
            if(map[node][i] == 1) dfs(i);
        }
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.offer(node);

        while(!queue.isEmpty()) {
            int q = queue.poll();
            sb.append(q).append(" ");

            for(int i = 1; i <= n; i++) {
                if(visited[i]) continue;
                if(map[q][i] == 1) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}

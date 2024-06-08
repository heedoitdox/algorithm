package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 백준 2606 바이러스
 * https://www.acmicpc.net/problem/2606
 *
 * 간선을 연결해줄 때는 무조건 양방향으로 연결해줘야함
 *
 * 확실히 인접행렬 방식이 속도가 훨씬 빠름
 * 인접행렬: 108ms
 * 인접리스트: 128ms
 */
public class BG_2606_바이러스 {
    static LinkedList<Integer>[] graph;
    static int cnt;
    static boolean[] visited;

    static boolean adj[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 컴퓨터 대수
        int k = Integer.parseInt(br.readLine()); // 연결된 번호 쌍

//        graph = new LinkedList[n + 1];
//        // 각 요소를 LinkedList 로 초기화
//        for (int i = 0; i <= n; i++) {
//            graph[i] = new LinkedList<>();
//        }

        adj = new boolean[n+1][n+1];
        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            adj[n1][n2] = true; // 서로 연결되어있음을 의미
            adj[n2][n1] = true; // 동일
        }

//        while(k-->0){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int n1 = Integer.parseInt(st.nextToken());
//            int n2 = Integer.parseInt(st.nextToken());
//            graph[n1].add(n2);
//            graph[n2].add(n1);
//        }

        visited = new boolean[n+1];
//        dfs(1); // 바이러스의 걸린 1번 컴퓨터 부터 시작
        dfs2(1);

        for (boolean v : visited) {
            if (v) {
                cnt++;
            }
        }

        System.out.println(cnt-1); // 처음으로 감염된 1번 컴퓨터는 제외
    }

    // 인접 리스트 방식
//    static void dfs(int n) {
//        visited[n] = true;
//
//        for(int i = 0; i < graph[n].size(); i++) {
//            if(!visited[graph[n].get(i)]) {
//                cnt++; // 감염된 컴퓨터의 수를 더함
//                dfs(graph[n].get(i)); // 방문한적없을 때만 재귀 호출
//            }
//        }
//    }

    // 인접 행렬 방식
    static void dfs2(int n) {
        visited[n] = true; // 방문함

        for(int i = 1; i < adj.length; i++) {
            if(visited[i]) continue; // 이미 방문한 노드라면 건너띔
            if(adj[n][i]) dfs2(i); // 방문하지 않은 대상의 노드는 다시 재귀호출
        }
    }
}

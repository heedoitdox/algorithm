package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1325 효율적인해킹
 *
 * 신뢰하는관계와 신뢰하지않는관계
 * 신뢰하는 관계가 주어졌을 때 한번에 가장 많은 컴퓨터를 해킹할 수 있는 번호를 출력
 */
public class BG_1325_효율적인해킹 {
    static int n;
    static boolean[][] adj;
    static int[] visited;
    static int[] result;
//    static int max = Integer.MIN_VALUE;

    static ArrayList <Integer>[] arr;
    static boolean isVisited[];
    static int max;
    static int cntArr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

//        adj = new boolean[n+1][n+1];

        arr = new ArrayList[n+1];
        for (int i=0; i<n+1; i++) arr[i] = new ArrayList <Integer>();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
//            adj[n2][n1] = true; // 요구사항을 만족하기 위해서는 단방향으로 해줘야한다.
            arr[n1].add(n2);
        }

        result = new int[n+1];
        for(int i = 1; i <= n; i++) {
//            visited = new int[n+1];
            isVisited = new boolean[n+1];
            DFS(i);
        }
        
//        for(int i = 1; i <= n; i++) {
//            max = Math.max(max, result[i]);
//        }

        // 해킹할 수 있는 최댓값 찾기
        for (int i=1; i<n+1; i++) {
            if (max<cntArr[i]) max = cntArr[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            if(max == result[i]) sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

//    static void dfs(int node) {
//        visited[node] = 1;
//
//        for(int i = 1; i <= n; i++) {
//            if(visited[i] == 1) continue;
//            if(adj[node][i]) {
//                dfs(i);
//            }
//        }
//    }

    static void DFS(int start) {
        isVisited[start] = true;
        for (int i : arr[start]) {
            if (isVisited[i]) continue;
            cntArr[i]++; // i가 해킹할 수 있는 숫자 증가
            DFS(i);
        }
    }
}

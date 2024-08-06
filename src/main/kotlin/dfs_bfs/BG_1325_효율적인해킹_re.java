package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BG_1325_효율적인해킹_re {
    static int N, M;
    static int[][] arr;
    static int[] visited;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        cnt = new int[N+1];
        while(M-->0) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            arr[n1][n2] = 1; // 단방향으로 연결 <- 중요
        }

        for(int i = 1; i <= N; i++) {
            visited = new int[N+1];
            dfs(i);
        }


        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            max = Math.max(cnt[i], max);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if(max == cnt[i]) sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    static void dfs(int node) {
        visited[node] = 1;

        for(int i = 1; i <= N; i++) {
            if(visited[i] == 1) continue;
            if(arr[node][i] == 1) { // 신뢰한다면
                cnt[i]++;
                dfs(i);
            }
        }
    }
}

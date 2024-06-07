package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 1012 유기농배추
 * https://www.acmicpc.net/problem/1012
 */
public class BG_1012_유기농배추 {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 남 서 동 북
    static int m;
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로길이
            n = Integer.parseInt(st.nextToken()); // 세로길이
            int k = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수

            // 인접행렬로 데이터 삽입
            map = new int[n][m];
            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                map[n2][n1] = 1;
            }

            visited = new boolean[n][m];
            queue = new LinkedList<>();
            cnt = 0;
            for(int j = 0; j < n; j++) {
                for(int l = 0; l < m; l++) {
                    bfs(map, j, l);
                }
            }

            sb.append(cnt).append("\n");
            cnt = 0;
        }

        System.out.println(sb);
    }

    static void bfs(int[][] map, int x, int y) {
        if(visited[x][y] || map[x][y] == 0) return;
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] q = queue.poll();
            for(int i = 0; i < dirs.length; i++) { // 남서동북 사방을 확인한다.
                int tempX = q[0] + dirs[i][0];
                int tempY = q[1] + dirs[i][1];

                // 좌표들이 범위안에 있고, 배추가 심어져 있고, 방문한 적이 없다면
                if(0 <= tempX && tempX < n && 0 <= tempY && tempY < m && map[tempX][tempY] == 1 && !visited[tempX][tempY]) {
                    queue.add(new int[]{tempX, tempY});
                    visited[tempX][tempY] = true;
                }
            }
        }

        cnt++;
    }
}

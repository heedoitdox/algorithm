package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2178 미로탐색
 * https://www.acmicpc.net/problem/2178
 * 시간: 164ms
 */
public class BG_2178_미로탐색 {
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int m;
    static Queue<int[]> queue = new LinkedList<>();
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(map[n-1][m-1]); // 시작점도 합쳐줘야한다.
    }

    static void bfs() {
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        map[0][0] = 1;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int d = 0; d < 4; d++) {
                int nx = cur[0] + dir[d][0];
                int ny = cur[1] + dir[d][1];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(map[nx][ny] == 0) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
                map[nx][ny] = map[cur[0]][cur[1]] + 1;
            }
        }
    }
}

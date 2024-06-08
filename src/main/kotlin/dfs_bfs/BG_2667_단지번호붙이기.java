package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 2667 단지번호붙이기
 * https://www.acmicpc.net/problem/2667
 */
public class BG_2667_단지번호붙이기 {
    static int N, totalCnt;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static LinkedList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new boolean[N][N];
        result = new LinkedList<>();
        totalCnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                // 집이 있고 방문한 적이 없는 경우
                if(map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    totalCnt++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(result);
        for(int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }
        System.out.println(totalCnt);
        System.out.println(sb);

    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        int cnt = 1;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int d = 0; d < dir.length; d++) {
                int nx = cur[0] + dir[d][0];
                int ny = cur[1] + dir[d][1];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny]) continue;

                if(map[nx][ny] == 1) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }

        result.add(cnt);
    }
}

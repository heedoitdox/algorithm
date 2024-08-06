package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2146 다리만들기
 * https://www.acmicpc.net/problem/2146
 *
 *
 */
public class BG_다리만들기 {
    static int N;
    static int[][] map;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        queue = new LinkedList<>();
        map = new int[N][N];
        StringTokenizer sb;
        for(int i = 0; i < N; i++) {
            sb = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(sb.nextToken());
                if(map[i][j] == 1) queue.add(new int[]{i, j}); // 섬일때 큐에 넣어버림
            }
        }

        grouping();
        System.out.println(getShortest());
    }

    static void grouping() {
        int groupNum = 1;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] != 1) continue;

                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j}); // 섬이라면 좌표를 큐에 넣는다.

                map[i][j] = ++groupNum; // 섬을 넘버링

                while(!q.isEmpty()) {
                    int[] point = q.poll();
                    for(int d = 0; d < 4; d++) {
                        int nx = point[0] + dir[d][0];
                        int ny = point[1] + dir[d][1];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue; // 인덱스를 벗어난다면
                        if(map[nx][ny] != 1) continue; // 처음세팅된 섬이 아니라면

                        q.add(new int[]{nx, ny});
                        map[nx][ny] = groupNum;
                    }
                }
            }
        }
    }

    static int getShortest() {
        int min = Integer.MAX_VALUE;
        int[][] visited = new int[N][N];

        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            for(int d = 0; d < 4; d++) {
                int nx = point[0] + dir[d][0];
                int ny = point[1] + dir[d][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(map[nx][ny] == 0) { // 바다라면
                    map[nx][ny] = map[point[0]][point[1]]; // 섬 번호로 업데이트
                    visited[nx][ny] = visited[point[0]][point[1]] + 1; // 거리를 기록해주고
                    queue.add(new int[]{nx, ny}); // 큐에 넣어준다
                }else if (map[nx][ny] != map[point[0]][point[1]]) {
                    min = Math.min(min, visited[nx][ny] + visited[point[0]][point[1]]);
                }
            }
        }

        return min;
    }
}

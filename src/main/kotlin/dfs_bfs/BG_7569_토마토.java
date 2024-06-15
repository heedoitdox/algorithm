package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 백준 7569 토마토
 * https://www.acmicpc.net/problem/7569
 *
 * 최소 날을 구하기 위해서는 순회하고자 하는 노드를 제일 먼저 queue 에 모두 담고 시작해야한다.
 */
public class BG_7569_토마토 {
    static int M, N, H;
    static int[][][] arr;
    static int[][] dir = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    static StringBuilder sb = new StringBuilder();
    static int day = Integer.MIN_VALUE;
    static ArrayDeque<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        boolean unRiped = false;
        arr = new int[H][N][M]; // 면 행 열
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int n = Integer.parseInt(st.nextToken());
                    arr[i][j][k] = n;
                    if (n == 0) unRiped = true;
                }
            }
        }

        if (!unRiped) {
            sb.append("0");
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 1) queue.offer(new int[]{i, j, k});
                }
            }
        }

        bfs();

        unRiped = false;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0) unRiped = true;
                    day = Math.max(arr[i][j][k], day);
                }
            }
        }

        if (unRiped) sb.append("-1");
        else sb.append(day-1);

        System.out.println(sb);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < dir.length; d++) {
                int nh = cur[0] + dir[d][0]; // 면
                int nn = cur[1] + dir[d][1]; // 행
                int nm = cur[2] + dir[d][2]; // 열

                // 인덱스를 벗어나거나 && 방문한적이 있다면 pass
                if (nh < 0 || nh >= H || nn < 0 || nn >= N || nm < 0 || nm >= M) continue;

                if(arr[nh][nn][nm] == 0) {
                    queue.add(new int[]{nh, nn, nm});
                    arr[nh][nn][nm] = arr[cur[0]][cur[1]][cur[2]] + 1;
                }
            }
        }
    }
}

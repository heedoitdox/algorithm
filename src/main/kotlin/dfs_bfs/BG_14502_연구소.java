package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 14502 연구소
 * https://www.acmicpc.net/problem/14502
 * <p>
 * 0: 빈칸, 1: 벽, 2: 바이러스
 * 벽은 꼭 3개만 세울 수 있고, 안전영역의 최대값을 출력
 * 칸은 최대 64개 (3 <= N,M <= 8)
 * <p>
 * 3개를 세울 수 있는 모든 경우의 수를 구함과 동시에
 * 바이러스가 벽 세운 이후로 퍼진 모양을 보고 최댓값을 그 경우의 수마다 다 구해야한다?
 *
 * 시간: 972ms
 */
public class BG_14502_연구소 {
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max);
    }

    static void dfs(int wallCnt) {
        //벽이 3개가 설치 된 경우 bfs 탐색 시작
        if(wallCnt == 3) {
            infection();
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                // 어차피 재귀 호출하면 여기서 걸러지기 때문에 3중 포문같은건 사용할 필요 없음
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wallCnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    // bfs 로 바이러스가 감염된 연구소 map 을 만듦
    static void infection() {
        Queue<int[]> queue = new LinkedList<>();

        // 원본 연구소를 바꾸지 않기 위한 카피맵 사용
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 초기에 바이러스가 있는 좌표는 모두 큐에 넣는다.
                if (copyMap[i][j] == 2) queue.add(new int[]{i, j});
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < dir.length; d++) {
                int nx = cur[0] + dir[d][0];
                int ny = cur[1] + dir[d][1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (copyMap[nx][ny] == 0) {
                    copyMap[nx][ny] = 2; // 감염시키고
                    queue.add(new int[]{nx, ny}); // 큐에 넣는다.
                }
            }
        }

        countSafeZone(copyMap);
    }

    static void countSafeZone(int[][] copyMap) {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) cnt++;
            }
        }

        max = Math.max(max, cnt);
    }
}

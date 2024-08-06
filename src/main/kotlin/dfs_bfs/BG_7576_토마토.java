package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 7576 토마토
 * https://www.acmicpc.net/problem/7576
 *
 * BFS 로 풀어본다
 * queue 에 익은 토마토 부터 차례대로 넣고 빌 떄까지 반복하면서 진행하고
 * 마지막으로 map 에 0 이 존재하는지 확인해서 -1 또는 최소 일수를 출력
 *
 * 중복되지 않는 depth 임을 어떻게 카운팅할 것인가?
 * -> queue 에 넣는 값들 중에 depth 를 같이 넣는다.
 */
public class BG_7576_토마토 {
    static int m;
    static int n;
    static int[][] box;
    static Queue<int[]> queue;
    static int day;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 동서남북

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        box = new int[n][m];
        // 2차원이기때문에 2중 포문
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                int num = Integer.parseInt(s[j]);
                box[i][j] = num;

                // 토마토가 있는 칸은 미리 큐에 넣는다.
                // x, y, depth 순서의 배열을 queue 에 넣는다.
                if(num == 1) queue.offer(new int[]{i, j, 0});
            }
        }

        bfs();

        boolean flag = false;
        for(int i = 0; i < n*m; i++) { // 토마토가 다 익지 못하는 상황
            if(box[i/m][i%m] == 0) {
                flag = true;
                break;
            }
        }

        if(!flag) System.out.println(day);
        else System.out.println(-1);
    }

    static void bfs(){
        while(!queue.isEmpty()) {
            int[] q = queue.poll();
            day = q[2]; // depth 를 계속 갱신한다. => 얼마만에 익었는지

            for(int i = 0; i < dir.length; i++) {
                int x = q[0] + dir[i][0];
                int y = q[1] + dir[i][1];

                if(0 <= x && x < n && 0 <= y && y < m && box[x][y] == 0) { // 인덱스를 벗어나지 않고 익지않은 토마토라면
                    box[x][y] = 1; // 익음 처리
                    queue.offer(new int[]{x, y, q[2]+1}); // depth + 1
                }
            }

        }
    }
}

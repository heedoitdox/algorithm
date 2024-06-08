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
 *
 * 가까운 노드부터 탐색하기 위해 BFS 사용
 */
public class BG_1012_유기농배추 {
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 남 서 동 북
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
                int n1 = Integer.parseInt(st.nextToken()); // x
                int n2 = Integer.parseInt(st.nextToken()); // y
                map[n2][n1] = 1;
            }

            visited = new boolean[n][m];
            queue = new LinkedList<>();
            cnt = 0;

            // 2개의 반복문을 돌면서 모든 땅의 칸을 방문한다.
            for(int j = 0; j < n; j++) {
                for(int l = 0; l < m; l++) {
                    bfs(map, j, l);
                }
            }

            sb.append(cnt).append("\n");
            cnt = 0; // 다음 테스트 케이스를 위해서 0 으로 초기화
        }

        System.out.println(sb);
    }

    static void bfs(int[][] map, int x, int y) {
        if(visited[x][y] || map[x][y] == 0) return; // 이미 방문했거나 배추가 없다면 return
        queue.add(new int[]{x, y}); // 대상이 되는 땅을 queue 에 add
        visited[x][y] = true; // 방문 체크

        while(!queue.isEmpty()) {
            int[] q = queue.poll();
            for(int i = 0; i < dir.length; i++) { // 동서남북 사방을 확인한다.
                int tempX = q[0] + dir[i][0];
                int tempY = q[1] + dir[i][1];

                // 좌표들이 범위안에 있고, 배추가 심어져 있고, 방문한 적이 없다면
                if(0 <= tempX && tempX < n && 0 <= tempY && tempY < m && map[tempX][tempY] == 1 && !visited[tempX][tempY]) {
                    queue.add(new int[]{tempX, tempY});
                    visited[tempX][tempY] = true; // 방문 체크
                }
            }
        }

        cnt++; // 연결된 노드가 끝나면 1개의 묶인 구역이기 때문에 카운팅
    }
}

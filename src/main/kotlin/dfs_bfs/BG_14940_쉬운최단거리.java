package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 14940 쉬운 최단 거리
 * https://www.acmicpc.net/problem/14940
 *
 * 각 모든 지점에서 목표점으로 갈 수 있는 최단거리
 * 목표지점을 시작점으로 풀어나가기?
 *
 * BFS 가 탐색하지 않는 위치
 */
public class BG_14940_쉬운최단거리 {
    static int n;
    static int m;
    static int[][] map;
    static int goalX;
    static int goalY;
    static int[][] visited;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        visited = new int[n][m];
        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                if(s[j].equals("2")) { // 목표지점이라면 저장한다. (목표지점은 단 한개)
                    goalX = i;
                    goalY = j;
                }
                map[i][j] = Integer.parseInt(s[j]);
                if(s[j].equals("0")) visited[i][j] = 0; // 해주지 않으면 방문하지 못해서 -1 로 남기 때문에 꼭! 해줘야함
                else visited[i][j] = -1; // 도달할 수 없다를 기본으로 세팅해둔다
            }
        }

        bfs(goalX, goalY, 0);

        printResult();
    }

    // 결과 출력
    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(visited[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y, int level) {
        queue.add(new int[]{x, y, level});
        visited[x][y] = level;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int[] dir : dir) {
                int newX = cur[0] + dir[0];
                int newY = cur[1] + dir[1];
                int newLevel = cur[2] + 1;

                if(newX >= 0 && newX < n && newY >= 0 && newY < m) { // 상하좌우 방향 탐색
                    if(visited[newX][newY] == -1) { // 초기세팅이라면
                        queue.offer(new int[]{newX, newY, newLevel});
                        visited[newX][newY] = newLevel;
                    }
                }
            }
        }
    }
}

package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 16234 인구이동
 * https://www.acmicpc.net/problem/16234
 */
class Coordinate{
    int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BG_16234_인구이동 {
    static int N, L, R;
    static int[][] map;
    static int[][] visited;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int cnt, sum;

    static boolean moved = false;
    static int day = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move();
        System.out.println(day);
    }

    static void move() {
        while(true) {
            moved = false;
            visited = new int[N][N];
            cnt = 0;
            sum = 0;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(visited[i][j] == 0) {
                        visited[i][j] = 1;
                        bfs(i, j);
                    }
                }
            }

            if(!moved) break;
            else day++;
        }
    }

    static void bfs(int x, int y) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(x, y));

        cnt++;
        sum += map[x][y];

        while(!queue.isEmpty()) {
            Coordinate curr = queue.poll();

            for(int d = 0; d < 4; d++) {
                int nx = curr.x + dir[d][0];
                int ny = curr.y + dir[d][1];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue; // 인덱스 범위를 벗어났을 때
                if(visited[nx][ny] == 1) continue; // 이미 방문한 좌표일 때

                int abs = Math.abs(map[curr.x][curr.y] - map[nx][ny]) ;
                if(L > abs || abs > R) continue;

                moved = true; // 움직일것이므로 true 로 변경
                cnt++; // 나라를 카운팅
                sum += map[nx][ny];
                visited[nx][ny] = 1;
                queue.add(new Coordinate(nx, ny));
            }
        }

        union();
    }

    static void union() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j] == 1) {
                    map[i][j] = sum / cnt;
                }
            }
        }
    }
}

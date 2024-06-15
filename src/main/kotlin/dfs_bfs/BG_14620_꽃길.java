package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 중간고사
 * 백준 14620 꽃길
 * https://www.acmicpc.net/problem/14620
 */
public class BG_14620_꽃길 {
    static int N;
    static int[][] map;
    static int[][] visited;
    static int[][] plant;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int min = Integer.MAX_VALUE;
    static boolean completed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        plant = new int[N][N];
        // 꽃을 심기위한 최소 비용
        // 씨앗은 세개뿐인데 세개를 모두 피게 하고 싶다.
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                plant = new int[N][N];
                visited = new int[N][N];
                dfs(1, i, j);
                cleanAll();
            }
        }

        System.out.println(min);
    }

    static void dfs(int level, int x, int y) {
        if(plant[x][y]==1) return;
        if(level==3 && x == N-1 && y == N-1) completed = true;

        int passCnt = 0;
        for(int d = 0; d < dir.length; d++){ // 동서남북 꽃을 피울 수 있는지 체크
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];

            // 하나라도 범위를 벗어난다면 break;
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
            // 방문한적 (씨앗 & 꽃잎) 있다면 break;
            if(plant[nx][ny] != 0) break;

            passCnt++;
        }

        // 씨앗을 심어서 꽃잎이 폈다는 체크
        if(passCnt == 4) {
            plant[x][y] = level;
            plant[x + dir[0][0]][y + dir[0][1]] = level;
            plant[x + dir[1][0]][y + dir[1][1]] = level;
            plant[x + dir[2][0]][y + dir[2][1]] = level;
            plant[x + dir[3][0]][y + dir[3][1]] = level;

            if(level == 3) { // 3개의 씨앗을 다 심었다면 비용을 계산한다.
                min = Math.min(min, sumPlant());
                clean3();
                return;
            }
        } else {
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(plant[i][j]!=0) continue; // 심은적이 있다면
                if(visited[i][j]!=0) continue;

                visited[i][j] = 1;
                dfs(level+1, i, j);
                if(completed) clean2();
                completed = false;
                visited[i][j] = 0;
            }
        }
    }

    static void cleanAll() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                plant[i][j] = 0;
            }
        }
    }

    static void clean2() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(plant[i][j] >= 2) plant[i][j] = 0;
            }
        }
    }

    static void clean3() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(plant[i][j] == 3) plant[i][j] = 0;
            }
        }
    }

    static int sumPlant() {
        int sum = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(plant[i][j] !=0) sum += map[i][j];
            }
        }
        return sum;
    }
}

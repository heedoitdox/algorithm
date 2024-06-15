package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 중간고사
 * 백준 5547 일루미네이션
 * https://www.acmicpc.net/problem/5547
 * <p>
 * 1. 안쪽이 1인 부분은 소용없음 무조건 건물 외벽의 길이를 구한다.
 */
public class BG_5547_일루미네이션 {
    static int W, H;
    static int[][] map;

    // 아래, 위, 오른쪽, 왼쪽
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] evenDir = {{-1, -1}, {1, -1}}; // 왼쪽 위, 왼쪽 아래
    static int[][] oddDir = {{-1, 1}, {1, 1}}; // 오른쪽 위, 오른쪽 아래

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken()); // 넓이
        H = Integer.parseInt(st.nextToken()); // 높이

        map = new int[H + 1][W + 1];
        for (int i = 1; i <= H; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 1; j <= W; j++) {
                map[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        // 모두 벽으로 둘러싸인곳은 1로 만들어줌
        makeBuilding();

        int wall = 0;
        for(int i = 1; i <= H; i++) {
            for(int j = 1; j <= W; j++) {
                if(map[i][j] == 0) continue; // 건물이 아니라면 pass

                for(int d = 0; d < dir.length; d++) {
                    int nx = i + dir[d][0];
                    int ny = j + dir[d][1];

                    // 인덱스를 벗어나거나 빌딩이 아닌 구간이라면
                    if(nx < 1 || ny < 1 || nx > H || ny > W || (map[nx][ny] == 0)) wall++;
                }

                // 홀수는 왼쪽 위아래는 신경안써
                // 짝수는 오른쪽 위아래는 신경안써
                if(i % 2 ==0 ) { // 짝수라면
                    for(int e = 0; e < evenDir.length; e++) {
                        int nx = i + evenDir[e][0];
                        int ny = j + evenDir[e][1];

                        // 인덱스를 벗어나거나 빌딩이 아닌 구간이라면
                        if(nx < 1 || ny < 1 || nx > H || ny > W || (map[nx][ny] == 0)) wall++;
                    }
                }else{
                    for(int o = 0; o < oddDir.length; o++) {
                        int nx = i + oddDir[o][0];
                        int ny = j + oddDir[o][1];

                        // 인덱스를 벗어나거나 빌딩이 아닌 구간이라면
                        if(nx < 1 || ny < 1 || nx > H || ny > W || (map[nx][ny] == 0)) wall++;
                    }
                }
            }
        }

        System.out.println(wall);
    }

    private static void makeBuilding() {
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                int surroundCnt = 0;
                for (int d = 0; d < dir.length; d++) {
                    int nx = i + dir[d][0];
                    int ny = j + dir[d][1];

                    if(nx < 1 || ny < 1 || nx > H || ny > W) continue;
                    if(map[nx][ny] == 0) continue;
                    surroundCnt++;
                }

                if(surroundCnt == 4) {
                    if(i % 2 == 0) { // 짝수일 때
                        for(int e = 0; e < evenDir.length; e++) {
                            int nx = i + evenDir[e][0];
                            int ny = j + evenDir[e][1];

                            if(nx < 1 || ny < 1 || nx > H || ny > W) continue;
                            if(map[nx][ny] == 0) continue;
                            surroundCnt++;
                        }
                    }else{
                        for(int e = 0; e < oddDir.length; e++) {
                            int nx = i + oddDir[e][0];
                            int ny = j + oddDir[e][1];

                            if(nx < 1 || ny < 1 || nx > H || ny > W) continue;
                            if(map[nx][ny] == 0) continue;
                            surroundCnt++;
                        }
                    }
                }

                if(surroundCnt == 6) {
                    map[i][j] = 1;
                }
            }
        }
    }
}

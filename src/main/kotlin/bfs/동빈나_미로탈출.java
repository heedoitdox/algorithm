package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 동빈나_미로탈출 {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우
    static int n;
    static int m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        System.out.println(bfs(0));
    }

    private static int bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index); // 처음은 무조건 1

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curX = cur / m;
            int curY = cur % m;

            for (int k = 0; k < 4; k++) {
                int x = cur / m + dir[k][0];
                int y = cur % m + dir[k][1];

                if (0 <= x && x < n && 0 <= y && y < m) { // 인덱스 범위에 들어올 때
                    if(map[x][y] == 1 && !(x==0 && y==0)) { // 방문이 처음이라면
                        map[x][y] = map[curX][curY] + 1;
                        queue.offer(x * m + y);
                    }
                }
            }
        }

        return map[n-1][m-1];
    }
}

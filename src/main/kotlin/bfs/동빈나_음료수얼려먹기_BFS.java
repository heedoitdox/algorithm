package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * queue BFS 이용
 *
 * 일차원 인덱스: k = x * m + y
 * 행: x = k / m
 * 열: y = k % m
 *
 * ex-1.
 * 4 5
 * 00110
 * 00011
 * 11111
 * 00000
 *
 * ex-2.
 * 15 14
 * 00000111100000
 * 11111101111110
 * 11011101101110
 * 11011101100000
 * 11011111111111
 * 11011111111100
 * 11000000011111
 * 01111111111111
 * 00000000011111
 * 01111111111000
 * 00011111111000
 * 00000001111000
 * 11111111110011
 * 11100011111111
 * 11100011111111
 */
public class 동빈나_음료수얼려먹기_BFS {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우

    public static void main(String[] args) throws IOException {
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        int cnt = 0;
        for(int i = 0; i < m*m; i++) {
            if(arr[i/m][i%m] == 0) {
                queue.offer(i);
                arr[i/m][i%m] = 1;
                while(!queue.isEmpty()) {
                    int index = queue.poll();

                    for(int j = 0; j < dir.length; j++) {
                        int x = index / m + dir[j][0];
                        int y = index % m + dir[j][1];
                        if(0 <= x && x < n && 0 <= y && y < m && arr[x][y] == 0) {
                            arr[x][y] = 1;
                            queue.offer(x * m + y);
                        }
                    }
                }
                cnt++;
            }
        }

        System.out.println(cnt);

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);
    }
}

package 기말고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 17276 배열돌리기
 * https://www.acmicpc.net/problem/17276
 *
 * 참고: https://haerang94.tistory.com/389
 *
 */
public class BG_17276_배열돌리기 {
    static int n, t, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(st.nextToken()); // 배열의 크기, 1 <= n <= 500
            d = Integer.parseInt(st.nextToken()); // 각도, 0 <= d <= 360, d 는 45의 배, 양수라면 시계방향, 음수라면 반시계방향

            // 배열 입력
            int[][] arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                String[] s = br.readLine().split(" ");
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(s[k]);
                }
            }

//            // 회전
//            // 가운데 (n/2, n/2) 점부터 제일 가까운 위치부터 바꾼다
//            // 대각선에 포함되는 원소인걸 어떻게 알지?
//            // 대각선에 포함되는 원소만 반복문을 돌리고 싶다.
//            int a = n/2-1, b = n/2-1; // 인덱스의 시작은 가장 중심에서부터 왼쪽에서 첫번째
//            for(int j = 1; j < n/2; j++) { // 옮길 수 있는 범위는 j 만큼만 허용
//                    int temp = arr[a-1][b]
//                }
//            }

            int[][] copy = copiedMap(arr);
            if (d > 0) {//시계 방향
                rotateR(copy);//시계 반시계 방향 결정해야함
            } else {
                rotateL(copy);
            }
        }
    }

    private static void rotateL ( int[][] map){
        int[][] copy = copiedMap(map);

        for (int cnt = 0; cnt < Math.abs(d) / 45; cnt++) {
            for (int i = 0; i < n; i++) {
                copy[(n + 1) / 2 - 1][i] = map[i][i];
            }

            for (int i = 0; i < n; i++) {
                copy[i][i] = map[i][(n + 1) / 2 - 1];
            }

            for (int i = 0; i < n; i++) {
                copy[i][(n + 1) / 2 - 1] = map[i][n - 1 - i];
            }
            for (int i = 0; i < n; i++) {
                copy[n - 1 - i][i] = map[(n + 1) / 2 - 1][i];
            }
            map = copiedMap(copy);
        }

        print(copy);

    }

    private static void rotateR ( int[][] map){
        int[][] copy = copiedMap(map);

        for (int cnt = 0; cnt < Math.abs(d) / 45; cnt++) {
            for (int i = 0; i < n; i++) {
                copy[i][(n + 1) / 2 - 1] = map[i][i];
            }

            for (int i = 0; i < n; i++) {
                copy[i][n - 1 - i] = map[i][(n + 1) / 2 - 1];
            }

            for (int i = 0; i < n; i++) {
                copy[(n + 1) / 2 - 1][n - 1 - i] = map[i][n - 1 - i];
            }
            for (int i = 0; i < n; i++) {
                copy[i][i] = map[(n + 1) / 2 - 1][i];
            }
            map = copiedMap(copy);

        }

        print(copy);
    }

    private static void print ( int[][] map){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static int[][] copiedMap ( int[][] map){
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }
}

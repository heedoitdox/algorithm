package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 이동할 수 있는 8가지 방향을 미리 정의
 */
public class 동빈나_왕실의나이트_개선 {
    static int[][] dir = {{-2, 1}, {-2, -1}, {2, 1}, {2, -1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int answer = 0;

        int row = input.charAt(1) - '1';
        int col = input.charAt(0) - 'a';

        for (int i = 0; i < 8; i++) {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];

            if (nr < 0 || nr > 7 || nc < 0 || nc > 7) continue;
            answer++;
        }

        System.out.println(answer);
    }
}

package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 8x8 좌표평면에서 나이트의 위치가 주어졌을 때 나이트가 이동할 수 있는 경우의 수를 출력
 * 나이트의 이동 가능 경로
 * 1. 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
 * 2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기
 */
public class 동빈나_왕실의나이트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");

        int row = str[0].charAt(0) - 97;
        int col = Integer.parseInt(str[1]) - 1;

        int cnt = 0;
        // 오른쪽으로 이동
        if(row+2 < 8) {
            if(col+1 < 8) cnt++;
            if(col-1 >= 0) cnt++;
        }

        // 아래로 이동
        if(col+2 < 8) {
            if(row+1 < 8) cnt++;
            if(row-1 >= 0) cnt++;
        }

        // 왼쪽으로 이동
        if(row-2 >= 0) {
            if(col+1 < 8) cnt++;
            if(col-1 >= 0) cnt++;
        }

        // 위로 이동
        if(col-1 >=0) {
            if(row+1 < 8) cnt++;
            if(row-1 >= 0) cnt++;
        }

        System.out.println(cnt);
    }
}

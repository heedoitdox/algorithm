package 완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 19532 수학은비대면강의입니다
 */
public class BG_19532_수학은비대면강의입니다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        // 시간복잡도 O(1996001) = O(n제곱)
        for(int x = -999; x <= 999; x++) {
            for(int y = -999; y <= 999; y++) {
                if(a*x + b*y == c && d*x + e*y == f) {
                    sb.append(x).append(" ").append(y);
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}

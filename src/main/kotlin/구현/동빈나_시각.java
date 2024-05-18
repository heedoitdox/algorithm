package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 00시 00분 00초 부터 N시 59분 59초 까지의 모든 시각 중 3이 포함되는 시간의 개수
 */
public class 동빈나_시각 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 60; j++) {
                for(int k = 0; k < 60; k++) {
                    String s = String.format("%d%d%d", i, j, k);
                    if(s.contains("3")) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}

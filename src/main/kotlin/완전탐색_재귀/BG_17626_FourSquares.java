package 완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 17626 Four Squares
 *
 * 주어진 자연수 n 이 주어질 때 n 을 최소 개수의 제곱수 합으로 표현할 수 있는
 */
public class BG_17626_FourSquares {
    static int[] dp;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        solve(n);

        System.out.println(dp[n]);
    }

    static void solve(int n) {
        for(int i = 2; i <= n; i++) {
            min = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++) { // i 보다 작은 제곱수 까지만
                min = Math.min(min, dp[i-j*j]);
            }
            dp[i] = min + 1; // 1 은 dp[j*j] 와 같음.
        }
    }
}

package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1463 1로 만들기
 * https://www.acmicpc.net/problem/1463
 */
public class BG_1463_1로만들기 {
    static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        System.out.println(solve(n));
    }

    static int solve(int n) {
        if(n==1) return dp[1];
        if(n==2) return dp[2];
        if(n==3) return dp[3];

        if(dp[n] != 0) return dp[n];

        if(n % 3 == 0 && n % 2 == 0) { // 6, 12, ...
            int min = Math.min(solve(n / 3), solve(n / 2));
            min = Math.min(min, solve(n - 1));
            dp[n] = min+1;
            return dp[n];
        }

        if(n % 3 == 0) {
            int min = Math.min(solve(n / 3), solve(n - 1));
            dp[n] = min+1;
            return dp[n];
        }

        if(n % 2 == 0) {
            int min = Math.min(solve(n / 2), solve(n - 1));
            dp[n] = min+1;
            return dp[n];
        }

        dp[n] = solve(n-1) + 1;
        return dp[n];
    }
}

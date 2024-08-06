package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 11727 2xN 타일링 2
 * https://www.acmicpc.net/problem/11727
 */
public class BG_11727_2xN타일링2 {
    static long[] dp = new long[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        System.out.println(solve(n));
    }

    static long solve(int n) {
        if(n==1) return dp[1];
        if(n==2) return dp[2];
        if(n==3) return dp[3];

        if(dp[n] == 0) {
            dp[n] = (solve(n-1) + solve(n-2) * 2) % 10007;
            return dp[n];
        }
        return dp[n];
    }
}

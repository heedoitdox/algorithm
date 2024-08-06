package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2839 설탕배달
 * https://www.acmicpc.net/problem/2839
 */
public class BG_2839_설탕배달 {
    static int[] dp = new int[5001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        dp[4] = -1;
        dp[5] = 1;

        System.out.println(solve(n));
    }

    static int solve(int n) {
        if(n==1) return dp[1];
        if(n==2) return dp[2];
        if(n==3) return dp[3];
        if(n==4) return dp[4];
        if(n==5) return dp[5];

        if(dp[n] == 0) {
            int n1 = solve(n-3);
            int n2 = solve(n-5);

            if(n1 == -1 && n2 == -1) dp[n] = -1;
            else {
                if(n1 != -1 && n2 != -1) {
                    int min = Math.min(n1, n2);
                    dp[n] = min + 1;
                }else {
                    if(n1 != -1) dp[n] = n1 + 1;
                    else dp[n] = n2 + 1;
                }
            }

            return dp[n];
        }

        return dp[n];
    }
}

package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 9095 1,2,3 더하기
 */
public class BG_123더하기 {
    static int[] dp = new int[12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(cal(n));
        }
    }

    static int cal(int n){
        if(n==0) return dp[0] = 0;
        if(n==1) return dp[1] = 1;
        if(n==2) return dp[2] = 2;
        if(n==3) return dp[3] = 4;

        return dp[n] = cal(n-3) + cal(n-2) + cal(n-1);
    }
}

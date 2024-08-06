package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BG_1010_다리놓기 {
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            sb.append(combi(n2, n1)).append("\n");
        }
        System.out.println(sb);
    }

    static int combi(int n, int r) {
        if(dp[n][r] > 0) return dp[n][r];

        if(n==r || r==0) return dp[n][r] = 1;

        return dp[n][r] = combi(n-1, r-1) + combi(n+1, r);
    }
}

package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 유클리드 호제법 이해하기: https://velog.io/@yerin4847/W1-%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C-%ED%98%B8%EC%A0%9C%EB%B2%95
 * - GCB(A,0) = A, GCB(0,B) = B
 * - A = B * Q + R 이라고 하면 GCB(A,B) = GCD(B,R) 이므로 GCD(B,R) 을 찾는다.
 */
public class BG_2609_최대공약수와최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        int gcd = euc(n1, n2);
        StringBuilder sb = new StringBuilder();
        sb.append(gcd).append("\n");
        sb.append(n1*n2 / gcd);
        System.out.println(sb);
    }

    private static int euc(int a, int b) {
        if(a%b == 0) {
            return b;
        }

        return euc(b, a%b);
    }
}

package 기초수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2609
// 최대공약수와 최소공배수
public class BG_2609_최대공약수와최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n1 = Integer.parseInt(str[0]);
        int n2 = Integer.parseInt(str[1]);

        int gcd = 0;
        if(n1 > n2) {
            gcd = euclidean(n1, n2);
        }else {
            gcd = euclidean(n2, n1);
        }

        System.out.println(gcd);
        System.out.println(n1*n2 / gcd);
    }

    /**
     * 유클리드 호제법
     * 1. a 를 b 로 나누고 나머지를 r 이라고 한다.
     * 2. r 이 0 이 아니라면 b 를 r 로 나눈다. 이를 반복한다.
     * 3. r 이 0 이 되면, 그때의 b 가 최대공약수가 된다.
     *
     * @param a
     * @param b
     * @return
     */
    private static int euclidean(int a, int b) {
        if(a%b == 0) {
            return b;
        }
        return euclidean(b, a%b);
    }
}

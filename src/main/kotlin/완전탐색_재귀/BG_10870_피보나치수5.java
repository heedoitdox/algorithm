package 완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 10870 피보나치수
 * https://www.acmicpc.net/problem/10870
 *
 * 피보나치 수열 공식
 * f(n) = f(n-1) + f(n-2) (n>=2)
 *
 * n 이 주어졌을 때 연속적으로 동일한 행위를 반복해야하기 때문에 재귀를 이용해서 푼다.
 */
public class BG_10870_피보나치수5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fibo(n));
    }

    static int fibo(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        return fibo(n - 1) + fibo(n - 2);
    }
}

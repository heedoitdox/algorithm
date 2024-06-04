package 완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2961 도영이가 만든 맛있는 음식
 * https://www.acmicpc.net/problem/2961
 *
 * 요리의 신맛과 쓴맛의 차이를 작게 만들어야하고 재료는 적어도 하나 사용해야한다.
 * 신맛: 사용한 재료의 신맛의 곱
 * 쓴맛: 사용한 재료의 쓴맛의 합
 */
public class BG_2961_도영이가만든맛있는음식 {
    static int N;
    static int[] S;
    static int[] B;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new int[N]; // 신 맛
        B = new int[N]; // 쓴 맛

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, 0, 1, 0);
        System.out.println(answer);
    }

    static void solve(int cnt, int level, int s, int b) {
        if(level == N) {
            if(cnt != 0) answer = Math.min(answer, Math.abs(s-b));
            return;
        }

        solve(cnt, level + 1, s, b); // 다음 재료를 넣지 않음
        solve(cnt+1, level + 1, s*S[level], b+B[level]); // 다음 재료를 넣음
    }
}

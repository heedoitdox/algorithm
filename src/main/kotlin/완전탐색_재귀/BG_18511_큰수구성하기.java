package 완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 18511 큰 수 구성하기
 *
 * 주어진 원소의 집합으로 각 원소의 사용 횟수와 상관없이 N 보다 작고 제일 큰수를 출력
 *
 */
public class BG_18511_큰수구성하기 {
    static int n, k, ans;
    static int[] kArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        kArr = new int[k];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            kArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(kArr);
        dfs(0);
        System.out.println(ans);

    }

    public static void dfs(int num) {
        if(num >  n) return;

        if(ans < num) ans = num;

        // 왜 뒤에부터 하는거지?
        for (int i = k - 1; i >= 0; i--) {
            // *10 을 함으로써 자리수를 앞으로 밈
            // ex. 15 -> 150 + 7
            dfs(num * 10 + kArr[i]);
        }
    }
}

package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 백준 11047 동전0
 * https://www.acmicpc.net/problem/11047
 * 참고: https://st-lab.tistory.com/143
 *
 * 필요한 동전 개수의 최솟값 -> 그리디 유추 가능
 * 큰 값부터 비교해야함
 * 시간복잡도는 동전의 총 종류에만 영향을 받음
 */
public class BG_11047_동전0 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];

        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        // 큰수 부터 채워넣으려고 반대로 반복문
        for (int i = N - 1; i >= 0; i--) {
            // 현재 동전의 가치가 K보다 작거나 같아야지 구성가능하다.
            if (coin[i] <= K) {
                // 현재 가치의 동전으로 구성할 수 있는 개수를 더해준다.
                count += (K / coin[i]);
                K = K % coin[i];
            }
        }
        System.out.println(count);
    }

}
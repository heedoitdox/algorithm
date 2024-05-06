package 중간고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2960 에라토스테네스의체
 * https://www.acmicpc.net/problem/2960
 *
 * 1. 2부터 N까지 모든 정수를 적는다.
 * 2. 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고 이 수는 소수이다.
 * 3. P를 지우고 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
 * 4. 아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
 */
public class BG_2960_에라토스테네스의체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        // 8 까지의 수가 있다면 0
        boolean[] number = new boolean[N + 1];
        number[0] = true;
        number[1] = true;

        int cnt = 0;
        int result = 0;

        // 2부터 N 까지 모든 정수를 적는다.
        for(int i = 2; i <= N; i++) {
            // 가장 작은 수 P
            for(int k = 2; k < number.length; k++) {
                if(!number[k]) { // 가장 처음으로 지워지지 않은 수 라면
                    for(int j = k; j <= N; j += k) { // 그의 배수를 지운다. (= true 로 만든다)
                        if(!number[j]) {
                            number[j] = true;
                            cnt++; // 지울 때마다 카운트를 기록한다.
                            if(cnt == K) {
                                result = j;
                                break;
                            }
                        }
                    }
                }
            }

            if(result != 0) break;
        }

        System.out.println(result);
    }
}

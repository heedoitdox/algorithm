package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제설명:
 * - 어떠한 수 N 이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고한다.
 * 1. N 에서 1을 뺀다
 * 2. N 을 K 로 나눈다.
 */
public class 동빈나_1이될때까지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt = 0;
        while(n > 1) {
            while(n % k != 0) { // 반복문을 사용하지 않고 한번에 빼는 방식을 사용해도 된다.
                if(n == 1) break;
                n -= 1; // 배수가 될때까지 -1 을 한다.
                cnt++;
            }

            if(n != 1) {
                n/=k;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

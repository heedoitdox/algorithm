package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11720
 *
 * 참고:
 * https://st-lab.tistory.com/61
 */
public class BG_11720_숫자의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), "");
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += Integer.parseInt(st.nextToken());
        }

        System.out.println(sum);

        // Arrays.stream(str).mapToInt(Integer::parseInt).sum()
    }
}

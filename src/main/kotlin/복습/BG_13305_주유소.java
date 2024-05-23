package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13305
 *
 * 제일 왼쪽에서 오른쪽 도시로 이동하는 최소의 비용을 계산 (그리디)
 * 기름값이 적은 도시에서 가장 많이 주유할 수록 최소의 비용이 되기때문에
 * 계속해서 도시들의 기름값을 비교해나가면서 기름값을 더해나간다.
 */
public class BG_13305_주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] dis = new long[n-1];
        for(int i = 0; i < n-1; i++) {
            dis[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long[] amount = new long[n];
        for(int i = 0; i < n; i++) {
            amount[i] = Long.parseLong(st.nextToken());
        }

        // 마지막 도시의 기름값은 알 필요 없음
        long min = amount[0]; // 맨 처음 도시의 기름값으로 시작
        long sum = min * dis[0];
        for(int i = 1; i < n-1; i++) {
            if(min > amount[i]) min = amount[i];
            sum += min * dis[i];
        }

        System.out.println(sum);
    }
}

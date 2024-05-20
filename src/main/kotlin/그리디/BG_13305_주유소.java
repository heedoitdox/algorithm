package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * (복습필요)
 * 백준 13305 주유소
 * https://www.acmicpc.net/problem/13305
 *
 * - 리터당 가격이 싼 기름을 넣는다.
 * - 제일 왼쪽 도시부터 제일 오른쪽 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수이다. 리터당 가격은 1 이상 1,000,000,000 이하의 자연수이다.
 * - 위 요구사항으로 인해 배열은 long 타입으로 선언
 */
public class BG_13305_주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dist = new long[n - 1]; // 거리
        long[] cost = new long[n]; // 리터당 주유 비용

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 거리 입력
        for(int i = 0; i < n-1; i ++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        // 리터당 기름 값 입력
        for(int i = 0; i < n; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long minCost = cost[0];
        for(int i = 0; i < n-1; i++) {
            if(cost[i] < minCost) {
                minCost = cost[i];
            }
            sum += (minCost * dist[i]);
        }

        System.out.println(sum);
    }
}

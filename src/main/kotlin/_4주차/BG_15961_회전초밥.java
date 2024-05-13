package _4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 15961 회전초밥 (2531 보다 범위가 큼)
 * https://www.acmicpc.net/problem/15961
 */
public class BG_15961_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] visit = new int[d+1];
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int total = 0, max = 0;
        for(int i = 0; i < k; i++) { // 고정된 값만큼 반복문
            if(visit[arr[i]] == 0) total++; // 방문한 적이 없는 수라면 total 값을 올린다. = 먹은 초밥의 종류라면
            visit[arr[i]]++; // 그 뒤는 방문했으니 방문수를 올림
        }

        max = total;

        for(int i = 1; i < N; i++) {
            if (max <= total) { //
                if(visit[c] == 0) max = total + 1; // 주어진 쿠폰의 초밥이 한번도 먹은 적 없는 초밥이라면
                else max = total; // 이미 포함된 경우
            }

            visit[arr[i-1]]--;
            if(visit[arr[i-1]] == 0) total--;

            if(visit[arr[(i + k -1) % N]] == 0) total++;
            visit[arr[(i + k - 1) % N]]++;
        }

        System.out.println(max);
    }
}

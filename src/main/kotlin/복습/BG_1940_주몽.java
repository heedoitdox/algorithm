package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 고유한 번호들을 정렬하고
 * 2. 투포인터를 사용해서 M 과 일치하는 경우의 수가 몇가지 인지 카운팅
 *
 * 인덱스를 좀더 주의깊게보고 while break 하는 포인트도 주의깊게 봐야함
 */
public class BG_1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 재료 개수
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 오름차순으로 정렬

        int i = 0;
        int j = n-1;
        int cnt = 0;
        while(i < j) {
            int sum = arr[i] + arr[j];
            if(sum < m) i++; // 두 포인터의 원소의 합이 m 보다 작다면 작은쪽을 증가
            else if(sum > m) j--; // 크다면 큰쪽을 감소
            else {
                i++;
                j--;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

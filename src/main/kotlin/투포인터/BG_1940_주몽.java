package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1940 주몽
 * https://www.acmicpc.net/problem/1940
 */
public class BG_1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순으로 정렬
        Arrays.sort(array);

        int i = 0;
        int j = n-1;
        int result = 0;
        while(true) {
            if(i == j || j < i) break;

            int sum = array[i] + array[j];
            if(sum == m) {
                result++;
                i++;
                j--;
            } else if(sum > m) {
                j--;
            } else if(sum < m) {
                i++;
            }
        }

        System.out.println(result);
    }
}

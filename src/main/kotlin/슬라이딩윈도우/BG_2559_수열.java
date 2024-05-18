package 슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 백준 2559 수열
 * https://www.acmicpc.net/problem/2559
 *
 * - 슬라이딩 윈도우 알고리즘
 */
public class BG_2559_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < K; i++) {
            list.add(arr[i]);
        }
        int sum = list.stream().reduce(0, Integer::sum);

        int temp = sum;
        for(int i = K; i < N; i++) {
            temp -= arr[i-K]; // 어제의 온도를 빼고
            temp += arr[i]; // 오늘의 온도를 더함
            sum = Math.max(temp, sum);
        }

        System.out.println(sum);
    }
}

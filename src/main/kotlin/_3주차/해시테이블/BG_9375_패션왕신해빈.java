package _3주차.해시테이블;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * 백준 9375 패션왕 신해빈
 * https://www.acmicpc.net/problem/9375
 *
 * - 의상의 가짓수의 범위 0 <= n <= 30
 */
public class BG_9375_패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            int n = Integer.parseInt(br.readLine());
            Hashtable<String, Integer> table = new Hashtable<>();

            for(int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                table.put(input[1], table.getOrDefault(input[1], 0) + 1);
            }

            int result = 1;
            Collection<Integer> values = table.values();

            for(Integer value: values) {
                result *= (value + 1);
            }
            sb.append(result-1).append("\n");
        }

        System.out.println(sb);
    }
}

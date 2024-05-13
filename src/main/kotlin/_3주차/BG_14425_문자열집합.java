package _3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 백준 14425 문자열집합
 * https://www.acmicpc.net/problem/14425
 */
public class BG_14425_문자열집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        HashMap<String, Integer> map = new HashMap<>();
        while(n-->0) {
            String input = br.readLine();
            map.put(input, 0);
        }

        int result = 0;
        while(m-->0) {
            String input = br.readLine();
            if(map.containsKey(input)) result++;
        }

        System.out.println(result);
    }
}

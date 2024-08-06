package 정규표현식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 9342 염색체
 * https://www.acmicpc.net/problem/9342
 */
public class BG_9342_염색체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String str = "[A-F]?A+F+C+[A-F]?$";

        StringBuilder sb = new StringBuilder();
        while(T --> 0) {
            sb.append(br.readLine().matches(str) ? "Infected!" : "Good").append("\n");
        }
        System.out.print(sb);
    }
}

package 완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 4779 칸토어집합
 *
 * 1. '-' 문자가 3 의 n 승의 문자열로 시작한다.
 * 2. 문자열을 3등분 한 뒤, 가운데 문자열을 공백으로 바꾼다.
 * 3. 남은 선을 각 3등분 하고 가운데 문자열을 공백으로 바꾼다.
 * 4. 모든 선의 길이가 1일 때 까지 계속한다.
 */
public class BG_4779_칸토어집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String s;
        while((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            String input = "-".repeat((int) Math.pow(3, n)); // - 문자를 3의 n승 만큼 반복함
            sb.append(cantorSet(input)).append("\n");
        }

        System.out.println(sb);
    }

    static String cantorSet(String s) {
        // - 하나의 문자만 남았을 때 리턴
        if(s.length() == 1) return s; // 남은 선의 길이가 1이면 멈춘다 -> 반복하면 모든 선의 길이가 1이 됨
        int section = s.length() / 3; // 항상 3으로 나누어떨어짐

        // 문자열을 새로 만든다
        String side = "-".repeat(section); // 양 사이드에 더하기 위해
        String middle = " ".repeat(section); // 가운데 문자열을 공백으로 바꾼다

        return cantorSet(side) + middle + cantorSet(side);
    }
}

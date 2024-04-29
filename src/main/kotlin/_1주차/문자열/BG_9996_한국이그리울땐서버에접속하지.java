package _1주차.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/9996
// 9996번 - 한국이 그리울 땐 서버에 접속하지
public class BG_9996_한국이그리울땐서버에접속하지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        var n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String[] patternArray = pattern.split("\\*");

        for(int i = 0; i< n; i ++) {
            String input = br.readLine();
            if(input.startsWith(patternArray[0]) && input.endsWith(patternArray[1]) && input.length() >= pattern.length()-1) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}

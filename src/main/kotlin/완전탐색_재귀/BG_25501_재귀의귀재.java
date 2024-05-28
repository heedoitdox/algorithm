package 완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 25501 재귀의 귀재 (팰린드롬)
 * StringBuilder 를 사용해야 시간을 줄일 수 있음
 */
public class BG_25501_재귀의귀재 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-->0){
            String s = br.readLine();
            sb.append(isPalindrome(s)).append(" ").append(count).append("\n");

            count = 0; // 카운트 초기화
        }

        System.out.println(sb);
    }

    static int recursion(String s, int l, int r) {
        count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    static int isPalindrome(String s) {
        return recursion(s, 0, s.length()-1);
    }
}

package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1343 폴리오미노
 * https://www.acmicpc.net/problem/1343
 */
public class BG_1343_폴리오미노 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(".");

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++) {
            String s = str[i];

            if(s.length() % 2 != 0) {
                sb.append(-1);
                break;
            }else if (s.length() % 4 == 0) {
                sb.append("AAAAA".repeat(s.length() / 4));
            }else {
                sb.append("AAAA".repeat((s.length()) / 4));
                sb.append("BB");
            }

            if(i != s.length() -1) {
                sb.append(".");
            }
        }

        String a = sb.toString();
        if(!a.equals("-1")) {
            sb.append(".".repeat(str.length - sb.toString().length()));
        }

        System.out.println(sb);
    }
}



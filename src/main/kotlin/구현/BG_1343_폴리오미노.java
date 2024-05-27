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
        // . 을 기준으로 문자열들을 분리
        String[] str = br.readLine().split("\\.");

        StringBuilder sb = new StringBuilder();

        // 분리한 문자열 배열을 반복문
        for(int i = 0; i < str.length; i++) {
            String s = str[i];

            if(s.length() % 2 != 0) { // AAAA, BB 가 들어갈 수 있는 문자열인지 체크 (두개의 폴리오미노는 2의 배수)
                sb.append(-1);
                break;
            }else if (s.length() % 4 == 0) { // AAAA 가 들어갈 수 있는 문자열인지 체크
                sb.append("AAAAA".repeat(s.length() / 4));
            }else { // 된다는건 2의 배수라는거니까 가장 큰 폴리오미노 부터 넣어주고 작은 폴리오미노를 추가한다. (문제에서는 사전순으로 정의)
                sb.append("AAAA".repeat((s.length()) / 4));
                sb.append("BB");
            }

            // 빈문자열이면 . 를 추가한다 (원문과 같게 하기 위함)
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



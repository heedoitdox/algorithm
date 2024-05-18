package 기초수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * 백준 2004 조합0 의 개수
 * https://www.acmicpc.net/problem/2004
 *
 * nCr = n! / r!(n-r)!
 */
public class BG_2004_조합0의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        long n = Long.parseLong(str[0]);
        long r = Long.parseLong(str[1]);

        long result = fac(n) / (fac(r) * fac(n-r));

        // 소수점 이하 자리수 없는 포맷 설정
        DecimalFormat decimalFormat = new DecimalFormat("#");
        char[] chars = decimalFormat.format(result).toCharArray();

        int cnt = 0;
        for(int i = chars.length-1; i >= 0; i--) {
            if('0' != chars[i]) break;
            cnt++;
        }

        System.out.println(cnt);
    }

    private static long fac(long a) {
        if(a == 0) return 1;
        return a * fac(a-1);
    }
}

package 기말고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335
 */
public class PG_K진수에서소수개수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 10진수를 k진수로 변환하는 법
        // 10진법으로 표기된 숫자롤 K로 나누어 그 나머지를 표시하고 더이상 나누어지지않을때까지 반복
        // 이 때 최종 String 값을 reverse() 해야함
        String KNumber = "";
        if(k != 10) {
            StringBuilder sb = new StringBuilder();
            while(n > 0) {
                int mod = n % k;
                n /= k;
                sb.append(mod);
            }
            KNumber = sb.reverse().toString();
        } else {
            KNumber = String.valueOf(n);
        }

        String[] split = KNumber.split("0");

        int cnt = 0;
        for(String s: split) {
            if(s.equals("")) continue;;
            long num = Long.parseLong(s);
            if(isPrime(num)) cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean isPrime(long n){
        if(n<2) return false;
        for(int i = 2; i <= Math.sqrt(n); i++)
            if(n % i == 0)
                return false;
        return true;
    }
}

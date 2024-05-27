package 기초수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BG_1929_소수구하기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        StringBuilder sb = new StringBuilder();
        boolean[] prime = new boolean[b + 1];

        for(int i = 2; i <= b; i++) {
            if(prime[i]) continue;

            if(i >= a) sb.append(i).append('\n');

            for(int j = i + i; j <= b; j += i) { // 수의 배수들을 다 소수가 아닌 수로 만든다.
                prime[j] = true;
            }
        }

        System.out.println(sb);
    }
}

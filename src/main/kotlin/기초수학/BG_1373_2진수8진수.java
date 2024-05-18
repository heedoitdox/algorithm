package 기초수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1373
// 2진수 8진수
public class BG_1373_2진수8진수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String binary = br.readLine();
        int n = binary.length();

        if(n % 3 ==1) {
            System.out.print(binary.charAt(0));
        } else if(n % 3 == 2) {
            System.out.print((binary.charAt(0) - '0') * 2 + (binary.charAt(1) - '0'));
        }

        for(int i = n % 3; i < n; i += 3) {
            System.out.print((binary.charAt(i) - '0') * 4
                + (binary.charAt(i+1) - '0') * 2
                + (binary.charAt(i + 2) - '0'));
        }
    }
}

package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 9655 돌게임
 * https://www.acmicpc.net/problem/9655
 */
public class BG_9655_돌게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n%2 == 0) System.out.println("CY");
        else System.out.println("SK");
    }
}

package 완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2231 분해합
 * 시간: 324ms
 */
public class BG_2231_분해합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int min = n; // 가장 작은수를 구하기 위한 변수, n 이 가장 큰수일테니 n으로 초기화한다.
        boolean flag = false; // 분해합이 하나라도 없을 경우 플래그
        for(int i = 1; i < n; i++){ // 1부터 하나씩 빼면서 분해합을 구한다.
            String s = String.valueOf(n - i); // 각 자리수를 반복문으로 돌리기 위해 문자열로 변환
            int sum = n-i;

            for(int j = 0; j < s.length(); j++){ // 각 자리수의 합을 구한다.
                sum += s.charAt(j) - 48;
            }

            // stream API 를 써서 sum 을 구할 경우 훨씬 느리다. 692ms
//            sum += s.chars()             // 문자열의 각 문자를 IntStream으로 변환
//                    .map(Character::getNumericValue) // 각 문자를 숫자로 변환
//                    .sum();

            if(sum == n) {
                min = Math.min(min, n-i);
                flag = true;
            }
        }

        if(!flag) System.out.println(0);
        else System.out.println(min);
    }
}
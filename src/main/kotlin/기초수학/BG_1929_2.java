package 기초수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BG_1929_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받은 문자열을 정수로 바꿔주기 위함
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        int[] arr = new int[b + 1];
        StringBuilder sb = new StringBuilder();

        // 0과 1은 소수 아님
        arr[0] = -1;
        arr[1] = -1;

        // 제곱해서 b 를 넘지 않을 때까지 반복문
        for(int i = 2; i * i <= b; i++) {
            // 소수라면
            if(arr[i] != -1) {
                // 소수의 배수들의 반복문
                for(int j = i * i; j <= b; j += i) {
                    //소수의 배수들에는 -1
                    arr[j] = -1;
                }
            }
        }

        // 반복문으로 0이 아닌 경우에만 (= 소수) StringBuilder 로 만들어줌
        for(int i = a; i <= b; i++) {
            if(arr[i] != -1) sb.append(i).append("\n");
        }

        // 정답 출력
        System.out.println(sb);
    }
}
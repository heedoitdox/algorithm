package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * (복습 필요)
 * 백준 1541 잃어버린 괄호
 * https://www.acmicpc.net/problem/1541
 *
 * 괄호를 적절히 쳐서 식의 값이 최소가 되도록 만들어야한다.
 * 입력값은 0~9 숫자와 + , - 만으로만 이루어져 있다.
 *
 * 가장 최소값이 되려면 가장 큰 수를 빼야하지 않을까?
 * 따라서 빼기 뒤에 항상 괄호가 오면 좋을 것 같다.
 * 빼기가 올때마다 괄호를 넣어주고 맨뒤에 닫힌 괄호를 추가한다 요거를 스택으로 해서 계산??
 *
 * 1. 뺄셈을 기준으로 1차적으로 문자열을 분리한다.
 * 2. 분리된 문자열들 각각에 포함 된 정수 값들을 모두 더해준다.
 * 3. 각각 더해진 값들을 뺄셈해준다.
 */
public class BG_1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.MAX_VALUE;
        StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");

        while(subtraction.hasMoreTokens()) { // 더이상 남은 토큰이 없으면 중지
            int temp = 0;

            StringTokenizer additon = new StringTokenizer(br.readLine(), "\\+");// + 의 경우 메타문자이기 때문에 해당 처리 해줘야함

            while(additon.hasMoreTokens()) {
                temp += Integer.parseInt(additon.nextToken());
            }

            if(sum == Integer.MAX_VALUE) sum = temp; // 첫번째 토큰인 경우
            else sum -= temp;
        }

        System.out.println(sum);
    }
}

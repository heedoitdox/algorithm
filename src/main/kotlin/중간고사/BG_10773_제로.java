package 중간고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 10773 제로
 * https://www.acmicpc.net/problem/10773
 *
 * 입력된 수들의 나열에서 0 이 존재하면 최근의 수를 지우고 결국 남은 수들의 합을 구한다.
 * - 가장 최근의 데이터를 꺼내기 위해 스택 사용
 * - 최종적으로 적어낸 수의 합은 2의 31승의 -1 보다 작기때문에 integer 범위로 가능하다.
 */
public class BG_10773_제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        while (K-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(n);
            }
        }

        int result = 0;
        while(true) {
            if(stack.isEmpty()) break;
            result += stack.pop();
        }

        System.out.println(result);
    }
}

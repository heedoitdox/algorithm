package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 1. 열린괄호를 리스트에 넣고 닫힌괄호가 보이면 하나씩 짝을 맞춰본다
 * 2. 따라서 선입후출이 되어야하므로 스택을 사용한다.
 */
public class BG_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            String input = br.readLine();

            Stack<Character> stack = new Stack<>();

            boolean flag = false;
            for(int j = 0; j < input.length(); j++) {
                if(input.charAt(j) == '(') {
                    stack.push(input.charAt(j));
                }else  {
                    if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                    else flag = true; // 잘못된 괄호임을 플래그에 마킹
                }

                if(flag) break;
            }

            if(flag || !stack.isEmpty()) sb.append("NO").append("\n"); // 중간에 잘못된 괄호임을 알았거나 스택에 남은 열린괄호가 있다면
            else sb.append("YES").append("\n");
        }
        System.out.println(sb);
    }
}

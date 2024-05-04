package _2주차.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/10799
 */
public class BG_10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] pipe = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        int result = 0;

        for(int i=0; i<pipe.length;i++) {
            if(pipe[i] == '(') { // 열린 괄호라면
                stack.push(pipe[i]); // 스택에 push
            }else { // 열린 괄호가 아니라면
                stack.pop(); // 스택에서 pop

                // 이전 문자가 열린 괄호였다면 레이저라는 것이므로
                // 결과값에 스택사이즈만큼을 더한다.
                if(pipe[i-1] == '(') result += stack.size();
                // 아니라면 결과값에 +1
                else result++;
            }
        }
        System.out.println(result);
    }
}

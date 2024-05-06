package 중간고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 2504 괄호의 값
 * https://www.acmicpc.net/problem/2504
 *
 * - () = 2
 * - [] = 3
 * - (()) = 2*2 = 4
 * - ([]) = 2*3 = 6
 * - ()[] = 2+3 = 5
 * - ...
 *
 * 곱해주는 때는 언제이고 더해주는 때는 언제인가?
 */
public class BG_2504_괄호의값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>(); // 괄호, 숫자 모두 넣는 스택

        char[] str = br.readLine().toCharArray();
        int result = 0;

        boolean flag = false; // 올바르지 않은 괄호문자열이라면 ture 가 된다.
        for(int i = 0; i < str.length; i++) {
            switch(str[i]) {
                case ')' :
                    if(stack.isEmpty()) { // 처음부터 닫힌 문자가 오면 올바르지않은 문자열
                        flag = true;
                        break;
                    }

                    if(str[i-1] == '(') { // 이전 문자가 열린 괄호라면
                        stack.pop();
                        stack.push("2");
                    }else{ // 아니라면 짝이 맞는 괄호가 나올 때까지 모든 수를 더하고 그 수에 2를 곱한다.
                        int n = 0;
                        while(true) {
                            if(stack.isEmpty()) {
                                flag = true;
                                break; // 스택이 비어있어도 break
                            }

                            if(stack.peek().charAt(0) == '(') break;

                            try{
                                n += Integer.parseInt(stack.pop());
                            }catch (NumberFormatException e) {
                                flag = true;
                                break;
                            }
                        }

                        if(!flag) {
                            stack.pop();
                            stack.push(String.valueOf(n*2));
                        }
                    }
                    break;
                case ']' :
                    if(stack.isEmpty()) { // 처음부터 닫힌 문자가 오면 올바르지않은 문자열
                        flag = true;
                        break;
                    }

                    if(str[i-1] == '[') { // 이전 문자가 열린 대괄호라면
                        stack.pop();
                        stack.push("3");
                    }else{ // 아니라면 짝이 맞는 괄호가 나올 때까지 모든 수를 더하고 그 수에 3을 곱한다.
                        int n = 0;
                        while(true) {
                            if(stack.isEmpty()) {
                                flag = true;
                                break; // 스택이 비어있어도 break
                            }
                            if(stack.peek().charAt(0) == '[') break;

                            try{
                                n += Integer.parseInt(stack.pop());
                            }catch (NumberFormatException e) {
                                flag = true;
                                break;
                            }
                        }

                        if(!flag) {
                            stack.pop();
                            stack.push(String.valueOf(n*3));
                        }
                    }
                    break;
                default:
                    stack.push(String.valueOf(str[i]));
            }

            if(flag) break;
        }

        if(!flag) {
            while (true) {
                if (stack.isEmpty()) break;

                try{
                    result += Integer.parseInt(stack.pop());
                }catch (NumberFormatException e) {
                    result = 0;
                    break;
                }

            }
        }

        System.out.println(result);
    }
}

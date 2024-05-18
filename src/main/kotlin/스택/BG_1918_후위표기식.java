package 스택;

import java.io.*;
import java.util.List;
import java.util.Stack;

/**
 * 백준 1918 후위표기식
 * https://www.acmicpc.net/problem/1918
 *
 * 풀이방법
 * 1. 피연산자를 만나면 그대로 출력
 * 2. 연산자를 만나면 스택 상단의 연산자와 비교
 * 2-1. 넣으려는 연산자의 우선순위가 더 크면 해당 연산자를 스택에 삽입
 * 2-2. 작거나 같으면 스택 상단의 연산자를 출력하고 다시 반복
 * 3. 왼쪽 괄호가 나오면 스택에 삽입
 * 4. 오른쪽 괄호가 나오면 스택에서 왼쪽 괄호가 나올때까지 모든 연산자 pop
 * 5. 처리할 문자가 표기식에 남아있지 않다면 스택에 남아있는 모든 연산자 pop
 */
public class BG_1918_후위표기식 {
    private static List<Character> HIGH_LEVEL_GROUP = List.of('*', '/');

    public static void main(String[] args) throws IOException {
        // +, -, *, /, (, )
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();

        char[] str = br.readLine().toCharArray();
        for (int i = 0; i < str.length; i++) {
            if(str[i] >= 65 && str[i] <= 90) { // 피연산자라면 그냥 출력한다.
                bw.write(str[i]);
            } else { // 연산자라면
                if(str[i] == '(') { // 열린 괄호라면 스택에 넣는다.
                    stack.push(str[i]);
                    continue;
                }

                if(str[i] == ')') { // 닫힌 괄호라면
                    while(true) {
                        if(stack.peek() == '(') { // 열린 괄호가 나올 떄까지 무한 반복문
                            stack.pop(); // 열린 괄호는 pop
                            break;
                        }

                        bw.write(stack.pop()); // 열린 괄호 전까지 스택에 존재하는 모든 연산자 pop
                    }
                    continue;
                }

                while(true) { // 괄호가 아닌 연산자의 경우 ('+', '-', '/', '*')
                    if(stack.isEmpty() || stack.peek() == '(') { // 스택이 비었거나 열린 괄호가 존재한다면 (빈걸로 간주)
                        stack.push(str[i]); // 무조건 스택에 push
                        break;
                    } else { // 스택이 비지 않았다면
                        if(getLevel(stack.peek()) < getLevel(str[i])) { // 스택의 peek 와 input 의 연산자 우선순위 비교
                            stack.push(str[i]); // input 의 우선순위가 더 크다면 스택에 push
                            break;
                        }else { // input 우선순위가 낮다면
                            bw.write(stack.pop()); // 스택에서 pop 하고 출력한다.
                        }
                    }
                }
            }
        }

        while(true) { // 스택이 빌 떄까지
            if(stack.isEmpty()) break;
            bw.write(stack.pop()); // 남아있는 모든 값들을 pop
        }

        // 출력
        bw.flush();
        bw.close();
    }

    public static int getLevel(char ch) {
        if(HIGH_LEVEL_GROUP.contains(ch)) return 1;
        else return 0;
    }
}

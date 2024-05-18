package 스택;

import java.io.*;
import java.util.Stack;

/**
 * 백준 5397 키로거
 * https://www.acmicpc.net/problem/5397
 *
 * 시간: 892ms
 *
 * 문제설명:
 * 주어진 테스트 케이스에서 비밀번호 원문을 알아내야한다.
 * '-' 문자가 주어지면 백스페이스를 뜻하고 (현재 커서에서 왼쪽에 위치하는 문자를 하나 지운다.)
 * '<' 또는 '>' 문자는 커서의 이동을 뜻한다.
 *
 * 문제풀이:
 * 커서의 왼쪽 오른쪽을 구분하기위해 2개의 스택을 이용한다. (왼쪽스택, 오른쪽스택)
 */
public class BG_5397_키로거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

         int n = Integer.parseInt(br.readLine());

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        while(n --> 0) {
             char[] str = br.readLine().toCharArray();
             for(int i = 0; i < str.length; i++) {
                 switch(str[i]) {
                     case '<' : // 커서가 왼쪽으로 이동할 때
                         if(!leftStack.isEmpty()) rightStack.push(leftStack.pop()); // 왼쪽 스택에 값이 존재한다면 오른쪽스택으로 옮긴다.
                         break;
                     case '>' : // 커서가 오른쪽으로 이동할 때
                         if(!rightStack.isEmpty()) leftStack.push(rightStack.pop()); // 오른쪽 스택에 값이 존재한다면 왼쪽 스택으로 옮긴다.
                         break;
                     case '-': // 커서 앞에 존재하는 문자를 지운다.
                         if(!leftStack.isEmpty()) leftStack.pop(); // 커서 앞에 존재하는 문자는 왼쪽 스택의 peek 값을 의미하므로 pop
                         break;
                     default: // 일반 문자가 왔을 때
                         leftStack.push(str[i]);
                 }
             }
            // 왼쪽 차례대로 문자를 출력하기 위해서 왼쪽 스택에 존재하는 문자를 오른쪽 스택으로 이동한다.
            while(true) {
                if(leftStack.isEmpty()) break;
                rightStack.push(leftStack.pop());
            }

            while(true) {
                if(rightStack.isEmpty()) break;
                bw.write(rightStack.pop());
            }

            bw.write("\n");
         }

        bw.flush();
        bw.close();
    }
}

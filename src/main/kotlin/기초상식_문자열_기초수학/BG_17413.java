package 기초상식_문자열_기초수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/17413
// 단어 뒤집기
public class BG_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split("");

        // 스택 생성
        Stack<String> stack = new Stack<>();
        int flag = 0;
        for(int i = 0; i < str.length; i++) {
            if(str[i].equals("<")) {
                flag = 1;
                printStack(stack);
                System.out.print(str[i]);
                continue;
            }

            if(str[i].equals(">")) {
                flag = 0;
                System.out.print(str[i]);
                continue;
            }

            if(str[i].equals(" ") && flag == 0){
                printStack(stack);
                System.out.print(str[i]);
                continue;
            }

            if(flag==1) {
                System.out.print(str[i]);
                continue;
            }

            stack.push(str[i]);
        }

        printStack(stack);
    }

    private static void printStack(Stack<String> stack) {
        int stackSize = stack.size();
        for(int j = 0; j < stackSize; j++) {
            System.out.print(stack.pop());
        }
    }
}
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
            if(pipe[i] == '(') {
                stack.push(pipe[i]);
            }else {
                stack.pop();
                if(pipe[i-1] == '(') result += stack.size();
                else result++;
            }
        }
        System.out.println(result);
    }
}

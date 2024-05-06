package 중간고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 숫자, 문자 두개의 스택을 이용해서 풀어보자
 * 스택을 두개로 사용하면 ()(()) 의 경우에 2 + 4 케이스가 어렵기 때문에 하나로 사용해야한다.
 */
public class BG_2504_괄호의값_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> chars = new Stack<>();
        Stack<Integer> numbers = new Stack<>();

        char[] str = br.readLine().toCharArray();

        boolean invalid = false;
        for(int i = 0; i<str.length; i++) {
            switch(str[i]) {
                case ')' :
                    if(chars.isEmpty()) {
                        invalid = true;
                        break;
                    }

                    if(str[i-1] == '(') {
                        numbers.push(2);
                    }else {
                        numbers.push(sum(numbers) * 2);
                    }

                    chars.pop();
                    break;
                case ']' :
                    if(chars.isEmpty()) {
                        invalid = true;
                        break;
                    }

                    if(str[i-1] == '[') {
                        numbers.push(3);
                    }else {
                        numbers.push(sum(numbers) * 3);
                    }

                    chars.pop();
                    break;
                default:
                    chars.push(str[i]); // 열린 괄호들을 push
            }

            if(invalid) break;
        }

        int result = 0;

        // 올바른 괄호 문자열일 때
        if (!invalid) {
            while (true) { // 숫자 스택에 들어있는 모든 수를 더한다.
                if (numbers.isEmpty()) break;
                result += numbers.pop();
            }
        }

        // 괄호 스택에 남아있는 문자가 있을 때는 올바른 문자열이 아니므로 0을 출력한다.
        if(!chars.isEmpty()) result = 0;

        System.out.println(result);
    }

    private static int sum(Stack<Integer> stack) {
        int sum = 0;
        while(true) {
            if(stack.isEmpty()) break;
            sum += stack.pop();
        }

        return sum;
    }
}

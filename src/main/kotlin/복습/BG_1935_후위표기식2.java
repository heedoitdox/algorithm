package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class BG_1935_후위표기식2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        HashMap<Character, Double> map = new HashMap<>();
        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if('A' <= s.charAt(i) && s.charAt(i) <= 'Z') { // 문자라면 map 에 넣는다.
                if(!map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), Double.parseDouble(br.readLine()));
                }
                stack.push(map.get(s.charAt(i)));
            } else { // 문자가 아니라면 연산자
                double n2 = stack.pop();
                double n1 = stack.pop();

                switch(s.charAt(i)) {
                    case '*':
                        stack.push(n1 * n2);
                        break;
                    case '+':
                        stack.push(n1 + n2);
                        break;
                    case '/':
                        stack.push(n1 / n2);
                        break;
                    case '-':
                        stack.push(n1 - n2);
                        break;
                    default: // nothing
                }
            }
        }

        System.out.println(String.format("%.2f", stack.pop()));
    }
}

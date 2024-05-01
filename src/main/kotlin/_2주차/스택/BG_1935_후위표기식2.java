package _2주차.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Stack;

/**
 * 백준 1935 후위표기식2
 * https://www.acmicpc.net/problem/1935
 *
 * 풀이방법
 * 1. 후위 표기식이 어떻게 계산되는지 알아야한다.
 * 2. 피연산자일 경우 차례대로 자료구조에 넣고 연산자를 만났을 경우 2개의 피연산자를 꺼내 계산을 수행한다.
 * 3. 수행한 계산은 다시 자료구조에 넣고 이를 반복한다.
 * 4. 피연산자가 3개 이상일 경우 후에 넣은 피연산자 2개를 꺼내야 하므로 스택을 이용한다.
 */
public class BG_1935_후위표기식2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<Character, BigDecimal> map = new HashMap<>();

        char[] str = br.readLine().toCharArray();
        for(int i = 0; i < str.length; i++) {
            if(str[i] >= 65 && str[i] <= 90) {
                if(!map.containsKey(str[i])) {
                    map.put(str[i], new BigDecimal(Integer.parseInt(br.readLine())));
                }
            }
        }

        Stack<BigDecimal> stack = new Stack<>();
        for(int i = 0; i < str.length; i++) {
            if(str[i] >= 65 && str[i] <= 90) { // 피연산자라면
                BigDecimal o = map.get(str[i]);
                stack.push(o); // 스택에 넣는다.
            } else { // 연산자라면 피연산자 2개를 꺼내서 계산한다.
                BigDecimal n2 = stack.pop(); // 스택에서 2개를 pop 하는데
                BigDecimal n1 = stack.pop(); // 나중에 꺼내는 수를 앞으로 계산한다.
                stack.push(calculate(n1, n2, str[i])); // 계산한 값을 다시 스택에 넣는다.
            }
        }

        System.out.println(stack.pop().setScale(2, RoundingMode.FLOOR));
    }

    private static BigDecimal calculate(BigDecimal n1, BigDecimal n2, char op) {
        if(op == 43) { // +
            return n1.add(n2);
        }else if (op == 45) { // -
            return n1.subtract(n2);
        } else if (op == 42) { // *
            return  n1.multiply(n2);
        } else if (op == 47) { // /
            return n1.divide(n2);
        } else {
            throw new IllegalStateException();
        }
    }
}

package _2주차.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * https://www.acmicpc.net/problem/9012
 * 시간: 152 ms
 */
public class BG_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> stack = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");

            // NO 를 마킹하기 위한 플래그
            boolean flag = true;
            // 문자열의 개수만큼 반복문
            for(int j = 0; j < str.length; j++) {
                if(str[j].equals(")")) {
                    // "(" 가 스택에 존재하지 않고 비어있다면 NO
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    } else {
                        if(stack.getFirst().equals("(")) {
                            stack.removeFirst();
                        }
                    }
                }else {
                    stack.addFirst(str[j]);
                }
            }

            // 남은 "(" 가 있고 앞에서 NO 판정을 받았다면 (flag = false)
            if(!stack.isEmpty() || !flag) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

            stack.clear();
        }
    }
}

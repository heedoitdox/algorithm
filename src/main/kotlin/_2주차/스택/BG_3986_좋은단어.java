package _2주차.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * https://www.acmicpc.net/problem/3986
 * 시간: 276ms
 *
 * 문제설명: A 또는 B 로 이루어진 단어에서 쌍을지어 단어위로 아치형 곡선을 그었을 때 선끼리 교차하지 않으면 좋은단어라고 한다.
 * 접근방법: 교차하지 않는 다는 것은 괄호처럼 서로 쌍을 이룬다는 것이므로 좋은단어로 판별하여 출력 카운트를 +1 한다.
 */
public class BG_3986_좋은단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Character> stack = new LinkedList<>();
        int result = 0;

        // 케이스만큼 반복문
        for(int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();

            // 문자 배열의 개수가 1개가 아닐 때 스택에 값을 넣고 반복문을 돌림.
            if(arr.length != 0) {
                stack.addFirst(arr[0]);

                for (int j = 1; j < arr.length; j++) {
                    if(!stack.isEmpty()) {
                        if(stack.getFirst() != arr[j]) {
                            stack.addFirst(arr[j]);
                        } else {
                            stack.removeFirst();
                        }
                    }else {
                        stack.addFirst(arr[j]);
                    }

                    if (j == arr.length - 1 && stack.isEmpty()) result++;
                }

                stack.clear();
            }
        }

        System.out.println(result);
    }
}

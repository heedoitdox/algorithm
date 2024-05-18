package 스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/source/13992820
 * 시간: 384ms
 *
 * - 배열로 스택을 직접 구현하면 시간을 단축할 수 있나?
 * -> 배열은 사이즈를 지정해서 구현해야하기때문에 링크드리스트 구현보다 데이터의 접근속도가 빨라 조회속도가 빠름
 * 자바에서 제공하는 스택은 데이터의 개수가 한정적이지 않기 때문에 링크드 리스트로 구현되어 있다는 것을 알 수있음
 * 따라서 조회부분에서 배열구현보다 성능이 느릴 수 있음
 * 참고: https://go-coding.tistory.com/5
 */
public class BG_5397_키로거_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        MyStack front = new MyStack(1000001);
        MyStack back = new MyStack(1000001);
        for (int testCase = 0; testCase < T; testCase++) {
            String commend = reader.readLine();
            for (int i = 0, size = commend.length(); i < size; i++) {
                switch (commend.charAt(i)) {
                    case '<':
                        back.push(front.pop());
                        break;
                    case '>':
                        front.push(back.pop());
                        break;
                    case '-':
                        front.pop();
                        break;
                    default:
                        front.push(commend.charAt(i));
                        break;
                }
            }

            System.out.print(front.toString());
            System.out.println(back.toReverseString());
            front.clear();
            back.clear();
        }

    }

    static class MyStack {
        char[] stack;
        int size;

        public MyStack(int size) {
            stack = new char[size];
            this.size = 0;
        }

        public void push(char word) {
            if (word != ' ') {
                stack[size++] = word;
            }
        }

        public char pop() {
            if (size == 0) {
                return ' ';
            } else {
                return stack[--size];
            }
        }

        public String toString() {
            return String.valueOf(stack, 0, size);
        }

        public String toReverseString() {
            char[] reverse = new char[size];
            int lastIdx = size - 1;
            for (int i = 0; i < size; i++) {
                reverse[i] = stack[lastIdx - i];
            }
            return String.valueOf(reverse);
        }

        public void clear() {
            size = 0;
        }

    }
}

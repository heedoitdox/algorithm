package _2주차.스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * 백준 1406 에디터
 * https://www.acmicpc.net/problem/1406
 *
 * 시간초과: 일반출력사용하면 시간초과
 */
public class BG_1406_에디터 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Stack<String> leftSt = new Stack<>(); // 커서의 왼쪽 스택
        Stack<String> rightSt = new Stack<>(); // 커서의 오른쪽 스택

        //처음 커서는 문장의 맨 뒤에서 시작하기 때문에 왼쪽 스택에 초기 문자를 모두 넣어줌 (ex. abc|)
        String[] arr = str.split("");
        for (String s : arr) { //Enhanced For Loop 사용
            leftSt.push(s);
        }

        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            switch (c) {
                case 'L': // 커서를 왼쪽으로 한칸 옮김
                    if (!leftSt.isEmpty())
                        rightSt.push(leftSt.pop());
                    break;
                case 'D': // 커서를 오른쪽으로 한칸 옮김
                    if (!rightSt.isEmpty())
                        leftSt.push(rightSt.pop());
                    break;
                case 'B': // 커서 왼쪽에 있는 문자를 삭제함 (오른쪽 문자는 그대로임)
                    if (!leftSt.isEmpty()) {
                        leftSt.pop();
                    }
                    break;
                case 'P': // 문자를 커서 왼쪽에 추가함
                    char t = command.charAt(2);
                    leftSt.push(String.valueOf(t));
                    break;
                default:
                    break;
            }
        }

        //Stack은 LIFO 구조이기 때문에
        //왼쪽 스택에 있는 데이터들을 모두 오른쪽으로 옮긴 뒤에 오른쪽에 있는 모든 내용을 출력한다.
        while (!leftSt.isEmpty())
            rightSt.push(leftSt.pop());

        while (!rightSt.isEmpty())
            bw.write(rightSt.pop());

        bw.flush();
        bw.close();
    }
}
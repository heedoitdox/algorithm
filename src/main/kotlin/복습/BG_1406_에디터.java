package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 커서를 기준으로 왼쪽공간, 오른쪽 공간으로 나누면 편하다
 * 그리고 커서를 기준으로 문자를 추가하는 기능도 있기 때문에 자유롭게 왼쪽,오른쪽 공간에 데이터를 추가, 제거(이동할 때) 하기 위해서 스택 자료구조를 사용한다.
 */
public class BG_1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력받는 문자열. 길이는 100,000 을 넘지 않음
        String s = br.readLine();

        // 초기세팅으로 커서는 맨뒤에 위치하고 있으므로 왼쪽 스택에 모든 문자를 넣는다.
        Stack<Character> left = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            left.push(s.charAt(i));
        }

        // 아직은 빈 오른쪽 스택 세팅
        Stack<Character> right = new Stack<>();

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "P": // 문자를 커서 왼쪽에 추가 = 왼쪽 스택에 추가
                    left.push(st.nextToken().charAt(0));
                    break;
                case "D": // 커서를 오른쪽으로 한칸 옮김. 맨뒤라면 무시됨 = 오른쪽 스택에 왼쪽 스택 문자를 push
                    if(!right.isEmpty()) left.push(right.pop());
                    break;
                case "B": // 커서 왼쪽의 문자를 삭제함 = 왼쪽 스택 문자를 pop
                    if(!left.isEmpty()) left.pop();
                    break;
                case "L": // 커서를 왼쪽으로 한칸 옮김
                    if(!left.isEmpty()) right.push(left.pop());
                default: // nothing
            }
        }

        StringBuilder sb = new StringBuilder();
        int size = left.size();
        for(int i = 0; i < size; i++) {
            sb.append(left.pop());
        }
        sb.reverse();

        size = right.size();
        for(int i = 0; i < size; i++) {
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}

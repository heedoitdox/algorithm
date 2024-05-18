package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/source/10663368
 * 시간: 68ms
 *
 * 내가 푼 답보다 시간이 2배 이상 빠르다.
 * 그 이유는 LinkedList 자료구조를 사용하지않고 배열과 cnt 변수만을 이용해서 괄호의 쌍을 비교했기 때문
 */
public class BG_9012_괄호_2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int cnt = 0, j = 0;

        // 케이스 만큼 반복문
        for(int i = 0; i < cases; i++) {
            // 문자 배열로 변환하여 변수에 할당
            char arr[] = br.readLine().toCharArray();
            // 처음부터 닫힌 괄호가 나오면 NO
            if(arr[0]==')') sb.append("NO\n");
            else {
                // 문자 배열 사이즈 만큼 반복문
                for(j = 0; j < arr.length; j++) {
                    if(arr[j] == '(') cnt ++;
                    if(arr[j] == ')') cnt --;

                    // cnt 가 음수가 되었다면 짝이 맞지 않았다는 것이므로 NO
                    if(cnt < 0) {
                        sb.append("NO\n");
                        break;
                    }
                }

                // 배열의 마지막 인덱스일 때
                if(j == arr.length) {
                    // 모든 괄호의 짝이 맞았다면 (cnt == 0) YES
                    if(cnt == 0) sb.append("YES\n");
                    else sb.append("NO\n");
                }

                cnt = 0;
            }
        }

        System.out.println(sb);
    }
}

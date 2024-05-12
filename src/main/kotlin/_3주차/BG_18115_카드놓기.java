package _3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 백준 18115 카드놓기
 * https://www.acmicpc.net/problem/18115
 *
 * 시간초과:
 * - 계속해서 원소들의 위치를 미루고 바꿔야하기 때문에 배열은 시간초과
 * - 리스트 중간삽입은 O(n) 의 시간복잡도가 소요되므로 제거&삽입의 연산이 더 효과적이다
 * 따라서 2번째 스킬사용시 맨위 원소를 제거 후 다시 삽입하는 방식을 사용해야 시간초과가 나지 않음 (Deque, LinkedList 는 구현체가 같기 때문에 동일)
 */
public class BG_18115_카드놓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> result = new LinkedList<>();
        String[] skils = br.readLine().split(" ");

        int number = 1;
        for(int i = n-1; i >= 0; i--) { // 사용한 스킬을 반대로 봐야 초기상태의 카드를 알 수 있음
            switch(skils[i]) {
                case "1": // 제일 위의 카드이기 때문에 리스트의 첫번째에 추가
                    result.addFirst(number);
                    break;
                case "2": // 위에서 두번째의 카드기때문에 2번째 인덱스에 카드를 추가
                    int temp = result.removeFirst();
                    result.addFirst(number);
                    result.addFirst(temp);
                    break;
                case "3": // 제일 밑에 있는 카드기 때문에 리스트의 마지막에 추가
                    result.addLast(number);
                    break;
                default:
                    // nothing
            }

            number++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(result.removeFirst()).append(" ");
        }

        System.out.println(sb);
    }
}

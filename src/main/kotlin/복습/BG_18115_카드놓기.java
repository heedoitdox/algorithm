package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.acmicpc.net/problem/18115
 *
 * 수현이의 카드 기술
 * 1. 제일 위의 카드 1장을 바닥에 내려놓는다.
 * 2. 위에서 두번째 카드를 바닥에 내려놓는다. 카드가 2장 이상일 때만 쓸 수 있다.
 * 3. 제일 밑에 있는 카드를 바닥에 내려놓는다. 카드가 2장 이상일 때만 쓸 수 있다.
 * 최종적으로 카드는 순서대로 1,2,....N 으로 놓여있다. 초기 카드의 상태를 출력
 *
 * 카드 리스트에서 맨앞, 맨뒤를 자유자재로 뺴고 넣을 수 있어야하기 때문에 덱 자료구조를 이용한다.
 * 스킬을 반대로 시뮬레이션 해보면 카드의 초기 상태가 나온다.
 */
public class BG_18115_카드놓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] skills = br.readLine().split(" ");

        Deque<Integer> cards = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            cards.add(i+1);
        }

        Deque<Integer> result = new LinkedList<>();
        for(int i = skills.length-1; i >= 0; i--) {
            switch(skills[i]) {
                case "1" :
                    if(!cards.isEmpty()) {
                        result.addFirst(cards.removeFirst());
                    }
                    break;
                case "2" :
                    if(!result.isEmpty()) {
                        int temp = result.removeFirst();
                        result.addFirst(cards.removeFirst());
                        result.addFirst(temp);
                    }
                    break;
                case "3" :
                    if(!result.isEmpty()) {
                        result.addLast(cards.removeFirst());
                    }
                    break;
                default:
                    // nothing
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(result.removeFirst()).append(" ");
        }
        System.out.println(sb);
    }
}

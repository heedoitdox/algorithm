package 링크드리스트;

import java.io.*;
import java.util.*;

public class BG_18115_카드놓기_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 카드의 수 N 입력
        int n = Integer.parseInt(br.readLine());

        // 역순으로 주어진 기술들을 StringTokenizer를 사용하여 역순으로 파싱하여 Deque에 저장
        StringTokenizer st = new StringTokenizer(new StringBuilder(br.readLine()).reverse().toString());
        Deque<Integer> deque = new LinkedList<>();

        // N번의 기술에 따라 카드들을 처리
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 기술에 따라 카드를 Deque의 앞쪽, 뒤쪽에 추가 또는 이동
            if (num == 1) {
                deque.addFirst(i);
            } else if (num == 2) {
                int top = deque.removeFirst();
                deque.addFirst(i);
                deque.addFirst(top);
            } else {
                deque.addLast(i);
            }
        }

        // 최종적으로 Deque에 있는 카드들을 순서대로 StringBuilder에 추가
        StringBuilder sb = new StringBuilder();
        while (deque.size() != 0) {
            sb.append(deque.removeFirst() + " ");
        }

        // 결과 출력
        System.out.println(sb);
    }
}
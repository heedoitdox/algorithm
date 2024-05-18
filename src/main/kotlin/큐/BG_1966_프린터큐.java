package 큐;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 백준 1966 프린터큐 (필수)
 * https://www.acmicpc.net/problem/1966
 * <p>
 * 문제풀이:
 * - 중요도 라는 키워드가 있기 때문에 priorityQueue 개념을 적용한다.
 *
 * - 우선순위큐에 index 를 같이 넣으면 priority 가 같을 때 index 도 기준으로 다시 정렬(?) 하기 때문에 같이 넣으면 안된다 -> 더 깊게 파보 1 9
 */
public class BG_1966_프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int index = Integer.parseInt(input[1]); // 출력값으로 나올 수의 위치

            // 입력받은 수열(문자열) 을 분리하고 Integer 리스트로 변환
            List<Integer> str = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

            // 우선순위큐안에 넣을 자료구조의 대한 우선순위를 정해줘야함
            // priority 숫자가 클수록 먼저고 같다면 index 가 클수록 먼저다.
            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
                // priority 비교
                int priorityComparison = Integer.compare(o2.priority, o1.priority);
                if (priorityComparison != 0) {
                    return priorityComparison;
                }
                // priority가 같을 경우 index 비교
                return 0;
            });

            for (int k = 0; k < str.size(); k++) {
                pq.add(new Node(k, str.get(k)));
            }

            for (int l = 0; l < str.size(); l++) {
                if (!pq.isEmpty() && pq.peek().index == index) { // 큐에 값이 존재하고 peek 값의 인덱스와 구하려고 하는 인덱스의 값이 같을 때
                    bw.write(String.format("%d\n", l + 1)); // 몇번째로 출력됐는지 버퍼에 기록
                }
                pq.poll();
            }
        }

        bw.flush();
        bw.close();
    }

    public static class Node {
        int index;
        int priority;

        public Node(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}

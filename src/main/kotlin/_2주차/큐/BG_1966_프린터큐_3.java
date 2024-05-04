package _2주차.큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 */
public class BG_1966_프린터큐_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 테스트케이스의 수
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            // 문서의 개수
            int N = Integer.parseInt(stringTokenizer.nextToken());
            // 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지
            int M = Integer.parseInt(stringTokenizer.nextToken());

            // 문서의 ‘중요도’
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder()); // 숫자가 클수록 더 우선이기 때문에 reverse 를 한다

            // 문서를 인쇄 명령을 받은 ‘순서대로’
            Queue<Document> queue = new LinkedList<>();
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                int priority = Integer.parseInt(stringTokenizer.nextToken());
                priorityQueue.offer(priority); // 우선순위큐와
                queue.offer(new Document(j, priority)); // 큐에 동시에 넣는다.
            }
            // 궁금한 문서가 몇 번째로 인쇄되었는지
            int answer = 1;
            while (!queue.isEmpty()) {
                int priority = priorityQueue.poll();
                Document document = queue.poll();
                if (document.priority == priority) {
                    if (M == document.index) {
                        break;
                    }
                    answer++;
                    continue;
                }
                priorityQueue.offer(priority);
                queue.offer(document);
            }
            System.out.println(answer);
        }
    }
}

// 인쇄하고자 하는 문서
class Document {
    int index;
    int priority;

    public Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}
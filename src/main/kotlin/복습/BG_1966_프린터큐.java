package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * (복습필요)
 */
public class BG_1966_프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 문서의 개수
            int m = Integer.parseInt(st.nextToken()); // 몇번째로 출력됐는지 궁금한 문서의 인덱스

            st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            LinkedList<Document> q = new LinkedList<>();
            for(int i = 0; i < n; i++) {
                int value = Integer.parseInt(st.nextToken());
                Document document = new Document(i, value);
                pq.add(value);
                q.add(document);
            }

            int answer = 1;
            while(true) {
                int priority = pq.poll();
                Document document = q.poll();
                if(priority == document.value) {
                    if(m == document.index) break;
                    answer++;
                    continue;
                }
                pq.offer(priority);
                q.offer(document);
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
     }

    private static class Document {
        public int index;
        public int value;

        public Document(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}

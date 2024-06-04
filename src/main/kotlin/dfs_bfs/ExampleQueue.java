package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ExampleQueue {
    public static void main(String[] args) {
        // 그래프를 2차원 배열로 표현해줍니다.
        // 배열의 인덱스를 노드와 매칭시켜서 사용하기 위해 인덱스 0은 아무것도 저장하지 않습니다.
        // 1번인덱스는 1번노드를 뜻하고 노드의 배열의 값은 연결된 노드들입니다.
        int[][] graph = {{}, {2,3,8}, {1,7}, {1,4,5}, {3,5}, {3,4}, {7}, {2,6,8}, {1,7}};

        // 방문처리를 위한 boolean배열 선언
        boolean[] visited = new boolean[9];

        System.out.printf(bfs(1, graph, visited));
        //출력 내용 : 1 -> 2 -> 3 -> 8 -> 6 -> 5 -> 4 -> 7 ->
    }

    static String bfs(int start, int[][] graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        // 첫번째로 들어온 노드 방문처리
        visited[start] = true;

        StringBuilder sb = new StringBuilder();
        // 큐가 빌 때까지
        while(!queue.isEmpty()) {
            Integer v = queue.poll();
            sb.append(v).append(" "); // 출력

            for(int i = 0; i < graph[v].length; i++) {
                if(!visited[graph[v][i]]) { // 방문한 적이 없을 때에만
                    queue.offer(graph[v][i]); // 큐에 넣고
                    visited[graph[v][i]] = true; // 방문처리
                }
            }
        }

        return sb.toString();
    }
}

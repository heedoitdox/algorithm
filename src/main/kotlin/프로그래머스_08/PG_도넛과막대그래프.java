package 프로그래머스_08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PG_도넛과막대그래프 {
    private static List<List<Integer>> graph;

    private static boolean[] visited;

    private static int startVertex;

    private static int maxVertex;
    private static int graphNum;

    private static int[] incomingEdges;

    public static void main(String[] args) {
        // 도넛은 나머지 정점을 방문한뒤 원래 출발했던 정점으로 돌아옴
        // 간선을 계속 따라가면 나머지 N-1 개의 정점을 한번씩 방문하게 되는 정점이 단 하나 존재
        // 8자 그래프는 2n+1 개의 정점과 2n+2 개의 간선 모양이 동일한 도넛그래프 2개의 정점을 하나씩 골라 결함

        // 생성한 정점의 번호, 도넛모양, 막대모양, 8자모양

        // 간선은 100만개

        int[][] array = {
                {4, 11},
                {1, 12},
                {8, 3},
                {12, 7},
                {4, 2},
                {7, 11},
                {4, 8},
                {9, 6},
                {10, 11},
                {6, 10},
                {3, 5},
                {11, 1},
                {5, 3},
                {11, 9},
                {3, 8}
        };

        int[] result = solution(array);
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }

    private static void initGraph(int[][] edges) {
        maxVertex = 0;

        // 정점의 최대수를 구한다.
        for(int[] edge : edges) {
            maxVertex = Math.max(maxVertex, Math.max(edge[0], edge[1]));
        }

        // 방문여부 기록
        visited = new boolean[maxVertex + 1];
        incomingEdges = new int[maxVertex + 1];
        graph = new ArrayList<>(maxVertex + 1);

        for(int i = 0; i <= maxVertex; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i< edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]); // 단방향 그래프
            incomingEdges[edges[i][1]]++;
        }
    }

    public static int[] solution(int[][] edges) {
        int[] answer = new int[4];

        initGraph(edges);

        startVertex = findCreatedVertex();
        graphNum = graph.get(startVertex).size(); // 생성된 정점과 연결된 정점들

        answer[0] = startVertex;
        // 시작 정점 연결 끊기
        removeEdgesFromCreatedVertex(startVertex);

        // 막대 그래프 개수 찾기
        // 들어오는 간선이 없거나, 나가는 간선이 없는 VERTEX 의 개수
        answer[2] = countBarGraphs();

        // 8자모양 그래스 개수 찾기
        // 들어오는 간선 2개, 나가는 간선2개인 vertex 의 개수
        answer[3] = countEightShape();
        answer[1] = graphNum - (answer[2] + answer[3]);

        System.out.println(incomingEdges[maxVertex-1]);
        return answer;
    }

    private static int countBarGraphs() {
        int count = 0;
        for (int i = 1; i < graph.size(); i++) {
            if (i == startVertex) {
                continue;
            }
            if (graph.get(i).isEmpty()) {//나가는게 없다.
                count++;
                visited[i] = true;
            }
        }
        return count;
    }

    private static int countEightShape() {
        int count = 0;
        for (int i = 1; i < graph.size(); i++) {
            if (!visited[i]) {
                if (graph.get(i).size() == 2 && incomingEdges[i] == 2) {
                    System.out.println(i);
                    count++;
                }
            }
        }
        return count;
    }

    private static int findCreatedVertex() {
        // 들어오는 갯수가 없고, 나가는 것만 2개 이상인 점.
        int createdVertex = -1; // 생성된 정점
        for (int i = 1; i < graph.size(); i++) {
            if (graph.get(i).size() >= 2 && incomingEdges[i] == 0) {
                createdVertex = i;
                break; // 무조건이라고 할수있는건가?
            }
        }
        visited[createdVertex] = true; // 정점은 이미 방문했다고 친다
        return createdVertex;
    }

    private static void removeEdgesFromCreatedVertex(int vertex) {
        for(int end:graph.get(vertex)){
            incomingEdges[end]--;
        }
        graph.set(vertex, new LinkedList<>());
    }
}

package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 14675 단절점과 단절선
 * https://www.acmicpc.net/problem/14675
 *
 * N: 정점의수
 * q: 질의의 수
 * t: 1: 단절점, 2: 단절선
 * k: 단절점인지 단절선인지
 */
public class BG_14675_단절점과단절선 {
    static int N, q, t, k;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(q-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            if(t == 1) { // 단절점을 뜻할 때
                if(graph[k].size() == 1) sb.append("no").append("\n");
                else sb.append("yes").append("\n");
            }else { // 단절선을 뜻할 때
                sb.append("yes").append("\n");
            }
        }

        System.out.println(sb);
    }
}

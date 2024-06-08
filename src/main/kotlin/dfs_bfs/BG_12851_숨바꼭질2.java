package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 12851 숨바꼭질2
 * https://www.acmicpc.net/problem/12851
 */
public class BG_12851_숨바꼭질2 {
    static int N, K, cnt, time;
    static int[] visit = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(time + "\n" + cnt);
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{N, 0});
        visit[N] = 1;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            // 동생이 있는 위치에 도달했다면
            if(cur[0] == K) {
                // 현재 걸린 시간을 일단 기록한다.
                // 무조건 제일 먼저 도달한 시간이 가장 최소 시간이다.
                if(cnt == 0) time = cur[1]; // 현재 걸린 시간을 일단 기록한다.
                if(time == cur[1]) cnt++;
                continue;
            }

            int[] arr = {cur[0]-1, cur[0]+1, cur[0]*2}; // 이동하는 3가지 방법
            for(int i = 0; i < arr.length; i++) {
                int next = arr[i];
                if (next < 0 || next > 100000) continue; // 범위를 벗어나면 건너띔

                // 방문한적 없거나 다음시간이랑 같으면? (곧 걸린 시간이랑 같다면?)
                if(visit[next] == 0 || visit[next] == cur[1]+1) {
                    visit[next] = cur[1] + 1;
                    queue.add(new int[]{next, visit[next]});
                }
            }
        }
    }
}

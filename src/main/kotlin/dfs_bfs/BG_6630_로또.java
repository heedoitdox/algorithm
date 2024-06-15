package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 6630 로또
 * https://www.acmicpc.net/problem/6603
 */
public class BG_6630_로또 {
    static boolean[] visited;
    static int[] arr, lotto;
    static int k;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        String input = "";
        while(!(input = br.readLine()).equals("0")) {
            String[] s = input.split(" ");
            k = Integer.parseInt(s[0]);
            arr = new int[k+1];
            for (int i = 0; i <= k; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            lotto = new int[k+1];
            visited = new boolean[k+1];
            dfs(0, 1);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int depth, int start) {
        if(depth == 6) {
            for(int i: lotto) {
                if(i == 0) continue;
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i <= k; i++) {
            if(!visited[i]) {
                visited[i] = true;
                lotto[depth] = arr[i];
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}

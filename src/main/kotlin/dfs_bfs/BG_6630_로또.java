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

    // 49 가지의 수중 6개만 만들으 집합을 만드는 경우의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        String input = "";
        while(!(input = br.readLine()).equals("0")) {
            String[] s = input.split(" ");
            k = Integer.parseInt(s[0]); // 집합 s 에 포함되는 수
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
        // 6개의 숫자만 골라야하기때문에 depth 가 6이되면 만든 숫자를 String builder 에 append 한다.
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
                visited[i] = true; // 방문 처리
                lotto[depth] = arr[i]; //
                dfs(depth + 1, i + 1); // 몇번 째 숫자까지 추가했는지 확인하기 위해 depth 도 같이 보내줘야한다.
                visited[i] = false; // 다음 경우의 수를 위해 false 처리
            }
        }
    }
}

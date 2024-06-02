package 완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 백준 5568 카드놓기
 * 순열 nPr => 같은수가 들어올 수 있기 때문에 이용할 수 없음
 * 무조건 문자열로밖에 풀 수 없는걸까?
 * HashSet 을 사용할 수 밖에 없는걸까?
 *
 * 모든 수를 조합하는 경우의 수를 구하려면
 * 1.
 */
public class BG_5568_카드놓기 {
    static int n,k;
    static String[] num;
    static boolean[] visited;
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        num = new String[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            num[i] = br.readLine();
        }

        set = new HashSet<>();
        select(0, "");

        int ans = set.size();
        System.out.println(ans);
    }

    static void select(int cnt, String cur) {
        if(cnt == k) { // k 개 골랐으면 리턴
            set.add(cur);
            return;
        }

        for(int i = 0; i < n; i++) { // 가지고 있는 수들을 대입하여 수를 만듦
            if(visited[i]) continue; // 방문했었다면 continue

            visited[i] = true; // 재귀호출문에서 방문처리하기위함
            select(cnt+1, cur+num[i]);
            visited[i] = false; // 다른수에서는(하나의 수의 depth 가 끝나고나면) 방문처리하면 안되기때문에 false 처리
        }
    }
}

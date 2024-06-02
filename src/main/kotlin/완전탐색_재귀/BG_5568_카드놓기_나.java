package 완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 백준 5568 카드놓기
 *
 * 순서대로 나열해야하기 때문에 순열식으로 풀 수 있지만 중복된 수의 경우 제외해야하기 때문에 HashSet 을 이용하여
 * 만든 정수를 넣고 중복을 제거하여 HashSet 의 size 를 출력한다.
 *
 * visited 를 사용하지 않고 풀 수 있는 방법이 있을까?
 * 문제에서 주어진 조건은 2 <= k <= 4 이기 때문에 이중, 삼중, 사중 (다중 반복문) 반복문을 이용하면 풀 수 있다.
 */
public class BG_5568_카드놓기_나 {
    static int n, k;
    static int[] arr;
    static boolean[] visited;
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        set = new HashSet<>();
        visited = new boolean[n];
        simulate("", 0);

        System.out.println(set.size());
    }

    static void simulate(String number, int level) {
        if(level == k) {
            set.add(number);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            simulate(number + arr[i], level + 1);
            visited[i] = false;
        }
    }
}

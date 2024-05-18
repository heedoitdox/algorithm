package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 게임의 룰을 지키며 카드를 뽑아야 하고 룰은 다음과 같다.
 * 1. 숫자가 쓰인 카드들이 N x M 형태로 놓여있다. 이 때 N 은 행의 개수를 의미하며, M 은 열의 개수를 의미한다.
 * 2. 먼저 뽑고자 하는 카드가 포함되어 있는 행을 선택한다.
 * 3. 그다음 선택된 행에 포함된 카드들 중 가장 숫자가 낮은 카드를 뽑아야한다.
 * 4. 따라서 처음에 카드를 골라낼 행을 선택할 때, 이후에 해당 행에서 가장 숫자가 낮은 카드를 뽑을 것을 고려하여 최종적으로 가장 높은 숫자의 카드를 뽑을 수 있도록 전략을 세워야 한다.
 *
 * 출력: 각 행에서 가작 작은 수들 중 제일 큰수
 *
 * 문제접근
 * - 각 행마다 가장 작은 수를 찾은 뒤에 그 수중에서 가장 큰수
 * - 배열에 넣는 것조차 사실 필요가 없다.
 */
public class 동빈나_숫자카드게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 1 <= n, m <= 100
        int result = 0;
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int min = Integer.parseInt(s[i]);
            for(int j = 0; j < n; j++) {
                min = Math.min(Integer.parseInt(s[j]), min);
            }
            result = Math.max(result, min);
        }

        System.out.println(result);
    }
}

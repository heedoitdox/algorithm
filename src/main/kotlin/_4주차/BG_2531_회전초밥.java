package _4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 2531 회전초밥
 * https://www.acmicpc.net/problem/2531
 *
 * 다음의 두가지 행사를 한다.
 * 1. 벨트의 임의의 한 위치부터 k개의 접시를 연속해서 먹으면 할인된 정액 가격으로 제공된다.
 * 2. 초밥의 종류 하나가 쓰인 쿠폰을 발행하고 1번 행사에 참가할 경우 쿠폰에 적힌 초밥을 무료로 제공하고, 벨트위에 없을 경우 새로 만들어 제공한다.
 * 위 할인 행사에 참여하여 가능한 한 다양한 종류의 초밥을 먹으려고 할 때 먹을 수 있는 초밥 가짓수의 최댓값을 구해라
 *
 * N: 회전 초밥 벨트에 놓인 접시의 수 (2 <= N <= 30000)
 * d: 초밥의 가짓수 (2 <= d <= 3000)
 * k: 연속해서 먹는 접시의 수 (2 <= k <= 3000) (k <= N)
 * c: 쿠폰 번호 (1 <= c <= d)
 *
 * [input]
 * 1. N d k c
 * 2~N. 벨트의 한 위치부터 시작하여 회전방향을 따라갈 때 나타내는 초밥의 종류 (1 <= v <= d)
 * [output]
 * 먹을 수 있는 가짓수의 최댓값
 *
 * ---
 * - 투포인터로 0~k, 1~k+1, 2~k+2 이런식으로 이동시킨다.
 * - 그리고 그 4개의 수 중 다른 수의 개수를 카운팅한다. (1 ~ k 겠지?) -> Set 을 이용해보자
 * - 따라서 아무리 많이먹어도 최대 k+1 개 아닐까?
 * - 4개를 채웠는데 그 수 중에 c 가 없다면 그냥 종료해도 될듯?
 * - 종료조건 i 가 N 보다 커지면 종료
 *
 * 소요시간: 2716 ms
 * - HashSet 을 사용하지 않으면 시간이 감소할까?
 */
public class BG_2531_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int c = Integer.parseInt(input[3]);

        int[] chobab = new int[N];
        for(int i=0; i<N; i++) {
            chobab[i] = Integer.parseInt(br.readLine());
        }

        int i = 0;
        int result = 0;
        while(i < N) { // i 가 N 보다 같거나 커지면 종료
            Set<Integer> set = new HashSet<>();
            int m = i;
            for(int l = 0; l < k; l++) { // k 개씩 묶은 리스트를 HashSet 에 추가해서 중복되지 않은 초밥의 수를 구한다.
                set.add(chobab[m]);
                m++;
                if(m >= N) m = 0;
            }
            if(!set.contains(c)) result = Math.max(set.size()+1, result);
            else result = Math.max(set.size(), result); // 둘 중 더 큰 값을 result 에 저장

            i++;
        }

        System.out.println(result);
    }
}

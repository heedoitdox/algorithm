package 완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 22864 피로도
 *
 * 1. 하루(24시간) 한시간 일하면 피로도는 A 만큼 쌓인다.
 * 2. 하루 한시간 일하면 일은 B 만큼 처리할 수 있다.
 * 3. 한시간을 쉰다면 피로도는 C 만큼 줄어든다. (피로도가 음수로 내려가면 0으로 바뀐다)
 * 4. 피로도는 M 을 넘지 않게 하려고 한다.
 * 하루에 최대 얼마나 일을 할 수 있는지 구해라.
 *
 * 접근:
 * 1부터 무한으로 일한 시간을 대입하여 주어진 식을 만족하는 최대수를 구한다.
 * 일을 안하면 쉬는 시간이기 때문에 24시 에서 일한 시간을 뺀게 쉰 시간이다.
 * 브루트포스를 이용하면 될 것 같다.
 *
 * 피로도가 w 을 넘었다고 해서 반복문을 종료시키면 안된다.
 * 24시간을 무조건 모두 돌려야한다.
 * "일하고 쉬고를 번갈아 가면서 해야한다?"
 */
public class BG_22864_피로도 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int w = 0;
        int tiredPoint = 0;
        for(int i = 1; i <= 24; i++) {
            if(tiredPoint + a <= m) { // 일해서 쌓인 피로도
                w += b; //
                tiredPoint += a;
            }else {
                tiredPoint -= c; // 쉬어서 해소되는 피로도
                if(tiredPoint < 0) tiredPoint = 0; // 피로도가 음수라면 0으로 다시 세팅된다.
            }
        }

        System.out.println(w);
    }
}

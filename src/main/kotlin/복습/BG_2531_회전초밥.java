package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BG_2531_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰번호

        int[] eat = new int[d + 1]; // 먹은 초밥을 기록할 배열
        eat[c] = 3001; // 쿠폰 번호의 초밥은 무조건 제공 (테이블에 보너스 번호인 초밥이 있을 수 있으므로 보너스 초밥을 큰수로 해놓는다)

        int[] table = new int[n];
        // 초밥 번호 입력받기
        for(int i = 0; i < n; i++) {
            table[i] = Integer.parseInt(br.readLine());
        }

        int count = 1; // 보너스 초밥이 있기때문에 1을 기본으로 세팅한다

        // 먼저 처음 먹은 것만 기록
        // 연속해서 먹는 접시수 (k개의 초밥)을 eat 배열에 기록한다.
        for(int i = 0; i < k; i++) {
            int nowEat = table[i];
            // 새로 먹은 종류일 경우 count 를 더해준다.
            if(++eat[nowEat] == 1) count++;
        }

        int max = count; // 최대값을 현재 count 로 지정

        // 1부터 시작한다.
        for(int i = 1; i < n; i++) {
            // 슬라이딩 윈도우를 이동하면서 인덱스에서 없어진것과 새로 더해진 것을 비교한다

            // 이전에 먹은 초밥 종류 제거
            int prevChobab = table[i - 1];

            // 이전에 먹은 초밥 제거시 0이 되면 종류를 하나 줄인다.
            if(--eat[prevChobab] == 0) count--;

            // 새로 먹을 초밥
            // 인덱스가 배열의 끝을 넘게되면 다시 0부터 시작할 수 있도록 인덱스를 조정함
            int nextIndex = i + k > n ? i + k - n - 1 : i + k - 1;
            int nextChobab = table[nextIndex];

            // 새로 먹을 초밥이 처음 먹는 거라면 종류를 1 늘린다.
            if (++eat[nextChobab] == 1) count++;

            // max 값 갱신
            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}

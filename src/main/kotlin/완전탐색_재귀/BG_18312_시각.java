package 완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 18312 시각
 *
 * 문자열로 바꿔서 비교하면 시간이 더 걸린다?
 */
public class BG_18312_시각 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < 60; j++) {
                for(int l = 0; l < 60; l++){
                    if(i / 10 == k || i % 10 == k) cnt++;
                    else if(j / 10 == k || j % 10 == k) cnt++;
                    else if(l / 10 == k || l % 10 == k) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}

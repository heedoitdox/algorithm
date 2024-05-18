package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 다양한 수로 이루어진 배열이 있을 때 주어진 수들을 M 번 더하여 가장 큰수를 만드는 법칙
 * 단, 배열의 특정한 인덱스에 해당하는 수가 연속해서 K번을 초과하여 더해질 수 없는 것이 특징이다.
 */
public class 동빈나_큰수의법칙 {
    public static void main(String[] args) throws IOException {
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 더해야하는 수의 개수
        int k = Integer.parseInt(st.nextToken()); // 연속으로 올 수 있는 수

        String[] s = br.readLine().split(" ");
        Integer[] arr = new Integer[n]; // 정렬하고 싶을 때 Integer 로 박싱해줘야함
        for(int i = 0; i < s.length; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int sum = 0;
        int cnt = 0;
        boolean flag = false;

        // 결국 가장 큰수와 그 다음수만 계속해서 더하면 된다.
        // 연속으로 더할 수 있는 횟수는 최대 K 번이므로 가장 큰수를 K번 더하고 두번째로 큰수를 한번 더하는 연산을 반복하면 된다.
        while(cnt < m) {
            for(int i = 0; i < k; i++) {
                sum += arr[0];
                cnt++;
                if(cnt > m) {
                    flag = true;
                    break;
                }
            }

            if(flag) break;
            sum += arr[1];
            cnt++;
        }

        System.out.println(sum);

        /* 실행할 코드 */

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);
    }
}

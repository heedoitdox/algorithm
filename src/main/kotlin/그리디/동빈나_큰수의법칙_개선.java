package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 만약 M 이 100억개가 넘어간다면 이전 방법에서 시간초과가 발생할 수 있다.
 * 따라서 좀 더 간단한 수학식으로 정의해서 풀면 시간을 줄일 수 있다.
 *
 * 1. 결국 가장 큰수와 가장 작은수만 더해주면 된다. (6+6+6+5) + (6+6+6+5)
 * 2. 같은 수열이 반복된다. 한 수열의 길이는 (K+1) 가 된다.
 * 3. 더할 수 있는 개수 M 도 제공되기 때문에 M/(K+1) 의 몫이 더해지는 수열의 개수가 된다.
 * 4. 나머지는 M % (K+1) 이고 이 나머지 만큼 큰수를 더해주면된다.
 * 5. 따라서 큰 수의 개수는 (M/(K+1))*K + M % (K+1)
 */
public class 동빈나_큰수의법칙_개선 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] s = br.readLine().split(" ");
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int maxNumCount = (k * (m/(k+1))) + (m%(k+1));
        int nextNumCount = m - maxNumCount;

        System.out.println(maxNumCount * arr[0] + nextNumCount * arr[1]);
    }

}

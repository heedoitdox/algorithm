package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BG_1929_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[n+1];
        for(int i = 0; i < n; i++) {
            arr[i] = false;
        }

        for(int i = n; i <= m; i++) {
            if(arr[i]) continue; // 이미 소수라면 continue

            boolean flag = true;
            for(int j = 2; j < Math.sqrt(m)+1; j++) {
                if(i % j == 0) flag = false;
            }
            if(flag) arr[i] = flag;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = n; i <= m; i++) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}

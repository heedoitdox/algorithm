package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BG_9046_복호화 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n --> 0){
            int[] count = new int[26];
            String str = br.readLine();
            for(byte k : str.getBytes()){
                if(k >= 'a' && k <= 'z') count[k-'a']++;
            }
            int max = 0;
            int result = 0;
            int cnt = 0;
            for(int i = 0 ; i < 26; i++){
                max = Math.max(max, count[i]);
            }
            for(int i = 0 ; i < 26; i++){
                if(max ==count[i]) {
                    cnt++;
                    result = i;
                }
            }
            System.out.println(cnt > 1 ? "?" : (char) (result+ 'a')  );

        }
    }
}

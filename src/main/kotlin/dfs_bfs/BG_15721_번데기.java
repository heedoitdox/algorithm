package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BG_15721_번데기 {
    static int a,t,n;
    static int repeat=2;
    static int zeroCount, oneCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        int result = solve();
        System.out.println(result);
    }

    // 1. 뻔=0, 데기=1 로 설정해서 각자가 나온 횟수를 카운팅한다.
    // 2. 뻔 데기 뻔데기 4번은 고정으로 반복됨
    // 3. repeat 변수를 이용해서 뻔과 데기가 몇 번 반복해야 하는지 확인
    // 4. 0 혹은 1 의 등장 횟수가 t 와 같다면 return (뻔 cnt + 데기 cnt-1) % A
    public static int solve(){
        while (true) {
            for(int i=0; i<4; i++){
                if(i%2==0){
                    zeroCount++;
                }
                else{
                    oneCount++;
                }
                if(n==0 && zeroCount==t){
                    return (zeroCount+oneCount-1)%a;
                }
                if(n==1 && oneCount==t){
                    return (zeroCount+oneCount-1)%a;
                }
            }
            for(int i=0; i<repeat; i++){
                zeroCount++;
                if(zeroCount==t && n==0){
                    return (zeroCount+oneCount-1)%a;
                }
            }
            for(int i=0; i<repeat; i++){
                oneCount++;
                if(oneCount==t && n==1){
                    return (zeroCount+oneCount-1)%a;
                }
            }
            repeat++;
        }
    }
}
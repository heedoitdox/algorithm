package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * (복습필요)
 * - 2진수에서 바로 8진수로 변환
 * - 더해질 수 있는 값은 1, 2, 4 밖에 없음
 * or
 * - 2진수에서 10진수로 변환한다음 다시 8진수로 변환 => 이거는 최댓값때문에 할 수 없음
 */
public class BG_1373_2진수8진수 {
    static StringBuilder answer = new StringBuilder(333339);
    static int[] pow = {1, 2, 4};
    static int startI = 0;
    static String inputs;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine();
        String temp; // 답은 string형으로 처리
        int len = inputs.length(), templen;
        if(len % 3 == 1){
            cal(0, 1);
            startI += 1;
        }
        else if(len % 3 == 2){
            cal(0, 2);
            startI += 2;
        }
        for(int i = startI; i < len-1; i += 3)
            cal(i, 3);
        System.out.println(answer);
    }
    static void cal(int i, int len){
        int tempsum = 0;
        for(int j = 0; j < len; j++)
            tempsum += (inputs.charAt(i+j) - '0')*pow[len-j-1];
        answer.append(tempsum);
    }
}

package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BG_11720_숫자의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var n = br.readLine();
        String[] str = br.readLine().split("");
        System.out.println(Arrays.stream(str).mapToInt(Integer::parseInt).sum());
    }
}


// Scanner 와 BufferedReader 의 차이
// BufferedReader 가 성능측면에서 더 좋다 Scanner 는 타입을 구분해서 받을 수 있기 때문
// Integer.valueOf() 와 Integer.parseInt() 의 차이

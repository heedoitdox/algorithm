package 중간고사;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * 백준 2870 수학숙제
 * https://www.acmicpc.net/problem/2870
 *
 * 알파벳 소문자와 숫자로 이루어진 문자열에서 숫자뭉치만 찾아 비내림차순으로 정렬하여 출력한다.
 * 0은 생략할 수 있다.
 */
public class BG_2870_수학숙제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<BigInteger> list = new ArrayList<>();

        while(N-->0) {
            char[] str = br.readLine().toCharArray();

            for(int i = 0; i < str.length; i++) {
                if(isNumber(str[i])) { // 0~9 의 숫자인 경우
                    sb.append(str[i]);

                    if(i+1 != str.length) { // 문자 배열이 아직 끝나지 않은경우
                        if(!isNumber(str[i+1])) { // 다음 문자가 숫자가 아닌 경우
                            String numbers = sb.toString();
                            list.add(new BigInteger(numbers));
                            sb.setLength(0); // 다음 숫자를 만들기 위해 StringBuffer 를 비워준다.
                        }
                    } else { // 이번 문자가 배열의 끝인 경우
                        String numbers = sb.toString();
                        list.add(new BigInteger(numbers));
                        sb.setLength(0);
                    }
                }
            }
        }

        Collections.sort(list); // 오름차순 정렬
        for(int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + "\n");
        }

        bw.flush();
        bw.close();
    }

    /* 0~9 까지의 숫자인 경우 */
    private static boolean isNumber(char str) {
        return 47 <= str && str <= 57;
    }
}

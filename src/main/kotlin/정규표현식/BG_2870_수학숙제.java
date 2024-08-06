package 정규표현식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * 백준 2870 수학숙제
 * https://www.acmicpc.net/problem/2870
 */
public class BG_2870_수학숙제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j, n = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        ArrayList<BigInteger> paper = new ArrayList<>();
        for(i=0;i<n;i++){
            String[] s = br.readLine().split("\\D");
            for(j=0;j<s.length;j++)
                if(!s[j].equals("")) paper.add(new BigInteger(s[j]));
        }

        paper.sort(null);
        n = paper.size();
        for(i=0;i<n;i++) sb.append(paper.get(i)+"\n");
        System.out.println(sb.toString());
    }

}

package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

/**
 * 백준 2141 우체국
 * https://www.acmicpc.net/problem/2141
 *
 * 직선으로 된 마을들 중 한 마을에 우체국이 세워질 때
 * 다른 마을 사람들이 우체국이 세워진 마을에 가기 위해 필요한 거리의 합이 최소가 되는 마을 번호 찾기
 * 1. 모든 마을 사람의 총합을 구한다.
 * 2. 리스트를 순회할 때 절반이 넘어가는 마을 번호를 찾는다.
 */
public class BG_2141_우체국 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        HashMap<BigInteger, BigInteger> map = new HashMap<>();

        BigInteger sum = BigInteger.ZERO;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger vil = new BigInteger(st.nextToken());
            BigInteger per = new BigInteger(st.nextToken());
            map.put(vil, per);
            sum = sum.add(per);
        }

        List<BigInteger> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        BigInteger middle = sum.add(BigInteger.ONE).divide(new BigInteger("2"));
        BigInteger count = BigInteger.ZERO;
        for(BigInteger key: keySet) {
            count = count.add(map.get(key));
            int compare = middle.compareTo(count); // 누적된 사람 수와 중간값 비교
            if(compare == 0 || compare == -1) { // 누적된 사람 수가 중간값 보다 같거나 크다면
                System.out.println(key);
                break;
            }
        }
    }
}

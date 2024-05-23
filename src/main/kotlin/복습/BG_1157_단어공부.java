package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 각 알파벳별로 사용된 횟수를 저장해야하기때문에 해쉬맵을 이용한다.
 */
public class BG_1157_단어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 대문자와 소문자를 구분하지않고 출력은 대문자로 하기 때문에 모든 문자열을 대문자로 바꿔준다.
        String s = br.readLine().toUpperCase();

        // 단어의 길이는 1000000을 넘지 않기 때문에 모든 카운팅을 해도 int 범위 안이다
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        int max = 0;
        for (int v : map.values()) {
            max = Math.max(v, max);
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(max == entry.getValue()){
                sb.append(entry.getKey());
                cnt++;
                if(cnt >= 2) {
                    sb = new StringBuilder();
                    sb.append("?");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}

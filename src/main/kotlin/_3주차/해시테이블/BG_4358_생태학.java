package _3주차.해시테이블;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * 백준 4358 생태학
 * https://www.acmicpc.net/problem/4358
 *
 * - 사전순 정렬: TreeMap
 * - TreeMap 의 최대 사이즈는?
 *
 * 1. 나무 종의 이름을 key, 들어온 횟수를 value 로 저장한 TreeMap 을 만든다.
 * 2. 총 들어온 종의 수도 카운팅 한다 (cnt)
 * 3. map 반복문을 돌면서 백분율 계산을 한다.
 * 4. key 의 이름과 계산한 백분율을 출력버퍼에 저장하고 한꺼번에 출력한다.
 */
public class BG_4358_생태학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        TreeMap<String, Double> map = new TreeMap<>();

        double cnt = 0;
        String key = "";
        while((key = br.readLine()) != null) {
            // 들어오는 대로 key 와 value 의 횟수를 증가한다.
            map.put(key, map.getOrDefault(key, 0.0) + 1);
            cnt++;
        }

        // map 반복문을 돌면서 백분율을 계산한다.
        for (Map.Entry<String, Double> entry: map.entrySet()) {
            // 백분율 계산
            Double per = (entry.getValue() / cnt) * 100.0;
            bw.write(entry.getKey() + " " + String.format("%.4f", per) + "\n");
        }

        bw.flush();
        bw.close();
    }
}

package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// https://www.acmicpc.net/problem/1157
// 단어 공부
public class BG_1157_단어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().toUpperCase().split("");

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            if (map.containsKey(str[i])) {
                map.put(str[i], map.get(str[i]) + 1);
            } else {
                map.put(str[i], 1);
            }
        }

        var maxMap = map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        long cnt = map.entrySet().stream()
                .filter(entry -> Objects.equals(entry.getValue(), maxMap.getValue()))
                .count();

        System.out.println(cnt > 1 ? "?" : maxMap.getKey());
    }
}


// HashMap 이 더 오래걸린다...

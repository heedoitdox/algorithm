package 문자열;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * 백준 20291 파일정리
 * https://www.acmicpc.net/problem/20291
 *
 * TreeMap 을 이용하면 key 를 사전순으로 정렬해준다.
 *
 * 시간:
 * - System.out.print 사용하면 1488ms
 * - BufferedWriter 를 사용하면 832ms (메모리: 54936kb)
 * - StringBuilder 로 출력값을 만든 후 출력하면 780ms (메모리: 65428kb)
 * - split 대신 subString 사용했을 경우 656ms
 */
public class BG_20291_파일정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> map = new TreeMap<>();

        int n = Integer.parseInt(br.readLine());
        while(n-->0) {
            String file = br.readLine();
            String ext = file.substring(file.indexOf('.') + 1);
            if(map.containsKey(ext)) map.put(ext, map.get(ext)+1);
            else map.put(ext, 1);
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> m : map.entrySet()) {
            sb.append(m.getKey()).append(" ").append(m.getValue()).append("\n");
        }

        System.out.println(sb);
    }
}

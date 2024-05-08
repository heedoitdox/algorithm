package _3주차.해시테이블;

import java.io.*;
import java.util.Hashtable;

/**
 * 백준 1620 나는야 포켓몬 마스터 이다솜
 * https://www.acmicpc.net/problem/1620
 *
 * 포켓몬 이름과 포켓몬 번호를 매칭해서 이름 <-> 번호 가 출력되도록 한다.
 * 시간초과: 테이블내의 모든 원소를 반복문으로 찾게되면 매우 느리다. 따라서 테이블을 하나 더 만들어서 해결했다.
 *
 * - NumberFormatException 대신 input 문자의 첫글자가 숫자인지 문자인지를 보고 비교해도 된다.
 */
public class BG_1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); // 도감에 수록된 포켓몬의 개수
        int M = Integer.parseInt(s[1]); // 내가 맞춰야하는 문제의 개수

        Hashtable<String, Integer> table = new Hashtable<>();
        Hashtable<Integer, String> table2 = new Hashtable<>();
        for(int i = 0; i < N; i++) {
            String pocketmon = br.readLine();
            if(!table.containsKey(pocketmon)) { // 도감에 포켓몬이 등록되지 않았다면
                table.put(pocketmon, i+1);
                table2.put(i+1, pocketmon);
            }
        }

        for(int i = 0; i < M; i++) {
            String input = br.readLine();

            if(isParsableAsInt(input)) bw.write(table2.get(Integer.parseInt(input)) + "\n");
            else bw.write(table.get(input) + "\n");
        }

        bw.flush();
        bw.close();
    }

    /* 문자열을 정수로 파싱할 수 있는지 확인하는 메서드 */
    public static boolean isParsableAsInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

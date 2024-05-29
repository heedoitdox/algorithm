package 완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 15721 번데기
 *
 * 뻔 데기 뻔 데기 뻔 뻔 데기 데기
 * 뻔 데기 뻔 데기 뻔 뻔 뻔 데기 데기 데기
 *
 * 입력
 * 1. 게임을 진행하는 사람 A명 (1 <= A <= 2000)
 * 2. 구하고자 하는 번째 T (T <= 10000)
 * 3. 구하고자 하는 구호가 뻔이면 0, 데기면 1
 */
public class BG_15721_번데기 {
    static String[] game = {"뻔", "데기", "뻔", "데기"};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        boolean front = Boolean.parseBoolean(br.readLine());

        int n = 0;
        int cnt = 0;
        int result = 0;
        while(true) { // 테스트 케이스 만큼 반복문
            List<String> gameSet = makeGameString(n);
            for (String game : gameSet) {
                
            }
        }

    }

    static List<String> makeGameString(int n){
        List<String> list = new ArrayList<>(Arrays.asList(game));
        list.add(game[0].repeat(n+1));
        list.add(game[2].repeat(n+1));

        return list;
    }
}

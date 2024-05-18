package 링크드리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 백준 2164 카드 2
 * https://www.acmicpc.net/problem/2164
 */
public class BG_2164_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> deq = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            deq.add(i);
        }

        while(true) {
            if(deq.size() == 1) break;

            deq.removeFirst();
            if(deq.size() == 1) break;

            deq.addLast(deq.removeFirst());
        }

        System.out.println(deq.pop());
    }
}

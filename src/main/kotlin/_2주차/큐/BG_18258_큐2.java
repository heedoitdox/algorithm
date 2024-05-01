package _2주차.큐;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.acmicpc.net/problem/18258
 * 시간: 1460ms
 *
 * 출력초과: push 는 출력하지 않는다.
 * 시간초과: 빠른 입출력을 위해 BufferedReader, BufferedWriter 를 사용 (https://ontheway.tistory.com/64)
 */
public class BG_18258_큐2 {
    private static final String PUSH = "push";
    private static final String FRONT = "front";
    private static final String POP = "pop";
    private static final String SIZE = "size";
    private static final String EMPTY = "empty";
    private static final String BACK = "back";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");

            if(str[0].equals(PUSH)) {
                queue.addLast(Integer.parseInt(str[1]));
            }else if(str[0].equals(FRONT)) {
                if(queue.isEmpty()) bw.write(-1+"\n");
                else bw.write(queue.getFirst()+"\n");
            }else if(str[0].equals(POP)) {
                if(queue.isEmpty()) bw.write(-1+"\n");
                else bw.write(queue.remove()+"\n");
            }else if (str[0].equals(SIZE)) {
                bw.write(queue.size()+"\n");
            }else if (str[0].equals(EMPTY)) {
                if(queue.isEmpty()) bw.write(1+"\n");
                else bw.write(0+"\n");
            }else if (str[0].equals(BACK)) {
                if(queue.isEmpty()) bw.write(-1+"\n");
                else bw.write(queue.getLast()+"\n");
            }
        }

        bw.flush();
        bw.close();
    }
}

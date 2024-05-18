package 링크드리스트;

import java.io.*;
import java.util.LinkedList;

/**
 * 백준 1158 요세푸스
 * https://www.acmicpc.net/problem/1158
 *
 * - 리스트 사이즈를 초과하는 인덱스에 대해서 잘 처리하는게 관건
 */
public class BG_1158_요세푸스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append('<');

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            list.add(i+1);
        }

        int index = k-1;
        while(list.size()!=1) {
            sb.append(list.remove(index) + ", ");

            index = index + k - 1;
            if(index >= list.size()) {
                index = getNextIndex(index, list.size());
            }

        }

        sb.append(list.removeLast() + ">");
        System.out.println(sb);
    }

    private static int getNextIndex(int index, int listSize) {
        while (index >= listSize) {
            index = index % listSize;
        }

        return index;
    }
}

package 해시테이블;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class BG_10816_숫자카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Hashtable<Integer, Integer> table = new Hashtable<>();

        int N = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        for(int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);
            table.put(number, table.getOrDefault(number, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        String[] cards = br.readLine().split(" ");
        for(int i = 0; i < cards.length; i++) {
            int key = Integer.parseInt(cards[i]);
            if(table.containsKey(key)) sb.append(table.get(key)).append(" ");
            else sb.append(0).append(" ");
        }

        System.out.println(sb);
    }
}

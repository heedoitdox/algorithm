package _2주차.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 시간: 72ms
 */
public class BG_2840_행운의바퀴_2 {

    private void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        int[] array = new int[n];
        int[] overlap = new int[26];
        int before = 0;
        int index = 0;
        boolean bool = false;

        Arrays.fill(array, -1);
        Arrays.fill(overlap, -1);

        // 1. 같은 배열 인덱스에 다른 문자가 덮어질 경우 ! (같은 인덱스에 같은 문자가 덮어질 순 있음)
        // 2. 같은 문자가 쓰여질 경우 !

        for (int i = 0; i < k; i++) {
            int s = sc.nextInt();
            int x = sc.next().charAt(0);

            before += s;
            index = before % n;

            // 1.
            if (array[index] != -1 && array[index] != x) {
                bool = true;
            } else {
                // 2.
                if (overlap[x - 65] != -1 && overlap[x - 65] != index) {
                    bool = true;
                }
                array[index] = x;

                overlap[x - 65] = index;
            }

        }

        if (bool) {
            System.out.println("!");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (array[i] != -1) {
                sb.append((char) array[i]);
            } else {
                sb.append("?");
            }
        }
        sb.reverse(); // stringBuffer 에 존재하는 문자를 거꾸로 출력
        System.out.println(sb.substring(sb.length() - 1 - index, sb.length()) + sb.substring(0, sb.length() - 1 - index));
    }

    public static void main(String[] args) {
        sc.init();

        new BG_2840_행운의바퀴_2().solve();
    }

    static class sc {
        private static BufferedReader br;
        private static StringTokenizer st;

        static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        static String readLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
            }
            return null;
        }

        static String readLineReplace() {
            try {
                return br.readLine().replaceAll("\\s+", "");
            } catch (IOException e) {
            }
            return null;
        }

        static String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
        }

        static long nextLong() {
            return Long.parseLong(next());
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }

        static double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
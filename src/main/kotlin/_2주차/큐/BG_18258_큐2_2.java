package _2주차.큐;

/**
 * 참고: https://www.acmicpc.net/source/39253977
 */
public class BG_18258_큐2_2 {
    static final char PUSH = 'u';
    static final char POP = 'o';
    static final char SIZE = 's';
    static final char EMPTY = 'e';
    static final char FRONT = 'f';
    static final char BACK = 'b';

    public static void main(String[] args) throws Exception {

        int N = read();

        int[] queue = new int[N];
        int tail = 0, head = 0;

        BufferedWriter bw = new BufferedWriter();

        while (N-- > 0) {

            int op = System.in.read();
            if (op == 'p') op = System.in.read();

            read();

            switch (op) {
                case PUSH:
                    queue[tail++] = read();
                    continue;
                case POP:
                    bw.write(tail == head ? -1 : queue[head++]);
                    break;
                case SIZE:
                    bw.write(tail - head);
                    break;
                case EMPTY:
                    bw.write(tail == head ? 1 : 0);
                    break;
                case FRONT:
                    bw.write(tail == head ? -1 : queue[head]);
                    break;
                case BACK:
                    bw.write(tail == head ? -1 : queue[tail - 1]);
                    break;
            }

        }

        bw.close();

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}

// 이걸 직접 만들어서 써야 속도가 빨라지는걸까?
class BufferedWriter {

    java.io.BufferedWriter bw;
    char[] buffer;
    char[] temp;
    int pointer;
    final int MAX_SIZE = 1024;

    BufferedWriter() {
        bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(System.out));
        buffer = new char[MAX_SIZE];
        temp = new char[8];
    }

    void write(int num) throws Exception {
        if (pointer + 8 >= MAX_SIZE) flush();
        if (num < 0) {
            buffer[pointer++] = 45;
            buffer[pointer++] = 49;
        } else {
            int p = 0;
            do {
                temp[p++] = (char) ((num % 10) | 48);
            } while ((num /= 10) > 0);
            while (p > 0) buffer[pointer++] = temp[--p];
        }
        buffer[pointer++] = 10;
    }

    void flush() throws Exception {
        bw.write(buffer, 0, pointer);
        pointer = 0;
    }

    void close() throws Exception {
        flush();
        bw.close();
    }

}
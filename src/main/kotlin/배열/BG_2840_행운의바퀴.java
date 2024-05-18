package 배열;

import java.io.*;

/**
 * 백준 2840 행운의바퀴
 * https://www.acmicpc.net/problem/2840
 *
 * 문제설명:
 * 바퀴의 각 칸에는 알파벳이 존재하고 바퀴를 돌려서 나오는 알파벳을 기록한다.
 * 기록된 알파벳과 글자칸의 차이를 통해 바퀴에 존재하는 알파벳을 순서대로 출력한다. (마지막 알파벳을 시작으로)
 *
 * 문제풀이:
 * 1. 이미 알파벳이 존재하는 곳에 다른 알파벳은 존재할 수 없다. (즉, 종이에 해당하는 행운의 바퀴가 없다.)
 * 하지만 이미 존재하는 알파벳과 같은 알파벳이라면 상관없다.
 * 2. 같은 글자는 두 번이상 등장하지 않는다.
 * 3. 1번 또는 2번을 만족하지 못하면 ! 을 출력한다.
 * 4. 바퀴칸에 중복된 알파벳이 들어가면 안된다.
 *
 * 참고: https://www.acmicpc.net/board/view/137851
 */
public class BG_2840_행운의바퀴 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]); // 바퀴의 칸 수
        int K = Integer.parseInt(str[1]); // 바퀴를 돌리는 횟수

        char[] wheel = new char[N];
        for(int i = 0; i  < N; i++) { // ? 로 배열 초기화
            wheel[i] = '?';
        }

        int curIndex = 0;
        boolean flag = false;

        for(int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            if(i==0) { // 처음 바퀴를 돌렸다면 배열에 첫번째 알파벳을 넣음
                wheel[i] = input[1].charAt(0);
                continue;
            }

            char inputChar = input[1].charAt(0);
            int nextIndex = nextIndex(curIndex, Integer.parseInt(input[0]), N);
            int nextChar = wheel[nextIndex];

            if(inputChar != nextChar) { // 입력된 알파벳과 바퀴칸의 알파벳이 다르다면
                if(nextChar == '?') {
                    for(char c: wheel) { // 이미 중복된 알파벳이 존재하는지 확인
                        if(c == inputChar) { // 중복으로 존재한다면 종이에 해당하는 행운의 바퀴가 아님
                            flag = true;
                            break;
                        }
                    }
                    if(!flag) wheel[nextIndex] = inputChar; // 초기값이라면 알파벳을 입력해준다.
                    else break;
                }
                else {
                    flag = true; // 이미 다른 알파벳이 있다면 종이에 해당하는 행운의 바퀴가 없는 것이므로 flag 를 설정하고 break 한다.
                    break;
                }
            }

            curIndex = nextIndex;
        }

        if(flag) bw.write('!');
        else {
            int index = curIndex;
            while(N-->0) {
                if(index < 0) {
                    bw.write(wheel[wheel.length+index]);
                    index--;
                    continue;
                }

                bw.write(wheel[index]);
                index--;
            }
        }

        bw.flush();
        bw.close();
    }

    private static int nextIndex(int curIndex, int S, int size) {
        if (curIndex + S >= size) { // 현재 인덱스에서 돌아간 칸의 수가 바퀴 칸의 수보다 크다면
            return (curIndex + S) % size;
        } else if (curIndex + S == size) {
            return 0;
        }

        return curIndex + S;
    }
}

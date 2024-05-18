package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 게임캐릭터가 움직일 수 있는 칸의 수
 * 1. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향(반시계 방향으로 90도 회전) 부터 차례대로 갈 곳을 정한다.
 * 2. 캐릭터의 바로 왼쪽 방향에 아직 가보지 않은 칸이 존재한다면, 왼쪽 방향으로 회전한 다음 왼쪽으로 한 칸 전진한다.
 * 왼쪽 방향에 가보지 않은 칸이 없다면, 왼쪽 방향으로 회전문 수행하고 1단계로 돌아간다.
 * 3. 만약 네 방향 모두 이미 가본 칸이거나 바다로 되어있는 칸인 경우에는, 바라보는 방향을 유지한 채로 한 칸 뒤로가고 1단계로 돌아간다.
 * 단, 이때 뒤쪽 방향이 바다인 칸이라 뒤로 갈 수 없다면 움직임을 멈춘다.
 *
 * 전형적인 시뮬레이션 문제
 */
public class 동빈나_게임개발 {
    // 0: 북, 1: 동, 2: 남 3: 서
    static int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] visit = new boolean[n][m];
        // 2차원 배열의 각 행을 개별적으로 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit[i], false);
        }

        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]); // x 좌표
        int y = Integer.parseInt(input[1]); // y 좌표
        int pos = Integer.parseInt(input[2]); // 바라보는 방향

        // 육지,바다 정보가 있는 맵 입력
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        visit[x][y] = true; // 처음 입력받은 좌표는 방문했다고 기록
        while(true) {
            int tempPos = pos;
            boolean step = false;
            for(int i = 1; i <= 4; i++) { // 모든 방향을 보도록
                if(pos - i < 0) tempPos = 4 - Math.abs(pos-i);
                else tempPos = pos - i;

                if((0 <= x + dir[tempPos][0] && x + dir[tempPos][0] < n) && (0 <= y + dir[tempPos][1] && y + dir[tempPos][1] < m)) { // 좌표안에 포함되어야만
                    int newX = x + dir[tempPos][0];
                    int newY = y + dir[tempPos][1];
                    if (!visit[newX][newY] && map[newX][newY] != 1) { // 방문하지 않았고 바다가 아닌경우에만
                        x = newX;
                        y = newY;
                        visit[x][y] = true;
                        step = true;
                        pos = tempPos; // 현재 움직인 방향으로 방향을 바꿔줌
                        break;
                    }
                }
            }

            if(!step) { // 아무데도 전진할 곳이 없었다면 바라보는 방향을 유지하고 뒤로 한칸
                int posX = (pos+2) % 4;
                int tempX = x + dir[posX][0];
                int tempY = y + dir[posX][1];
                if(map[tempX][tempY] != 1){ // 바다가 아닌 경우에만 뒤로 한칸
                    x = tempX;
                    y = tempY;
                    visit[x][y] = true;
                }
                else break; // 바다라면 어디상 갈데가 없는 것이므로 break;
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visit[i][j]) cnt++;
            }
        }

        System.out.println(cnt);
    }
}

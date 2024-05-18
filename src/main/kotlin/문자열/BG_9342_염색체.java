package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BG_9342_염색체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            char[] str = br.readLine().toCharArray();
            for(int i = 0; i < str.length; i++) {
                if(i == 0) {
                    // 첫번째 문자는 {A, B, C, D, E, F} 중 0개 또는 1개로 시작해야 한다.
                    if(!(65 <= str[0] && str[0] <= 70)) { // 범위 밖의 알파벳이라면 Good
                        sb.append("Good").append("\n");
                        break;
                    }

                    if(str[0] >= 66 && str[0] <= 70) {
                        continue;
                    }
                }

                if(str[i] == 'A') { // 두번째 문자는 A 가 하나 또는 그 이상 있어야한다.
                    while (true) {
                        if (str[i] != 'A') break; // A 가 아닐 때 까지 연산자를 더한다.
                        if (str.length > i + 1) i++; // 총 길이보다 작을때만 i를 증가시킨다.
                    }
                } else {
                    sb.append("Good").append("\n");
                    break;
                }

                if(str[i] != 'F') {
                    sb.append("Good").append("\n");
                    break;
                } else {
                    while(true) {
                        if(str[i] != 'F') break; // F 가 아닐 때 까지 연산자를 더한다.
                        if(str.length > i+1) i++; // 총 길이보다 작을때만 i를 증가시킨다.
                    }
                }

                if(str[i] != 'C') {
                    sb.append("Good").append("\n");
                    break;
                } else {
                    while(true) {
                        if(str[i] != 'C') break; // C 가 아닐 때 까지 연산자를 더한다.
                        if(str.length > i+1) i++; // 총 길이보다 작을때만 i를 증가시킨다.
                        else break;
                    }
                }

                // 그 다음에는 {A, B, C, D, E, F} 중 0개 또는 1개가 있으며, 더 이상의 문자는 없어야 한다.
                if((71 <= str[i] && str[i] <= 90) || i+1 != str.length) { // 범위 밖의 알파벳이거나 뒤에 문자가 더 존재한다면
                    sb.append("Good").append("\n");
                    break;
                }

                sb.append("Infected!").append("\n");
            }
        }

        System.out.println(sb);
    }
}

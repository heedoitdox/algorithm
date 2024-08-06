package 정규표현식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 9996 한국이그리울때
 * https://www.acmicpc.net/problem/9996
 */
public class BG_9996_한국이그리울때 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();		//패턴
        String[] pArr = pattern.split("\\*");	//*을 기준으로 두개의 문자열로 나누기 (*로 나누려면 역슬래쉬 2개 붙여줘야함)

        for (int i = 0; i < N; i++) {
            String str = br.readLine();		//검증할 파일 이름
            //*을 뺀 패턴 문자열보다 검증할 파일 이름 길이가 짧으면 검증이 안됨
            if (pArr[0].length() + pArr[1].length() > str.length()) {
                System.out.println("NE");
                continue;
            }

            String front = str.substring(0, pArr[0].length());	//파일이름 앞부분
            String back = str.substring(str.length()-pArr[1].length(), str.length());	//파일이름 뒷부분

            if (front.equals(pArr[0]) && back.equals(pArr[1])) {	//앞, 뒤 모두 패턴과 같다면 일치
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}

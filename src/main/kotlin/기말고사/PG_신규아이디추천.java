package 기말고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PG_신규아이디추천 {
    public static void main(String[] args) throws IOException {
        // 1단계 모든 대문자를 소문자로 치환
        // 2단계 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자 제거
        // 3단계 .가 두번이상 연속된 부분이 있다면 하나의 마침표로 치환
        // 4단계 마침표가 아이디의 처음이나 끝에 위치하면 제거
        // 5단계 빈 문자열이라면 a 를 대입함
        // 6단계 16자 이상이면 첫 15개의 문자를 제외한 나머지 문자들을 제거. 제거 후 마침표가 끝에 위치하면 끝에 위치한 마침표 제거
        // 7단계 길이가 2자 이하라면 마지막 문자를 길이가 3이 될때까지 반복해서 붙임

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();

        // 1단계 모든 대문자를 소문자로 치환
        String lowerString = s.toLowerCase();
        // 2단계 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자 제거
        String removeString = lowerString.replaceAll("[^a-z0-9_.-]", "");
        // 3단계 마침표가 2개 이상이라면 하나의 마침표로 치환
        String level3String = removeString.replaceAll("\\.+", ".");
        // 4단계 마침표가 맨처음 또는 맨 끝이라면 제거
        String level4String = level3String.replaceAll("^\\.|\\.$", "");
        // 5단계 빈 문자열이라면 a 를 대입
        if(level4String.isEmpty()) {
            level4String = "a";
        }
        // 6단계 16자 이상이면 15개 이후의 문자들을 제거
        String level6String = level4String.substring(0, Math.min(level4String.length(), 15));
        // 마지막 문자가 마침표라면 제거
        String result = level6String.replaceAll("^\\.$", "");
        // 7단계 길이가 2자 이하라면 마지막 문자를 길이가 3이 될 때까지 반복해서 붙임
        if(result.length() <= 2) {
            while(result.length() < 3) {
                result += result.charAt(result.length() - 1);
            }
        }

        System.out.println(result);
    }
}

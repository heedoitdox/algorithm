package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BG_10798_세로읽기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[5];

        for(int i = 0; i<5; i++) {
            str[i] = br.readLine();
        }

        for(int i = 0; i< 15; i++) {
            for(int j = 0; j < 5; j++) {
                if(i < str[j].length()) {
                    System.out.print(str[j].charAt(i));
                }
            }
        }
    }
}

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[][] array = {
//                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
//                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
//                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
//                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
//                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
//        };
//
//        for(int i = 0; i < 5; i++) {
//            String[] str = br.readLine().split("");
//
//            for(int j = 0; j < str.length; j++) {
//                array[i][j] = str[j];
//            }
//        }
//
//        for(int i = 0; i< 15; i++){
//            for(int j = 0; j< 5; j++) {
//                if(!array[j][i].equals("-1")) {
//                    System.out.print(array[j][i]);
//                }
//            }
//        }
//    }

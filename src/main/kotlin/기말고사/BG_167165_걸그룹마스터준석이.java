package 기말고사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BG_167165_걸그룹마스터준석이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 각 걸그룹마다 팀의 이름, 걸그룹의 인원 수, 멤버의 이름을 한 줄 씩 차례대로 입력한다.
        // 팀과 멤버의 이름은 최대 100글자, 모든 글자는 알파벳 소문자
        // 하나의 걸그룹이나 서로다른 두 걸그룹에 이름이 같은 두 멤버가 있는 경우는 없다.

        // 그 다음부터는 M 개의 퀴즈를 입력받는다. 각각의 퀴즈는 두줄로 이루어져 있으며 팀의 이름이나 멤버의 이름이 첫줄에 주어지고
        // 퀴즈의 종류를 나타내는 0 또는 1이 두번째 줄에 주어진다.
        // 퀴즈의 종류가 0일 경우 팀의 이름이 주어지며, 1일경우 멤버의 이름이 주어진다.
        // 퀴즈의 종류가 0일 경우 해당 팀에 속한 멤버의 이름을 사전순으로 한줄에 한명씩 출력한다.
        // 퀴즈의 종류가 1일경우 해당 멤버가 속한 팀의 이름을 출력한다.

        // n 개의 멤버 정보를 입력받는다.
        HashMap<String, String[]> teams = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String teamName = br.readLine();
            int memberCnt = Integer.parseInt(br.readLine());
            String[] members = new String[memberCnt];
            for(int j = 0; j < memberCnt; j++) {
                members[j] = br.readLine();
            }
            Arrays.sort(members);
            teams.put(teamName, members);
        }

        StringBuilder sb = new StringBuilder();
        // m 개의 퀴즈를 입력받는다.
        for(int i = 0; i < m; i++) {
            String input = br.readLine();
            if(br.readLine().equals("0")) { // 팀에 속한 멤버의 이름을 사전순으로 출력
                if(teams.containsKey(input)) {
                    for(String memberName: teams.get(input)) {
                        sb.append(memberName).append("\n");
                    }
                }
            } else { // 1 인경우는 멤버가 속한 팀의 이름을 출력
                for(Map.Entry<String, String[]> map : teams.entrySet()) {
                    Optional<String> result = Arrays.stream(map.getValue()).filter(it -> it.equals(input)).findFirst();
                    if(result.isPresent()) {
                        sb.append(map.getKey()).append("\n");
                    }
                }
            }
        }

        System.out.println(sb);
    }
}

package day09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Q_28114 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /*
      - 문제의 개수와 성씨를 담을 Map
      - TreeMap : Key 값을 자동으로 오름차순 정렬
     */
    TreeMap<Integer, String> map = new TreeMap<>();
    // 입학년도를 담을 배열
    int[] years = new int[3];

    for (int i = 0; i < 3; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      // 푼 문제의 개수
      int p = Integer.parseInt(st.nextToken());
      // 입학년도 (끝에 두 자리만 필요하므로 % 100)
      years[i] = Integer.parseInt(st.nextToken()) % 100;
      // 성씨
      String name = st.nextToken();

      map.put(p, name);
    }

    br.close();

    // 입학년도 오름차순 정렬
    Arrays.sort(years);

    StringBuilder sb = new StringBuilder();
    String year = "";

    // 첫 번째 줄에 출력할 입학년도로 만든 팀 이름
    for (int i = 0; i < 3; i++) {
      sb.append(years[i]);
      year = sb.toString();
    }

    sb = new StringBuilder();
    // 두 번째 줄에 출력할 성씨로 만든 팀 이름
    for (String name : map.values()) {
      sb.append(name.charAt(0));
    }
    // 문제를 많이 푼 성씨 순서대로 출력해야 하므로 reverse
    String team = sb.reverse().toString();
    bw.write(year + "\n" + team);

    bw.flush();
    bw.close();
  }
}

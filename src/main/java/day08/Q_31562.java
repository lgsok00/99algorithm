package day08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q_31562 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    // 음을 아는 노래의 개수
    int n = Integer.parseInt(st.nextToken());
    // 맞히기를 시도할 노래의 개수
    int m = Integer.parseInt(st.nextToken());

    // 세 음과 노래 제목을 담는 HashMap
    HashMap<String, String> songInfo = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      // 노래 제목
      String title = input[1];
      // 첫 세 음계
      String note = input[2] + " " + input[3] + " " + input[4];

      // 노래 제목과 첫 세 음계를 HashMap에 저장
      songInfo.put(title, note);
    }

    for (int i = 0; i < m; i++) {
      String checkNote = br.readLine();
      int count = 0;
      String title = "";

      // songInfo 의 key/value 쌍을 Entry 에 저장
      for (Map.Entry<String, String> entry : songInfo.entrySet()) {
        // checkNote 가 Entry 에 존재한다면
        if (checkNote.equals(entry.getValue())) {
          count++;
          // 노래 제목 저장
          title = entry.getKey();
        }
      }

      if (count == 0) {
        bw.write("!\n");
      } else if (count == 1) {
        bw.write(title + "\n");
      } else {
        bw.write("?\n");
      }
    }

    br.close();
    bw.flush();
    bw.close();
  }
}

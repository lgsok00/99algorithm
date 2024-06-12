package day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q_10419 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 테스트 케이스 수
    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      // 수업 시간
      int d = Integer.parseInt(br.readLine());

      int maxLateTime = 1;

      // 지각시간 + 일찍 끝나는 시간 <= 수업 시간 을 만족하는 동안 반복
      while (maxLateTime + (maxLateTime * maxLateTime) <= d) {
        maxLateTime++;
      }

      // 해당 조건을 벗어나기 전에 maxLateTime 먼저 증가하므로 - 1
      bw.write((maxLateTime - 1) + "\n");

    }

    br.close();
    bw.flush();
    bw.close();
  }
}

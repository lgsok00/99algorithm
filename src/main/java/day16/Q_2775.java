package day16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q_2775 {

  // 0 ~ 14 층, 1 ~ 14 호 담을 배열
  public static int[][] apt = new int[15][15];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 15; i++) {
      // 각 층의 1 호
      apt[i][1] = 1;
      // 0 층의 i 호
      apt[0][i] = i;
    }

    // 1 층 ~ 14 층
    for (int i = 1; i < 15; i++) {
      // 2 호 ~ 14 호
      for (int j = 2; j < 15; j++) {
        // 같은 층의 직전 호 수 + 밑의 층의 호 수
        apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
      }
    }

    // 테스트 케이스 수
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      // 층
      int k = Integer.parseInt(br.readLine());
      // 호
      int n = Integer.parseInt(br.readLine());
      sb.append(apt[k][n]).append("\n");
    }

    bw.write(sb.toString());

    br.close();
    bw.flush();
    bw.close();
  }
}

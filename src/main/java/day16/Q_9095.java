package day16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  - 다이나믹 프로그래밍 활용
  - 점화식 : dp[n] = dp[n - 1] + dp[n- 2] + dp[n - 3]
 */
public class Q_9095 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 테스트 케이스 개수
    int t = Integer.parseInt(br.readLine());

    int[] dp = new int[11];

    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());

      dp[1] = 1;
      dp[2] = 2;
      dp[3] = 4;

      for (int j = 4; j <= n; j++) {
        // 점화식 활용
        dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
      }

      bw.write(dp[n] + "\n");
    }

    br.close();
    bw.flush();
    bw.close();
  }
}

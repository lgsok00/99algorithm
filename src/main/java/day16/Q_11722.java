package day16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_11722 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 수열의 크기
    int n = Integer.parseInt(br.readLine());
    // 수열을 담을 배열
    int[] arr = new int[n];
    int[] dp = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    dp[0] = 1;
    for (int i = 1; i < n; i++) {
      int max = 0;
      for (int j = 0; j < i; j++) {
        if (arr[i] < arr[j]) {
          max = Math.max(dp[j], max);
        }
      }
      dp[i] = max + 1;
    }

    Arrays.sort(dp);

    bw.write(dp[n - 1] + "\n");

    br.close();
    bw.flush();
    bw.close();
  }
}

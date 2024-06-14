package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1946 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      int[] rank = new int[n + 1];

      for (int j = 0; j < n; j++) {
        String[] str = br.readLine().split(" ");

        int documentRank = Integer.parseInt(str[0]);
        int interviewRank = Integer.parseInt(str[1]);

        rank[documentRank] = interviewRank;
      }

      int answer = 1;
      int standard = rank[1];

      for (int k = 2; k <= n; k++) {
        if (rank[k] < standard) {
          answer++;
          standard = rank[k];
        }
      }

      System.out.println(answer);
    }
  }
}

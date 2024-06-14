package day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_11047 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] coin = new int[n];

    for (int i = 0; i < n; i++) {
      coin[i] = Integer.parseInt(br.readLine());
    }

    int count = 0;

    // 큰 값부터 비교해야 하므로
    for (int i = n - 1; i >= 0; i--) {
      if (coin[i] > k) {
        continue;
      }

      count += (k / coin[i]);
      k = k % coin[i];
    }

    System.out.println(count);
  }
}

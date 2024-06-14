package day15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q_14659 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 봉우리의 수(활잡이의 수)
    int n = Integer.parseInt(br.readLine());
    int[] height = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      height[i] = Integer.parseInt(st.nextToken());
    }

    int answer = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      int count = 0;
      int currentHeight = height[i];
      for (int j = i + 1; j < n; j++) {
        // 현재 봉우리보다 더 높은 봉우리를 만나면
        if (currentHeight < height[j]) {
          break;
        } else {
          count++;
        }
      }
      answer = Math.max(answer, count);
    }

    bw.write(answer + "\n");

    br.close();
    bw.flush();
    bw.close();
  }
}

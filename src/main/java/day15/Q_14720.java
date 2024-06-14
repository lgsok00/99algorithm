package day15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q_14720 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 우유 가게의 수
    int n = Integer.parseInt(br.readLine());

    int[] milkStore = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      milkStore[i] = Integer.parseInt(st.nextToken());
    }

    int count = 0;
    // 맨 처음에는 딸기 우유 가게를 가므로
    int start = 0;

    for (int i = 0; i < n; i++) {
      if (milkStore[i] == start) {
        count++;
        start++;

        if (start == 3) {
          start = 0;
        }
      }
    }

    bw.write(count + "\n");

    br.close();
    bw.flush();
    bw.close();
  }
}

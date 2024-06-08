package day10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q_28417 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 사람의 수
    int n = Integer.parseInt(br.readLine());
    int winner = 0;

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int run1 = Integer.parseInt(st.nextToken());
      int run2 = Integer.parseInt(st.nextToken());

      // 우선순위 큐에 내림차순으로 정렬
      PriorityQueue<Integer> trick = new PriorityQueue<>(Collections.reverseOrder());

      for (int j = 0; j < 5; j++) {
        trick.add(Integer.parseInt(st.nextToken()));
      }

      int highRun = Math.max(run1, run2);
      int highTrick1 = trick.poll();
      int highTrick2 = trick.poll();

      int total = highRun + highTrick1 + highTrick2;

      if (total > winner) {
        winner = total;
      }
    }
    br.close();

    bw.write(winner + "\n");
    bw.flush();
    br.close();
  }
}

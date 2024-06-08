package day10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

/*
  - 다솜이를 제외한 후보자들의 투표수를 우선순위 큐에 내림차순으로 정렬한다.
  - 투표수가 높은 후보자의 투표수를 하나씩 다솜이한테 옮긴다.
 */
public class Q_1417 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 후보자의 수
    int n = Integer.parseInt(br.readLine());
    // 다솜이의 투표 수
    int m = Integer.parseInt(br.readLine());

    int answer = 0;

    // 다른 후보자 투표수 내림차순
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 1; i < n; i++) {
      pq.add(Integer.parseInt(br.readLine()));
    }

    br.close();

    // 다른 후보자의 투표수가 다솜이 보다 많을 때
    while (!pq.isEmpty() && m <= pq.peek()) {
      m++;
      answer++;
      pq.add(pq.poll() - 1);
    }

    bw.write(answer + "\n");

    bw.flush();
    bw.close();
  }
}

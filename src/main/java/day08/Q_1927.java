package day08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/*
  - 우선순위 큐를 만들고 수를 입력받는다.
  - 입력받은 수가 0 보다 큰 자연수라면 큐에 추가하고,
  - 0 일 때
    - 큐가 비어있지 않다면 가장 작은 값을 출력하고 제거
    - 큐가 비어있다면 0 출력
 */
public class Q_1927 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    // 우선순위 큐
    PriorityQueue<Integer> minQueue = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      int input = Integer.parseInt(br.readLine());
      // 자연수일 때
      if (input > 0) {
        minQueue.add(input);
        // 0 일 때, 큐가 비어있다면
      } else if (!minQueue.isEmpty()) {
        bw.write(minQueue.poll() + "\n");
      } else {
        bw.write("0\n");
      }
    }

    br.close();
    bw.flush();
    bw.close();
  }
}

package day12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q_13975 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 테스트 케이스 개수
    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      // 소설 장 수
      int k = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());

      // 우선순위 큐에 파일 사이즈를 오름차순으로 넣어 작은 값끼리 더한다.
      PriorityQueue<Long> pq = new PriorityQueue<>();

      for (int j = 0; j < k; j++) {
        pq.offer(Long.parseLong(st.nextToken()));
      }

      long answer = 0;

      while (!pq.isEmpty()) {
        if (pq.size() == 1) {
          break;
        }

        // 작은 값 두 개를 더한다.
        long sum = pq.poll() + pq.poll();
        answer += sum;
        pq.offer(sum);
      }
      bw.write(answer + "\n");
    }

    br.close();
    bw.flush();
    bw.close();
  }
}

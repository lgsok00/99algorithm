package day09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
  - 소비한 술의 양과 학교명을 HashMap 에 저장하고,
  - 소비한 술의 양을 PriorityQueue 에 저장한다. (내림차순으로)
  - PriorityQueue 에서 poll을 통해 가장 큰 소비량을 찾고, 이 값을 키 값으로 가지는 학교명을 HashMap 에서 찾아 출력한다.
 */
public class Q_11557 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 테스트 케이스 수
    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      HashMap<Long, String> map = new HashMap<>();

      // 가장 큰 값이 우선 순위를 가짐
      PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
      // 학교의 숫자
      int n = Integer.parseInt(br.readLine());
      for (int j = 0; j < n; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        long l = Long.parseLong(st.nextToken());

        pq.add(l);
        map.put(l, s);
      }
      bw.write(map.get(pq.poll()) + "\n");
    }

    br.close();
    bw.flush();
    bw.close();
  }
}

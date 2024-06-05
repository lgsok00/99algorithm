package day07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
  - 인덱스를 저장할 큐와 중요도를 저장할 배열을 선언한다.
  - 현재 문서보다 높은 중요도를 가진 문서가 있는지 확인하고,
  - 있을 경우 큐의 뒤로 보낸다.
  - 없을 경우 count 를 증가시키고, 중요도를 0 으로 만들어 비교 대상에서 제외시킨다.
 */
public class Q_1966 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      // 문서의 수
      int n = Integer.parseInt(st.nextToken());
      // 추척할 문서의 위치
      int m = Integer.parseInt(st.nextToken());

      // 인덱스를 저장할 큐
      Queue<Integer> queue = new LinkedList<>();
      // 중요도를 저장할 배열
      int[] importances = new int[n];

      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < n; j++) {
        int importance = Integer.parseInt(st.nextToken());  // 각 문서의 중요도
        importances[j] = importance;
        queue.add(j);
      }

      // 프린트 횟수
      int count = 0;

      while(!queue.isEmpty()) {
        boolean check = false;
        // 첫번째 문서
        int current = queue.poll();

        // 전체 문서의 중요도를 순회
        for (int j : importances) {
          // 현재 문서보다 높은 중요도를 가진 문서가 있다면
          if (importances[current] < j) {
            queue.add(current);
            check = true;
            break;
          }
        }

        // 더 높은 중요도의 문서가 없다면
        if (!check) {
          count++;
          // 현재 문서의 중요도 = 0 (프린트 완료)
          importances[current] = 0;
          if (current == m) {
            bw.write((count) + "\n");
            break;
          }
        }
      }
    }

    br.close();
    bw.flush();
    bw.close();
  }
}

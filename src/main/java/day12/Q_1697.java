package day12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_1697 {

  static int n;
  static int k;
  static int[] visited = new int[100001];

  static BufferedReader br;
  static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    // 수빈이의 위치
    n = Integer.parseInt(st.nextToken());
    // 동생의 위치
    k = Integer.parseInt(st.nextToken());

    br.close();

    if (n == k) {
      bw.write(0 + "\n");
    } else {
      bfs(n);
    }

    bw.flush();
    bw.close();
  }

  private static void bfs(int n) throws IOException {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(n);
    // 처음 위치한 곳을 1 로 초기화
    visited[n] = 1;

    while (!queue.isEmpty()) {
      int current = queue.poll();

      // 이동할 수 있는 3 가지 경우를 구한다.
      for (int i = 0; i < 3; i++) {
        int next;
        if (i == 0) {
          next = current + 1;
        } else if (i == 1) {
          next = current - 1;
        } else {
          next = current * 2;
        }

        // 동생의 위치에 도달했다면
        if (next == k) {
          bw.write(visited[current] + "\n");
          bw.flush();
          return;
        }

        // 다음 이동할 칸이 배열의 범위 안에 있고, 방문한 적이 없다면
        if (next >= 0 && next < visited.length && visited[next] == 0) {
          queue.add(next);
          visited[next] = visited[current] + 1;
        }
      }
    }
  }
}

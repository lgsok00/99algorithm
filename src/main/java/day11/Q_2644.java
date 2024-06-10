package day11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q_2644 {

  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static boolean[] visited;
  static int answer = -1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 전체 사람의 수
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    visited = new boolean[n + 1];

    // 부모-자식 관계 개수
    int m = Integer.parseInt(br.readLine());

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      // 무 방향성 그래프
      graph.get(x).add(y);
      graph.get(y).add(x);
    }

    br.close();

    dfs(start, end, 0);

    bw.write(answer + "\n");

    bw.flush();
    bw.close();
  }

  // DFS
  private static void dfs(int start, int end, int count) {
    visited[start] = true;

    for (int num : graph.get(start)) {
      if (!visited[num]) {
        // 목적지에 도달했으면
        if (num == end) {
          answer = count + 1;
          return;
        }
        // 다음 촌수로 이동
        dfs(num, end, count + 1);
      }
    }
  }
}

package day11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q_24479 {

  // 그래프 저장
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static int[] visited;
  // 탐색 순서
  static int count = 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    // 정점의 수
    int n = Integer.parseInt(st.nextToken());
    // 간선의 수
    int m = Integer.parseInt(st.nextToken());
    // 시작 정점
    int r = Integer.parseInt(st.nextToken());

    visited = new int[n + 1];

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      // 무방향 그래프
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    br.close();

    // 오름차순 정렬
    for (int i = 0; i < graph.size(); i++) {
      Collections.sort(graph.get(i));
    }

    dfs(r);

    for (int i = 1; i < visited.length; i++) {
      bw.write(visited[i] + "\n");
    }

    bw.flush();
    bw.close();
  }

  private static void dfs(int start) {
    visited[start] = count;

    for (int i = 0; i < graph.get(start).size(); i++) {
      int v = graph.get(start).get(i);
      if (visited[v] == 0) {
        count++;
        dfs(v);
      }
    }
  }
}

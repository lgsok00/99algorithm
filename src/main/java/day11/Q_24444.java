package day11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_24444 {

  // 그래프를 저장하기 위한 이중리스트
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  // 방문 유무 저장
  static boolean[] visited;
  // 방문 순서 저장
  static int[] result;

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

    result = new int[n + 1];

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      // 무 방향성 그래프
      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    br.close();

    // 오름차순 정렬
    for (int i = 1; i <= n; i++) {
      Collections.sort(graph.get(i));
    }

    bfs(r, n);

    for (int i = 1; i <= n; i++) {
      bw.write(result[i] + "\n");
    }

    bw.flush();
    bw.close();
  }

  private static void bfs(int start, int n) {
    // 방문 순서 기록
    int count = 1;
    visited = new boolean[n + 1];

    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited[start] = true;
    result[start] = count++;

    while (!queue.isEmpty()) {
      // 현재 정점
      int vertex = queue.poll();

      // 현재 정점 vertex 에서 인접한 모든 정점 순회
      for (int num : graph.get(vertex)) {
        if (!visited[num]) {
          queue.add(num);
          visited[num] = true;
          result[num] = count++;
        }
      }
    }
  }
}

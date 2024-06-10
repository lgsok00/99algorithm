package day11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DFS_BFS {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int[][] graph = new int[n + 1][n + 1];
    // 방문 리스트
    boolean[] visited = new boolean[n + 1];

    int k = in.nextInt();

    for (int i = 0; i < k; i++) {
      int x = in.nextInt();
      int y = in.nextInt();

      graph[x][y] = 1;
      graph[y][x] = 1;

      dfs(graph, visited, n);
      bfs(graph, visited, n);
    }
  }

  public static void dfs(int[][] graph, boolean[] visited, int start) {

    Stack<Integer> stack = new Stack<>();
    stack.push(start);
    // 시작 정점을 방문했다고 표시
    visited[start] = true;
    // 시작 정점 출력
    System.out.println(start);

    while (!stack.isEmpty()) {
      int vertex = stack.pop();

      for (int i = 1; i < graph.length; i++) {
        // 인접하고 아직 방문하지 않은 정점이 있다면
        if (graph[vertex][i] == 1 && !visited[i]) {
          stack.push(i);
          visited[i] = true;
          System.out.println(i);
        }
      }
    }
  }

  public static void bfs(int[][] graph, boolean[] visited, int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    visited[start] = true; // 시작 정점을 방문했다고 표시
    System.out.println(start);

    while (!queue.isEmpty()) {
      int vertex = queue.poll();

      // 현재 정점과 인접한 모든 정점을 확인
      for (int i = 1; i < graph.length; i++) {
        // 인접하고 아직 방문하지 않은 정점이 있다면
        if (graph[vertex][i] == 1 && !visited[i]) {
          visited[i] = true; // 해당 정점을 방문했다고 표시
          queue.offer(i); // 큐에 추가
          System.out.println(i);
        }
      }
    }
  }
}

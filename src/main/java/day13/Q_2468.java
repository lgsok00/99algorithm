package day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
  - 높이(h) : 1 ~ n
  - h = n => 안전한 구역 0개
  - DFS 시간 복잡도 : O(N^2) * n (높이) => O(n^3)
 */
public class Q_2468 {

  static int n;
  static int[][] matrix;
  static boolean[][] visited;

  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, -1, 0, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    matrix = new int[n + 1][n + 1];

    StringTokenizer st;

    int maxHeight = 0;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
        // 최대 높이 구하기
        maxHeight = Math.max(maxHeight, matrix[i][j]);
      }
    }

    int answer = 0;

    for (int h = 0; h < maxHeight; h++) {
      visited = new boolean[n + 1][n + 1];
      int count = 0;  // 현재 높이에서 안전 영역의 개수

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          // 특정 좌표에서 안전 영역 확인
          if (!visited[i][j] && matrix[i][j] > h) {
            dfs(i, j, h);
            count++;
          }
        }
      }
      answer = Math.max(answer, count);
    }
    System.out.println(answer);
  }

  private static void dfs(int x, int y, int h) {
    Stack<int[]> stack = new Stack<>();
    stack.push(new int[]{x, y});
    visited[x][y] = true;

    while (!stack.isEmpty()) {
      int[] now = stack.pop();

      for (int i = 0; i < 4; i++) {
        int nx = now[0] + dx[i];
        int ny = now[1] + dy[i];

        // 좌표의 범위 판단
        if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
          continue;
        }

        // 방문한 좌표이면
        if (visited[nx][ny]) {
          continue;
        }

        // 새로운 지점의 높이가 물높이 보다 높은 경우
        if (matrix[nx][ny] > h) {
          visited[nx][ny] = true;
          stack.push(new int[]{nx, ny});
        }
      }
    }
  }
}

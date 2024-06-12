package day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  - 브루트 포스 적용 (시간 복잡도 고려)
 */
public class Q_14889 {

  static int[][] matrix;
  static int n, answer;
  static boolean[] visited;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    matrix = new int[n][n];
    visited = new boolean[n];
    answer = Integer.MAX_VALUE;  // 최소값을 비교할 때는 가장 큰 값으로 초기화

    StringTokenizer st;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      // 행렬에 값 넣기
      for (int j = 0; j < n; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    combination(0, n / 2);

    System.out.println(answer);
  }

  private static void combination(
          int start,  // 시작 위치
          int r
  ) {
    if (r == 0) {
      // update answer by calculate();
      answer = Math.min(answer, calculate());
      return;
    }

    for (int i = start; i < n; i++) {
      visited[i] = true;
      combination(i + 1, r - 1);
      visited[i] = false;
    }
  }

  private static int calculate() {
    int startTeam = 0;
    int linkTeam = 0;

    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        // 조합에 해당되는 값이면
        if (visited[i] && visited[j]) {
          startTeam += matrix[i][j];
          startTeam += matrix[j][i];
        }

        if (!visited[i] && !visited[j]) {
          linkTeam += matrix[i][j];
          linkTeam += matrix[j][i];
        }
      }
    }
    return Math.abs(startTeam - linkTeam);
  }
}

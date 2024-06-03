package day05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
  - 입력 받은 행렬을 기준으로 가장 큰 정사각형 사이즈를 찾는다.
  - 큰 정사각형부터 순회하며 꼭짓점 값이 모두 같은 경우를 찾는다.
 */
public class Q_1051 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] arr = new int[n][m];
    // 정사격형 최대 사이즈
    int size = Math.min(n, m);

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < m; j++) {
        arr[i][j] = str.charAt(j) - '0';
      }
    }

    br.close();

    while (size > 1) {
      // 제일 큰 정사각형 사이즈부터 순회
      for(int i = 0; i <= n - size; i++) {
        for (int j = 0; j <= m - size; j++) {
          int num = arr[i][j];
          // 기준 꼭짓점 num 과 나머지 세 개의 꼭짓점이 같은지 비교
          if (num == arr[i][j + size - 1] && num == arr[i + size - 1][j] && num == arr[i + size - 1][j + size - 1]) {
            bw.write(String.valueOf(size * size));
            bw.flush();
            bw.close();
            return;
          }
        }
      }
      size--;
    }
    bw.write(String.valueOf(size * size));
    bw.flush();
    bw.close();
  }
}

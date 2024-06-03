package day05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
  - 9 x 9 행렬을 입력받는다.
  - 입력 받은 행렬에서 최대값을 찾고,
  - 최댓값이 위치한 행과 열 번호를 출력한다.
 */
public class Q_2556 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[][] arr = new int[9][9];
    int max = 0;
    int row = 0;  // 행의 위치
    int col = 0;  // 열의 위치

    for (int i = 0; i < 9; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        // max 값 찾기 위한 조건문
        if (arr[i][j] > max) {
          max = arr[i][j];
          row = i + 1;
          col = j + 1;
          // 행렬의 값이 모두 0 일 때
        } else if (max == 0) {
          row = 1;
          col = 1;
        }
      }
    }
    bw.write(max + "\n");
    bw.write(row + " " + col);

    br.close();
    bw.flush();
    bw.close();
  }
}

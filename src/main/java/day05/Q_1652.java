package day05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  - n x n 크기의 배열에 방 구조를 입력받는다.
    - (.) : 짐이 없는 곳
    - (X) : 짐이 있는 곳
  - 한 행에 (.) 이 두 개이상 붙어있으면 row를 증가시킨다.
  - 한 열에 (.) 이 두 개이상 붙어있으면 col을 증가시킨다.
  - 중간에 (X) 가 껴 있을 상황도 고려해야 한다.
 */
public class Q_1652 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    char[][] arr = new char[n][n];

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < n; j++) {
        arr[i][j] = str.charAt(j);
      }
    }

    br.close();

    int cntX = 0;  // 가로로 누울 수 있는 자리
    int cntY = 0;  // 세로로 누울 수 있는 자리

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {

        if (arr[i][j] == '.') {
          // 배열의 길이 안에서 다음 위치가 누울 수 있는지 확인
          // 가로로 누울 수 있는지 확인
          if (j + 1 < n && arr[i][j + 1] == '.') {
            // 누울 수 있는 공간 다음 위치가 배열의 위치를 벗어나거나, (배열의 끝)
            // 범위 내에 있지만 벽인 경우
            if (j + 2 >= n || (j + 2 < n && arr[i][j + 2] == 'X')) {
              cntX++;
            }
          }

          // 세로로 누울 수 있는지 확인
          if (i + 1 < n && arr[i + 1][j] == '.') {
            if (i + 2 >= n || (i + 2 < n && arr[i + 2][j] == 'X')) {
              cntY++;
            }
          }
        }
      }
    }

    bw.write(cntX + " " + cntY + "\n");
    bw.flush();
    bw.close();
  }
}

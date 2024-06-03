package day05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  - 2차원 배열에 행렬을 입력한다.
    - 열의 최대 크기를 max 라는 변수에 저장
    - max 만큼 순회
  - 세로로 읽어서 출력해야 하기 때문에 열, 행 순서로 순회한다.
 */
public class Q_10798 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    char[][] arr = new char[5][15];
    int max = 0;

    for (int i = 0; i < arr.length; i++) {
      String str = br.readLine();
      // 행당 최대 길이 설정
      if (max < str.length()) {
        max = str.length();
      }
      for (int j = 0; j < str.length(); j++) {
        arr[i][j] = str.charAt(j);
      }
    }

    StringBuilder sb = new StringBuilder();
    // 세로로 출력해야 하기 때문에 열, 행 순으로 순회
    for (int i = 0; i < max; i++) {
      for (char[] chars : arr) {
        // 공백이면 통과
        if (chars[i] == '\0') {
          continue;
        }
        sb.append(chars[i]);
      }
    }
    bw.write(sb.toString());

    br.close();
    bw.flush();
    bw.close();
  }
}

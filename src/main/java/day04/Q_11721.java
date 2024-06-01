package day04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
  - 입력받은 문자열을 순회
  - 한번 순회 후 인덱스를 10 칸 이동
    - 남은 문자열의 길이가 10 이하이면 그 인덱스부터 끝까지 출력
 */
public class Q_11721 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String s = br.readLine();

    br.close();

    for (int i = 0; i < s.length(); i += 10) {
      // 남은 문자열의 길이가 10 보다 작을 때
      if (i + 10 >= s.length()) {
        bw.write(s.substring(i));
      } else {
        bw.write(s.substring(i, i + 10) + "\n");
      }
    }

    bw.flush();
    bw.close();
  }
}

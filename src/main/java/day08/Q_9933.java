package day08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

/*
  - 입력받은 비밀번호를 HashSet에 추가하고,
  - 비밀번호를 뒤집어서 뒤집은 비밀번호가 HashSet에 포함되어 있다면 출력
 */
public class Q_9933 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    /*
     - 비밀번호를 저장할 HashSet 선언
     - 중복 제거
     */
    HashSet<String> password = new HashSet<>();

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      password.add(s);

      StringBuilder sb = new StringBuilder(s);
      // 입력받은 문자열을 뒤집음
      String reverse = sb.reverse().toString();

      // 비밀번호 목록에 뒤집어진 문자열이 있다면
      if (password.contains(reverse)) {
        bw.write(reverse.length() + " " + reverse.charAt(reverse.length() / 2) + "\n");
        break;
      }
    }

    br.close();
    bw.flush();
    bw.close();
  }
}

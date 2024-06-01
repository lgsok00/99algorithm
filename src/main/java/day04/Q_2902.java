package day04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
  - 입력받은 문자열을 StringTokenizer 을 사용해서 "-" 를 기준으로 나눈다.
  - while 문을 돌면서 각 토큰의 첫 글자를 출력한다.
 */
public class Q_2902 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), "-");
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    br.close();
    while (st.hasMoreTokens()) {  // 사용할 수 있는 토큰이 있는지 확인
      bw.write(st.nextToken().charAt(0));
    }

    bw.flush();
    bw.close();
  }
}

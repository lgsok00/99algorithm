package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_2908 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 문자열을 공백으로 분리해 StringTokenizer 객체에 저장한다.
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");


    /*
      - StringBuilder 객체를 만든다.
        - nextToken : StringTokenizer 토큰을 하나 가져온다.
      - reverse : 만들어진 StringBuilder 객체를 뒤집는다.
      - toString : StringBuilder 객체를 문자열로 변환한다.
      - Integer.parseInt : 문자열을 정수로 변환한다.
     */
    int a = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
    int b = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());

    System.out.print(Math.max(a, b));
  }
}

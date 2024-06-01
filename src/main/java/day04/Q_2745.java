package day04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
  - n 값과 b 진법을 받는다.
  - 문자열 역순으로 인덱스를 돌면서 십진수로 변환한다.
 */
public class Q_2745 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    String n = st.nextToken();
    int b = Integer.parseInt(st.nextToken());

    br.close();

    int temp = 1;
    int sum = 0;

    // 일의 자리 부터 계산해야 하므로 역순으로 순회한다.
    for (int i = n.length() - 1; i >= 0 ; i--) {
      char c = n.charAt(i);
      // 0 ~ 9 가 아니면
      if ('A' <= c && c <= 'Z') {
        sum += (c - 'A' + 10) * temp;
      } else {
        sum += (c - '0') * temp;
      }
      // 자리 수에 곱하는 수 증가
      temp *= b;
    }

    bw.write(sum + "\n");
    bw.flush();
    bw.close();
  }
}

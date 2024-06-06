package day08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q_15829 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int l = Integer.parseInt(br.readLine());
    String str = br.readLine();

    br.close();

    long result = 0;
    long pow = 1;

    for (int i = 0; i < l; i++) {
      // 아스키코드 값에서 - 96 을 통해 인덱스 번호를 구한다.
      result += ((str.charAt(i) - 96) * pow);
      // pow 에 1234567891 을 나눠주면서 overflow 를 방지한다.
      pow = (pow * 31) % 1234567891;
    }

    bw.write(String.valueOf(result % 1234567891));
    bw.flush();
    bw.close();
  }
}

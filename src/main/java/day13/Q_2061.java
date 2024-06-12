package day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Q_2061 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 키 값 k 가 10^100 까지 이므로 BigInteger
    BigInteger k = new BigInteger(st.nextToken());
    // 정수 L
    int l = Integer.parseInt(st.nextToken());

    int badKey = 0;

    // L 이하의 소수가 존재하는지 판별하기 위한 루프
    for (int i = 2; i < l; i++) {
      // k 값을 i 로 나눈 나머지가 0 이라면
      if (k.remainder(BigInteger.valueOf(i)).compareTo(BigInteger.ZERO) == 0) {
        badKey = i;
        break;
      }
    }

    String answer = (badKey > 0) ? ("BAD " + badKey) : "GOOD";

    bw.write(answer);

    br.close();
    bw.flush();
    bw.close();
  }
}

package day03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  - i => 1 ~ n - 2
  - j => i + 1 ~ n - 1
  - k => j + 1 ~ n
  ex) i = 1, j = 2 => k = 3, 4, 5, 6, 7
  - j = i + 1 부터, k = j + 1 부터이므로 세 수는 중복될 수 없다.
  - 수학의 조합을 활용해 푼다.
    - nCr = n! / (n - r)! * r!
 */
public class Q_24267 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    long n = Integer.parseInt(br.readLine());

    br.close();

    bw.write(n * (n - 1) * (n - 2) / 6 + "\n" + 3);
    bw.flush();
    bw.close();
  }
}

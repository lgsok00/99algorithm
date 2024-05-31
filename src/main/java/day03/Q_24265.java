package day03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
  - i => 1 ~ n -1
  - j => i + 1 ~ n
  - 1 ~ n 까지의 합 => n (n + 1) / 2
  - 1 ~ n -1 까지의 합 => n (n - 1) / 2
  - 시간 복잡도 => O((n^2 - n) / 2) => O(n^2)
 */
public class Q_24265 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // n의 크기 (1 <= n <= 500,000)
    long n = Integer.parseInt(br.readLine());

    br.close();

    bw.write((n * (n - 1)) / 2 + "\n" + 2);
    bw.flush();
    bw.close();
  }
}

package day14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  - 청정수열의 값 최소가 되려면 두 개의 i 사이의 값이 없어야한다.
  - 따라서 순열의 개수만 구하면 된다.
 */
public class Q_25176 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int answer = 1;

    for (int i = 1; i <= n; i++) {
      answer *= i;
    }

    bw.write(answer + "\n");

    br.close();
    bw.flush();
    bw.close();
  }
}

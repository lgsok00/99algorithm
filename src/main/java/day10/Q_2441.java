package day10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q_2441 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    br.close();

    for (int i = 0; i < n; i++) {
      // 공백을 찍기 위한 for 문
      for (int j = 0; j < i; j++) {
        bw.write(" ");
      }
      // "*" 을 찍기 위한 for 문
      for (int j = 0; j < n - i; j++) {
        bw.write("*");
      }
      bw.write("\n");
    }

    bw.flush();
    bw.close();
  }
}

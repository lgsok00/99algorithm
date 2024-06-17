package day17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q_21313 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    // n = 짝수일 때
    if (n % 2 == 0) {
      for (int i = 0; i < (n / 2); i++) {
        sb.append("1 2 ");
      }
      // n = 홀수일 때
    } else if (n % 2 == 1) {
      for (int i = 0; i < (n / 2) + 1; i++) {
        if (i == (n / 2)) {
          sb.append("3");
        } else {
          sb.append("1 2 ");
        }
      }
    }

    br.close();
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }
}

package day07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q_7567 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    int sum = 10;

    br.close();

    // 이전 그릇과 같은 방향이라면 + 5
    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) == str.charAt(i - 1)) {
        sum += 5;
        // 반대 방향이라면 + 10
      } else {
        sum += 10;
      }
    }

    bw.write(String.valueOf(sum));
    bw.flush();
    bw.close();
  }
}

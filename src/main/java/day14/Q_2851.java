package day14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q_2851 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] mushroom = new int[10];

    for (int i = 0; i < 10; i++) {
      mushroom[i] = Integer.parseInt(br.readLine());
    }

    int score = 0;

    for (int i = 0; i < 10; i++) {
      score += mushroom[i];

      if (Math.abs((score - mushroom[i]) - 100) < score - 100) {
        score = score - mushroom[i];
        break;
      }
    }
    bw.write(score + "\n");

    br.close();
    bw.flush();
    bw.close();
  }
}

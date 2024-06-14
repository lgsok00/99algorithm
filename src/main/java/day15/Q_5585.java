package day15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q_5585 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int cost = Integer.parseInt(br.readLine());

    int[] coin = {500, 100, 50, 10, 5, 1};

    // 1000 원을 낸 후 거스름돈
    cost = 1000 - cost;

    int count = 0;
    // 제일 금액이 큰 잔돈부터 나눠준다.
    for (int i = 0; i < coin.length; i++) {
      // 거스름돈과 잔돈을 나눴을 때 0 보다 크다면
      if (cost / coin[i] > 0) {
        count += cost / coin[i];
        cost = cost % coin[i];
      }
    }

    bw.write(String.valueOf(count));

    br.close();
    bw.flush();
    bw.close();
  }
}

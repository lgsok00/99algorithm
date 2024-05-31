package day03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  - n 을 입력받아 n 번 반복
  - n 의 수 만큼 반복 횟수가 늘어나므로 시간 복잡도는 O(n)
 */
public class Q_24263 {

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    br.close();

    bw.write(n + "\n");
    bw.write("1");

    bw.flush();
    bw.close();
  }
}

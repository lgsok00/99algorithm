package day10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q_1292 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    br.close();

    int sum = 0;

    ArrayList<Integer> list = new ArrayList<>();

    // 1 ~ B
    for (int i = 1; i <= b; i++) {
      // i 를 i 번 만큼 반복
      for (int j = 1; j <= i; j++) {
        list.add(i);
      }
    }

    // 인덱스는 0 부터 시작하므로 - 1
    int index = a - 1;

    for (int i = 0; i <= list.size(); i++) {
      sum += list.get(index++);
      if (index == b) {
        break;
      }
    }

    bw.write(sum + "\n");
    bw.flush();
    bw.close();
  }
}

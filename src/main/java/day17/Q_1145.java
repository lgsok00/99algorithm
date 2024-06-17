package day17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q_1145 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] arr = new int[5];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 5; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    br.close();

    int result = 1;
    int count = 0;

    // result 를 증가시키면서, 배열의 숫자들과 나누어 떨어지면 count 를 증가시킨다.
    // count 가 3 보다 커지게 되면 반복문을 종료한다.
    while (true) {
      for (int i = 0; i < 5; i++) {
        if (result % arr[i] == 0) {
          count++;
        }
      }

      if (count >= 3) {
        bw.write(result + "\n");

        bw.flush();
        bw.close();
        return;
      }

      count = 0;
      result++;
    }
  }
}

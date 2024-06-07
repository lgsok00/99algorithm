package day09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
  - 배열을 오름차순 정렬한다.
  - 루프를 돌면서 가장 가까운 티켓의 번호를 찾는다.
 */
public class Q_16466 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    br.close();

    // 오름차순 정렬
    Arrays.sort(arr);

    int count = 0;

    for (int i = 0; i < n; i++) {
      // 티켓은 1 번 부터 시작이므로
      if (arr[i] != i + 1) {
        bw.write(i + 1 + "\n");
        count++;
        break;
      }
    }

    // 빈자리가 없다면
    if (count == 0) {
      bw.write(n + 1 + "\n");
    }

    bw.flush();
    bw.close();
  }
}

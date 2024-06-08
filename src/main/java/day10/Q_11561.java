package day10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
  - 밟을 수 있는 징검다리의 최대 수 = n 까지의 등차수열 홧수
 */
public class Q_11561 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 테스트 케이스 수
    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      // 징검다리의 총 개수 (n 번 징검다리는 꼭 밟아야 함)
      long n = Long.parseLong(br.readLine());

      long start = 1;
      long end = Integer.MAX_VALUE;
      long result = 1;

      // 이분 탐색
      while(start <= end) {
        long mid = (start + end) / 2;
        // 등차 수열
        long prev = mid * (mid + 1) / 2;

        if (prev <= n) {
          // 이전 결과값과 현재 결과값 비교
          result = Math.max(mid, result);
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }
      bw.write(result + "\n");
    }
    br.close();

    bw.flush();
    bw.close();
  }
}

package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  - 과목 개수를 입력받고,
  - 과목 당 점수를 공백을 기준으로 StringTokenizer 에 저장한다.
  - 반복문을 돌면서 최대값을 찾고, 과목 점수를 sum 에 저장한다.
 */
public class Q_1546 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int max = -1;
    double sum = 0.0;

    for (int i = 0; i < n; i++) {
      int score = Integer.parseInt(st.nextToken());

      if (score > max) {
        max = score;
      }
      sum += score;
    }
    // 과목 점수를 sum 에 더해서 한번에 max 로 나눠준다.
    System.out.println(((sum / max) * 100) / n);
  }
}

package day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
  - 브루트 포스 활용
  - 시간 : 1 ~ 12, 분 : 0 ~ 60, 초 : 0 ~ 60
  - 순서를 따짐
 */
public class Q_1440 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), ":");

    // 시, 분, 초를 담을 배열
    int[] time = new int[3];

    for (int i = 0; i < 3; i++) {
      time[i] = Integer.parseInt(st.nextToken());
    }

    int result = search(time);

    bw.write(String.valueOf(result));

    br.close();
    bw.flush();
    bw.close();
  }

  private static int search(int[] time) {
    // 경우의 수를 카운트 할 변수
    int count = 0;

    // 시 분 초를 담은 배열을 전체 순회
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        // 같은 단위일 수 없으므로
        if (i == j) {
          continue;
        }
        for (int k = 0; k < 3; k++) {
          // 같은 단위일 수 없으므로
          if (k == i || k == j) {
            continue;
          }
          // 시간의 범위에 들어와 있다면
          if (time[i] > 0 && time[i] < 13 && time[j] < 60 && time[k] < 60) {
            count++;
          }
        }
      }
    }
    return count;
  }
}

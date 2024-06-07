package day09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
  - 배열에 값을 저장하면서 나무 길이의 최댓값을 찾는다.
  - 이 값을 기준으로 이분 탐색을 진행한다.
 */
public class Q_2805 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    // 나무의 수
    int n = Integer.parseInt(st.nextToken());
    // 필요한 나무의 길이
    int m = Integer.parseInt(st.nextToken());

    // 각 나무의 길이를 담을 배열
    int[] tree = new int[n];
    int min = 0;
    int max = 0;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      tree[i] = Integer.parseInt(st.nextToken());

      // 나무 길이의 최댓값
      if (max < tree[i]) {
        max = tree[i];
      }
    }

    // 이분 탐색
    while (min < max) {
      int mid = (min + max) / 2;
      long sum = 0;

      for (int i = 0; i < n; i++) {
        // 나무에서 잘린 길이 > 0 때만 sum 에 더해준다.
        if (tree[i] - mid > 0) {
          sum += (tree[i] - mid);
        }
      }

      /*
        - 잘린 길이의 합이 m 보다 작으면 -> 더 잘라야 한다.
        - max 를 줄인다.
       */
      if (sum < m) {
        max = mid;
        /*
          - 잘린 길이의 합이 m 보다 크다면 -> 덜 잘라야 한다.
          - 자를 높이를 올려야 하므로 min 을 올린다.
         */
      } else {
        min = mid + 1;
      }
    }

    // min 값이 max 값을 넘을 때까지 반복하므로 - 1
    bw.write(min - 1 + "\n");

    bw.flush();
    bw.close();
  }
}

package day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
  - 브루트 포스 활용
  - 3중 for 문으로 경우의 수 찾기
    - 첫 번째 카드가 m 보다 크거나, 첫 번째 카드와 두 번째 카드의 합이 m 보다 크면 continue
 */
public class Q_2798 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    // 카드의 개수
    int n = Integer.parseInt(st.nextToken());
    // 카드 세 장의 최대 합
    int m = Integer.parseInt(st.nextToken());

    int[] card = new int[n];
    st = new StringTokenizer(br.readLine());
    
    for (int i = 0; i < n; i++) {
      card[i] = Integer.parseInt(st.nextToken());
    }
    
    int sum = combination(card, n, m);

    bw.write(sum + "\n");

    br.close();
    bw.flush();
    bw.close();
  }

  private static int combination(int[] arr, int n, int m) {
    int result = 0;
    // 순서에 상관없이 세 장의 카드를 골라야 하므로 n - 2 까지 순회
    for (int i = 0; i < n - 2; i++) {
      // 첫 번째 카드가 m 보다 크다면
      if (arr[i] > m) {
        continue;
      }
      // 두 번째 카드는 첫 번째 카드 다음부터 n - 1 까지 순회
      for (int j = i + 1; j < n - 1; j++) {
        // 첫 번째 + 두 번째 카드의 합이 m 보다 크다면
        if (arr[i] + arr[j] > m) {
          continue;
        }
        // 세 번째 카드는 두 번째 카드 다음부터 n - 1 까지 순회
        for (int k = j + 1; k < n; k++) {
          int sum = arr[i] + arr[j] + arr[k];

          // 세 카드의 합이 m 이라면
          if (sum == m) {
            return sum;
          }

          // 세 카드의 합이 이전 합보단 크고, m 보단 작다면
          if (result < sum && sum < m) {
            result = sum;
          }
        }
      }
    }
    return result;
  }
}

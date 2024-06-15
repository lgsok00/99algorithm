package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
  - 브루트 포스 접근?
    - 하나의 숫자당 부분 수열의 길이 확인
  - DP적 접근
    - 50 => 50 30 20 10
    - 30 => 30 20 10
    - 순환 구조를 가지고 있다.
 */
public class Q_11053 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];

    String[] str = br.readLine().split(" ");

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(str[i]);
    }

    int[] memo = new int[n];
    memo[0] = 1;

    // 바텀 업
    for (int i = 1; i < n; i++) {
      memo[i] = 1;
      // 메모이제이션
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          memo[i] = Math.max(memo[i], memo[j] + 1);
        }
      }
    }

    int answer = Arrays.stream(memo).max().getAsInt();
    System.out.println(answer);
  }
}

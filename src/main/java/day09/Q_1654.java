package day09;

import java.util.Arrays;
import java.util.Scanner;

/*
  - Parametric Search
  - 1 <= L <= Max (L : 랜선 하나의 길이)
 */
public class Q_1654 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int k = in.nextInt();
    int n = in.nextInt();

    long[] arr = new long[k];

    for (int i = 0; i < k; i++) {
      arr[i] = in.nextInt();
    }

    in.close();

    long max = Arrays.stream(arr).max().orElseThrow();

    long start = 1;
    long end = max;

    while (start <= end) {
      long mid = (start + end) / 2;
      long sum = Arrays.stream(arr).map(e -> e / mid).sum();

      if (sum >= n) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    System.out.println(end);
  }
}

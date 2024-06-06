package day08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
  - 이분 탐색을 활용한다.
 */
public class Q_1920 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] numbers = new int[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    // 이분 탐색을 위해 비교 대상을 정렬한다.
    Arrays.sort(numbers);

    // 배열에서 찾으려는 수
    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    int number;

    for (int i = 0; i < m; i++) {
      number = Integer.parseInt(st.nextToken());
      if (binarySearch(numbers, number)) {
        bw.write("1\n");
      } else {
        bw.write("0\n");
      }
    }

    br.close();
    bw.flush();
    bw.close();
  }

  // 이분 탐색
  private static boolean binarySearch(int[] numbers, int number) {
    int start = 0;
    int end = numbers.length - 1;

    while (start <= end) {
      int mid = (start + end) / 2;
      // 찾으려는 값이 중간 인덱스의 값보다 작다면
      if (numbers[mid] > number) {
        end = mid - 1;
        // 찾으려는 값이 중간 인덱스의 값보다 크다면
      } else if (numbers[mid] < number) {
        start = mid + 1;
      } else {
        return true;
      }
    }
    return false;
  }
}
